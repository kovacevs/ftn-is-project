package ftn.is.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import ftn.is.model.Obaveza;
import ftn.is.model.OdslusanPredmet;
import ftn.is.model.Predmet;
import ftn.is.model.PrijavljenIspit;
import ftn.is.model.Student;


@Stateless
@WebService
@HandlerChain(file="/handler-chain.xml")
public class StudentService {

	   @Inject
	   private EntityManager em;
	   
	   @Resource
	   private WebServiceContext wsContext;
	
	   public Student getStudent(String user, String pass){
		   TypedQuery<Student> qstud = em.createQuery("SELECT e From Student e WHERE e.username=?1 AND e.lozinka=?2", Student.class);
		   qstud.setParameter(1,user);
		   qstud.setParameter(2,pass);
		   List<Student> tempStud = qstud.getResultList();
		   if(!tempStud.isEmpty()){
			   System.out.printf("INFO: student username and password found! %s [service returning Student object]%n",tempStud.get(0).getUsername());
			   return tempStud.get(0);
		   }
		   else{
			   System.out.println("INFO: student username password not found! [service returning null]");
			   return null;
		   }
	   }
	   
	   public void editLozinka(Student stud){
		   em.find(Student.class, stud.getStudentId());
		   em.merge(stud);
	   }
	
	   
	   public List<PrijavljenIspit> listaPrijavljenihIspita(int studentId){
		   Student stud = em.find(Student.class, studentId);
		   List<PrijavljenIspit> temp = stud.getPrijavljeniIspiti();
		   temp.size(); //trigger lazy load
		   
		   //stavljam u messageContext studentAlias kako bi handler znao koji kljuc da koristi za kriptovanje
		   MessageContext mc = wsContext.getMessageContext();
		   mc.put("studentAlias", stud.getUsername());
		   System.out.println("listaPrijavljenihIspita");
		   return temp;
	   }
	   
	   public List<Predmet> listaPredmetaZaPrijavu(int studentId){
		   Student stud = em.find(Student.class, studentId);
		   List<Predmet> temp = new ArrayList<Predmet>();
		   for(OdslusanPredmet odslusan : stud.getOdslusaniPredmeti())
			   if(odslusan.getOdslusan()){ 
				   temp.add(odslusan.getPredmet());
				   
				   //nasao je odslusan predmet, sad jos proveriti da nema konacnu ocenu
				   for(Obaveza obav:stud.getObaveze())
					   if(obav.getPredmet().equals(odslusan.getPredmet()) && obav.getNaziv().equals("Konacna ocena"))
						   temp.remove(odslusan.getPredmet());
				   
				    //jos jedan uslov: ako je prijavljen u poslednja 24h ne moze se prijaviti vise
		   			for(PrijavljenIspit pi:stud.getPrijavljeniIspiti())
		   				if(pi.getPredmet().equals(odslusan.getPredmet())){
		   					Calendar now = Calendar.getInstance();
		   					Calendar d = Calendar.getInstance();
		   					d.setTime(pi.getDatum());
		   					d.add(Calendar.DATE, 1);
		   					if(now.before(d))
		   						temp.remove(odslusan.getPredmet());
		   				}
					   
			   }
		   
		   //stavljam u messageContext studentAlias kako bi handler znao koji kljuc da koristi za kriptovanje
		   MessageContext mc = wsContext.getMessageContext();
		   mc.put("studentAlias", stud.getUsername());
		   System.out.println("listaPredmetaZaPrijavu");
		   return temp;
	   }
	   
	   public void prijavaIspita(List<PrijavljenIspit> prijaviIspite){
		   if(prijaviIspite!=null){
			   Student stud = em.find(Student.class, prijaviIspite.get(0).getStudent().getStudentId());
			   for(PrijavljenIspit pi:prijaviIspite){
				   Predmet pred = em.find(Predmet.class, pi.getPredmet().getPredmetId());
				   pi.setStudent(stud);
				   pi.setPredmet(pred);
				   pi.setPrijavljenIspitId(0);
				   em.persist(pi);
			   }
			   //Iako ova funkcija ne vraca nikakve podake u body se vidi naziv funkcije pa se ipak kriptuje
			   MessageContext mc = wsContext.getMessageContext();
			   mc.put("studentAlias", stud.getUsername());
			   System.out.println("prijavaIspita");
		   }
	   }
}
