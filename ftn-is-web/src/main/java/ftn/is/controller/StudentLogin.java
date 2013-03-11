package ftn.is.controller;

import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import ftn.is.serviceGen.student.Student;
import ftn.is.serviceGen.student.StudentService;
import ftn.is.serviceGen.student.StudentServiceService;
import ftn.is.util.LoginFormData;



@SessionScoped
@Named
public class StudentLogin implements Serializable {
	private static final long serialVersionUID = -5241356083926015783L;

	@Inject
	   private LoginFormData formData;
	   
	   private Student currentStudent;

	   public void login() throws Exception {
		   
		  if(currentStudent==null){
		      StudentServiceService studServ = new StudentServiceService();
		      StudentService ss = studServ.getStudentServicePort();
			   
		      Student s = ss.getStudent(formData.getUsername(),formData.getPassword());
		      if (s != null) {
		         this.currentStudent = s;
		         FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("StudentLogin", s);
		      }
		      else{
		    	 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Greska! Ne postojeci user ili pass"));
		      }
		  }
	   }

	   public void logout() {
		   HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		   if (session != null) {
			   currentStudent = null;
			   session.removeAttribute("StudentLogin");
			   session.invalidate();
			   try { //Zbog korsicenja filtera ovde moram ovako( moglo je u faces-configu da se stavi <from-view-id>* <from-action>#{adminLogin.logout} pa redirekcija, ali ga filter presretne i ostane na istoj strani
				   FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()+"/index.jsf");
			   } catch (IOException e) {
				   e.printStackTrace();
			   }
		   }
	      
	   }

	   public boolean isLoggedIn() {
	      return currentStudent != null;
	   }

	   public Student getCurrentStudent() {
	      return currentStudent;
	   }
}
