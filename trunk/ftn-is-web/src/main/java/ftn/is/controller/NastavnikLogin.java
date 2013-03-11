package ftn.is.controller;

import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import ftn.is.serviceGen.nastavnik.*;
import ftn.is.util.LoginFormData;



@SessionScoped
@Named
public class NastavnikLogin implements Serializable {
	public static final long serialVersionUID = -141581889314861431L;

	@Inject
	private LoginFormData formData;
	   
	private Nastavnik currentNastavnik;
	
	public void login() throws Exception {
		   
		  if(currentNastavnik==null){
		      NastavnikServiceService nasServ = new NastavnikServiceService();
		      NastavnikService as = nasServ.getNastavnikServicePort();
			   
		      Nastavnik a = as.getNastavnik(formData.getUsername(),formData.getPassword());
		      if (a != null) {
		         this.currentNastavnik = a;
		         FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("NastavnikLogin", a);
		      }
		      else{
		    	 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Greska! Ne postojeci user ili pass"));
		      }
		  }
	   }
	
	   public void logout() {
		   HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		   if (session != null) {
			   currentNastavnik = null;
			   session.removeAttribute("NastavnikLogin");
			   session.invalidate();
			   try { //Zbog korsicenja filtera ovde moram ovako( moglo je u faces-configu da se stavi <from-view-id>* <from-action>#{adminLogin.logout} pa redirekcija, ali ga filter presretne i ostane na istoj strani
				   FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()+"/index.jsf");
			   } catch (IOException e) {
				   e.printStackTrace();
			   }
		   }
	      
	   }
	
	   public boolean isLoggedIn() {
	      return currentNastavnik != null;
	   }
	
	   public Nastavnik getCurrentNastavnik() {
	      return currentNastavnik;
	   }
}
