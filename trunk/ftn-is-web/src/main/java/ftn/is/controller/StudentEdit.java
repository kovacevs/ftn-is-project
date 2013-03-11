package ftn.is.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import ftn.is.serviceGen.student.StudentService;
import ftn.is.serviceGen.student.StudentServiceService;


@Named
@SessionScoped
public class StudentEdit implements Serializable{
	private static final long serialVersionUID = -932308164983583486L;
	
	private StudentServiceService studServiceS;
	private StudentService studService;
	
	private String lozinka1;
	private String lozinka2;
	
	@Inject
	private StudentLogin studentLogin;

	
	
	@PostConstruct
	public void init(){
		studServiceS = new StudentServiceService();
		studService = studServiceS.getStudentServicePort();

		initLozinka();
	}
	
	public void editLozinka(){
		if(!lozinka1.isEmpty() && lozinka1.contentEquals(lozinka2)){
			studentLogin.getCurrentStudent().setLozinka(lozinka1);
			studService.editLozinka(studentLogin.getCurrentStudent());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Lozinka promenjena"));
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Greska! Niste uneli jednake lozinke"));
		}
		initLozinka();
	}
	
	public String getLozinka1() {
		return lozinka1;
	}

	public void setLozinka1(String lozinka1) {
		this.lozinka1 = lozinka1;
	}

	public String getLozinka2() {
		return lozinka2;
	}

	public void setLozinka2(String lozinka2) {
		this.lozinka2 = lozinka2;
	}
	
	public void initLozinka(){
		lozinka1="";
		lozinka2="";
	}
	
}
