package ftn.is.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ftn.is.model.Grupa;
import ftn.is.model.Nastavnik;
import ftn.is.model.Obaveza;
import ftn.is.model.Ocena;
import ftn.is.model.OdslusanPredmet;
import ftn.is.model.Predmet;
import ftn.is.model.PripadnostGrupi;
import ftn.is.model.Prisustvo;
import ftn.is.model.Student;


@Stateless
@WebService
public class NastavnikService {

	   @Inject
	   private EntityManager em;
	
/* ==========================
 * Rad sa podacima nastavnika
 */
	   public Nastavnik getNastavnik(String user, String pass){
		   TypedQuery<Nastavnik> qnas = em.createQuery("SELECT e From Nastavnik e WHERE e.username=?1 AND e.lozinka=?2", Nastavnik.class);
		   qnas.setParameter(1,user);
		   qnas.setParameter(2,pass);
		   List<Nastavnik> tempNas = qnas.getResultList();
		   if(!tempNas.isEmpty()){
			   System.out.printf("INFO: nastavnik username and password found! %s [service returning Nastavnik object]%n",tempNas.get(0).getUsername());
			   return tempNas.get(0);
		   }
		   else{
			   System.out.println("INFO: nastavnik username password not found! [service returning null]");
			   return null;
		   }
	   }
	   
	   public boolean editNastavnik(Nastavnik nas){
		   TypedQuery<Nastavnik> qnas = em.createQuery("SELECT e From Nastavnik e WHERE e.username=?1 AND NOT e.nastavnikId=?2", Nastavnik.class);
		   qnas.setParameter(1,nas.getUsername());
		   qnas.setParameter(2,nas.getNastavnikId());
		   List<Nastavnik> tempNas = qnas.getResultList();
		   if(tempNas.isEmpty()){
			   em.merge(nas);
			   return true;
		   }else
			   return false;
	   }
	   
/* ==========================
* Rad sa podacima Studenata
*/
	   public List<Student> listStudenti(){
		   return em.createQuery("SELECT e From Student e",Student.class).getResultList(); 
	   }
	   
	   public void deleteStudent(Student student){
		   Student s = em.find(Student.class, student.getStudentId());
		   em.remove(s);
	   }
	   
	   public boolean addStudent(Student student){
		   //provera da li postoji student sa tim usernamom ili indeksom
		   TypedQuery<Student> qstud = em.createQuery("SELECT e From Student e WHERE (e.username=?1 OR e.brojIndeksa=?2) AND NOT e.studentId=?3", Student.class);
		   qstud.setParameter(1,student.getUsername());
		   qstud.setParameter(2, student.getBrojIndeksa());
		   qstud.setParameter(3,student.getStudentId());
		   List<Student> tempStud = qstud.getResultList();
		   if(tempStud.isEmpty()){
			   student.setStudentId(0);
			   em.persist(student);
			   return true;
		   }else
			   return false;
	   }
	   
	   public boolean editStudent(Student student){
		   //provera da li postoji student sa tim usernamom ili indeksom
		   TypedQuery<Student> qstud = em.createQuery("SELECT e From Student e WHERE (e.username=?1 OR e.brojIndeksa=?2) AND NOT e.studentId=?3", Student.class);
		   qstud.setParameter(1, student.getUsername());
		   qstud.setParameter(2, student.getBrojIndeksa());
		   qstud.setParameter(3, student.getStudentId());
		   List<Student> tempStud = qstud.getResultList();
		   if(tempStud.isEmpty()){
			   em.merge(student);
			   return true;
		   }else
			   return false;
	   }
	   
/* ==========================
* Rad sa Grupama
*/	   
	   
	public List<Predmet> getPredmetiForNastavnik(int id){
		Nastavnik nas = em.find(Nastavnik.class,id);
		List<Predmet> temp = nas.getPredmeti();
		return temp;
	}
	   

	public List<Grupa> getGrupeForPredmet(int id){
		   Predmet p = em.find(Predmet.class, id);
		   List<Grupa> temp;
		   if(p!=null){
			   temp = p.getGrupe();
			   temp.size();
		   } else
			   temp = null;
		   
		   return temp;
	   }
	   
	   public void deleteGrupa(Grupa grupa){
		   Grupa mGrupa = em.find(Grupa.class, grupa.getGrupaId());
		   em.remove(mGrupa);
	   }
	   
	   public void editGrupa(Grupa grupa){
		   //izmena podataka grupe bi bilo moguce obaviti postavljajuci managed Predmet i mergovati grupu ALI:
		   //ako se promenio broj termina, ili pocetak nastave ovde se mora izmeniti to i u prisustvima
		   Grupa fGrupa = em.find(Grupa.class, grupa.getGrupaId());
		   if(fGrupa.getBrojTermina()!=grupa.getBrojTermina() || fGrupa.getPocetakNastave()!=fGrupa.getPocetakNastave()){
			   fGrupa.setPredmet(em.find(Predmet.class, grupa.getPredmet().getPredmetId()));
			   fGrupa.setBrojTermina(grupa.getBrojTermina());
			   fGrupa.setPocetakNastave(grupa.getPocetakNastave());
			   int brojZaOsvezavanje = fGrupa.getPripadnostiGrupi().size();

			   for(int i=0;i<brojZaOsvezavanje;i++){
				   Student s = fGrupa.getPripadnostiGrupi().get(i).getStudent();
				   //najlaksi nacin je da studenta obrisem pa ga dodam u grupu
				   removeStudentFromGroup(s,fGrupa);
				   addStudentToGroup(s,fGrupa);				   
			   }
		   }
	   }
	   
	   public void addGrupa(Grupa grupa){
		   grupa.setPredmet(em.find(Predmet.class, grupa.getPredmet().getPredmetId()));
		   grupa.setGrupaId(0);
		   em.persist(grupa);
	   }
	   
/* ==========================
* Pripadnost Grupama
*/	
	   
	   public List<Student> getStudentsInGroup(int grupaId){
		   Grupa grupa = em.find(Grupa.class, grupaId);
		   List<Student> temp = new ArrayList<Student>();
		   if(grupa!=null)
			   for(PripadnostGrupi p : grupa.getPripadnostiGrupi())
				   temp.add(p.getStudent());
		   
		   return temp;
	   }
	   
	   public List<Student> getStudentsNotInGroups(int predmetId){
		   //Ova lista treba da vrati studente koji nisu u odabranoj grupi ali i koji
		   //nisu ni u jednoj od ostalih grupa za taj predmet
		   List<Student> studenti = em.createQuery("SELECT e From Student e",Student.class).getResultList();
		   Predmet predmet = em.find(Predmet.class, predmetId);
		   for(Grupa grupa:predmet.getGrupe())
			   for(PripadnostGrupi p:grupa.getPripadnostiGrupi())	 
			   studenti.remove(p.getStudent());
		   return studenti;		   
	   }
	   
	   public void addStudentToGroup(Student student, Grupa grupa){
		   PripadnostGrupi pripadnost = new PripadnostGrupi();
		   pripadnost.setPripadnostId(0);
		   pripadnost.setStudent(em.find(Student.class,student.getStudentId()));
		   pripadnost.setGrupa(em.find(Grupa.class, grupa.getGrupaId()));
		   
		   em.persist(pripadnost);
		   
		//dodavanje datuma termina u prisustvo
		   pripadnost.setPrisustva(new ArrayList<Prisustvo>());
		   Calendar c = Calendar.getInstance();
		   c.setTime(pripadnost.getGrupa().getPocetakNastave());
		   for(int i=0;i<pripadnost.getGrupa().getBrojTermina();i++){
			   Prisustvo tPris = new Prisustvo();
			   tPris.setPripadnostGrupi(pripadnost);
			   tPris.setPrisustvoId(0);
			   if(i>0)
				   c.add(Calendar.DATE, 7);
			   tPris.setTermin(c.getTime());
			   pripadnost.getPrisustva().add(tPris);
			   em.persist(tPris);//dodato kad je cascada uklonjena
			   em.flush();
		   }
		   
		 //dodavanje veze odslusan predmet
		   OdslusanPredmet op = new OdslusanPredmet();
		   op.setPredmet(pripadnost.getGrupa().getPredmet());
		   op.setStudent(pripadnost.getStudent());
		   op.setOdslusan(false);
		   op.setOdslusanPredmetId(0);
		   em.persist(op);
	   
	   }
	   
	   public boolean removeStudentFromGroup(Student student, Grupa grupa){
		   Student mStudent = em.find(Student.class,student.getStudentId());
		   Grupa fGrupa = em.find(Grupa.class, grupa.getGrupaId());
		   for( PripadnostGrupi pg: fGrupa.getPripadnostiGrupi())
			   if(pg.getStudent().equals(mStudent)){
				   em.remove(pg);
				   
				  //Brisanje odslusanog predmeta - da li treba brisati?
				   for(OdslusanPredmet ods : mStudent.getOdslusaniPredmeti())
					   if(ods.getPredmet().equals(fGrupa.getPredmet()))
						   em.remove(ods);
					   
				   return true;
			   }
		   return false;	   
	   }
   
/* ==========================
* Prisustvo
*/		   
	   public List<PripadnostGrupi> getPrisustva(int grupaId){
		   Grupa grupa = em.find(Grupa.class, grupaId);
		   List<PripadnostGrupi> temp = new ArrayList<PripadnostGrupi>();
		   if(grupa!=null){ //ako nema grupa za izabrani predmet u klijentu trazice grupu sa Id=0 i bice null
			   temp = grupa.getPripadnostiGrupi();
			   temp.size();
		   }
		   return temp;
	   }
	   
	   public void setPrisustva(List<PripadnostGrupi> pripadnosti){
		   //Kada pripadnosti stignu iz webServisa, svaka pripadnost sadrzi svoju listu prisustva
		   //ali posto je veza iz pojedinacnog prisustva ka pripadnosti XmlTransient moram
		   //proci kroz svako prisustvo i postaviti povratnu vezu pre merga, inace ce se prekinuti veza
		   for(PripadnostGrupi prip:pripadnosti){
			   for(Prisustvo p:prip.getPrisustva()){
				   p.setPripadnostGrupi(prip);
				   em.merge(p);//dodato kad je uklonjena kaskada
			   }
			   
			   em.merge(prip);
		   }
	   }
	   
/* ==========================
* Obaveze
*/	
	   public List<Obaveza> getObaveze(int studentId, int predmetId){
		   Student stud = em.find(Student.class, studentId);
		   Predmet pred = em.find(Predmet.class, predmetId);
		   List<Obaveza> temp = new ArrayList<Obaveza>();
		   if(stud!=null)
			   for(Obaveza o:stud.getObaveze())
				   if(o.getPredmet()==pred)
					   temp.add(o);
		   return temp;
		   
	   }
	   
	   public void deleteObaveza(Obaveza obaveza){
		   Obaveza mObaveza = em.find(Obaveza.class, obaveza.getObavezaId());
		   em.remove(mObaveza);
	   }
	   
	   public void addObaveza(Obaveza obaveza){
		 //jer nemam cascade merge postavlejn sam stavljam managed objekte
		   
		   Student stud = em.find(Student.class, obaveza.getStudent().getStudentId());
		   Predmet pred = em.find(Predmet.class, obaveza.getPredmet().getPredmetId());
		   obaveza.setStudent(stud);
		   obaveza.setPredmet(pred);
		   obaveza.setObavezaId(0);
		   Ocena o = obaveza.getOcena();
		   obaveza.setOcena(null);
		   em.persist(obaveza);
		   if(o!=null){
			   o.setObaveza(obaveza);
			   em.persist(o);
			   obaveza.setOcena(o);
		   }
	   }
	   
	   public void editObaveza(Obaveza obaveza){
		   Obaveza mObaveza = em.find(Obaveza.class, obaveza.getObavezaId());
		   //jer nemam cascade merge postavlejn sam stavljam managed objekte
		   mObaveza.setNaziv(obaveza.getNaziv());
		   //jer je obaveza polje u oceni XmlTranisent
		   Ocena o = obaveza.getOcena();
		   if(o!=null){
			   o.setObaveza(mObaveza);
			   mObaveza.setOcena(em.merge(o));
		   }
	   }
	   
/* ==========================
* Odlusan predmet
*/	   
	   public List<OdslusanPredmet> getOdslusaniPredmeti(int predmetId){
		   Predmet pred = em.find(Predmet.class, predmetId);
		   List<OdslusanPredmet> temp = pred.getOdslusaniPredmeti();
		   temp.size();
		   return temp;
	   }
	   
	   public void setOdslusaniPredmeti(List<OdslusanPredmet> odslusani){
		   for(OdslusanPredmet ods:odslusani)
			   em.merge(ods);
	   }
}
