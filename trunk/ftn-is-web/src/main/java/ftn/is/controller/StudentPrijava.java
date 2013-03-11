package ftn.is.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.ws.BindingProvider;
import ftn.is.serviceGen.student.Predmet;
import ftn.is.serviceGen.student.PrijavljenIspit;
import ftn.is.serviceGen.student.StudentService;
import ftn.is.serviceGen.student.StudentServiceService;


@Named
@SessionScoped
public class StudentPrijava implements Serializable{
	private static final long serialVersionUID = -932308164983583486L;
	
	private StudentServiceService studServiceS;
	private StudentService studService;
	private List<Predmet> predmetiZaPrijavu;
	private List<PrijavljenIspit> prijavljeniIspiti;
	
	@Inject
	private StudentLogin studentLogin;

	
	
	@PostConstruct
	public void init(){
		studServiceS = new StudentServiceService();
		studService = studServiceS.getStudentServicePort();
		initData();
	}
	
	private void initData(){
		//stavljam u messageContext studentAlias kako bi handler znao koji kljuc da koristi za kriptovanje
		((BindingProvider)studService).getRequestContext().put("studentAlias", studentLogin.getCurrentStudent().getUsername());
		predmetiZaPrijavu = studService.listaPredmetaZaPrijavu(studentLogin.getCurrentStudent().getStudentId());
		prijavljeniIspiti = studService.listaPrijavljenihIspita(studentLogin.getCurrentStudent().getStudentId());
		((BindingProvider)studService).getRequestContext().remove("studentAlias");
	}

	
	public void save(Predmet pred){
		PrijavljenIspit p = new PrijavljenIspit();
		p.setStudent(studentLogin.getCurrentStudent());
		p.setPredmet(pred);
		p.setPrijavljenIspitId(0);
		p.setDatum(new Date());
		
		List<PrijavljenIspit> temp = new ArrayList<PrijavljenIspit>();
		temp.add(p);
	
		//stavljam u messageContext studentAlias kako bi handler znao koji kljuc da koristi za kriptovanje
		((BindingProvider)studService).getRequestContext().put("studentAlias", studentLogin.getCurrentStudent().getUsername());
		studService.prijavaIspita(temp);
		((BindingProvider)studService).getRequestContext().remove("studentAlias");
		
		initData();
	}
	
	
	public List<Predmet>getPredmetiZaPrijavu(){
		return predmetiZaPrijavu;
	}
	
	public List<PrijavljenIspit>getPrijavljeniIspiti(){
		return prijavljeniIspiti;
	}
	
}
