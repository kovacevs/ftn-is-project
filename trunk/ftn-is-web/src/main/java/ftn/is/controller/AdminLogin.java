package ftn.is.controller;

import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import ftn.is.serviceGen.administrator.*;
import ftn.is.util.LoginFormData;



@SessionScoped
@Named
public class AdminLogin implements Serializable {
	public static final long serialVersionUID = 7606429130159131515L;
	
	   @Inject
	   private LoginFormData formData;
	   
	   private Administrator currentAdmin;

	   public void login() throws Exception {
		   
		  if(currentAdmin==null){
		      AdminServiceService admServ = new AdminServiceService();
		      AdminService as = admServ.getAdminServicePort();
			   
		      Administrator a = as.getAdmin(formData.getUsername(),formData.getPassword());
		      if (a != null) {
		         this.currentAdmin = a;
		         FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("AdminLogin", a);
		      }
		      else{
		    	 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Greska! Ne postojeci user ili pass"));
		      }
		  }
	   }

	   public void logout() {
	      //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Goodbye, " + currentUser.getName()));
		   HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		   if (session != null) {
			   currentAdmin = null;
			   session.removeAttribute("AdminLogin");
			   session.invalidate();
			   try { //Zbog korsicenja filtera ovde moram ovako( moglo je u faces-configu da se stavi <from-view-id>* <from-action>#{adminLogin.logout} pa redirekcija, ali ga filter presretne i ostane na istoj strani
				   FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()+"/index.jsf");
			   } catch (IOException e) {
				   e.printStackTrace();
			   }
		   }
	      
	   }

	   public boolean isLoggedIn() {
	      return currentAdmin != null;
	   }

	   public Administrator getCurrentAdmin() {
	      return currentAdmin;
	   }
}
