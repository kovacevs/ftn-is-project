package ftn.is.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import ftn.is.serviceGen.nastavnik.NastavnikService;
import ftn.is.serviceGen.nastavnik.NastavnikServiceService;
import ftn.is.serviceGen.nastavnik.Student;


@Named
@SessionScoped
public class NastavnikStudenti implements Serializable{
	private static final long serialVersionUID = 9214866893364376L;

	private NastavnikServiceService nasServiceS;
	private NastavnikService nasService;
	private List<Student> studenti;
	private Student newStudent;
	
	@PostConstruct
	public void init(){
		nasServiceS = new NastavnikServiceService();
		nasService = nasServiceS.getNastavnikServicePort();
		
		initnewStudent();
		studenti = nasService.listStudenti();
	}
	
	public void addStudent(){		
	    boolean ima = false;
	    for(Student stud : studenti)
	    	if(stud.getStudentId()==newStudent.getStudentId())
	    		ima=true;
	    
		if(!ima){
			if(nasService.addStudent(newStudent)){
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Novi student dodat"));
				initnewStudent();
				studenti = nasService.listStudenti();
			}
			else
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Greska! Postoji student sa unetim indeksom ili username-om"));
		}else{
			if(nasService.editStudent(newStudent)){
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Student izmenjen"));
				initnewStudent();
				studenti = nasService.listStudenti();
			}else
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Greska! Postoji student sa unetim indeksom ili username-om"));
		}
	}
	
	public void removeStudent(Student stud){
	    nasService.deleteStudent(stud);
	    studenti = nasService.listStudenti();
	}
	
	public void editStudent(Student stud){
		newStudent = stud;
	}
	
	public List<Student> getStudenti() {
		return studenti;
	}

	public Student getNewStudent() {
		return newStudent;
	}

	public void initnewStudent(){
		newStudent = new Student();
	}
}
