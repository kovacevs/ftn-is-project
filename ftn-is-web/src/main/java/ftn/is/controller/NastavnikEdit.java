package ftn.is.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import ftn.is.serviceGen.nastavnik.Nastavnik;
import ftn.is.serviceGen.nastavnik.NastavnikService;
import ftn.is.serviceGen.nastavnik.NastavnikServiceService;


@Named
@SessionScoped
public class NastavnikEdit implements Serializable{
	private static final long serialVersionUID = -2656878666085180025L;
	
	private NastavnikServiceService nasServiceS;
	private NastavnikService nasService;
	
	private String lozinka1;
	private String lozinka2;
	
	@Inject
	private NastavnikLogin nastavnikLogin;
	private Nastavnik newNastavnik;
	
	
	@PostConstruct
	public void init(){
		nasServiceS = new NastavnikServiceService();
		nasService = nasServiceS.getNastavnikServicePort();
		
		initnewNastavnik();
		initLozinka();
	}
	
	public void editNastavnik(){
		if(nasService.editNastavnik(newNastavnik)){
			nastavnikLogin.getCurrentNastavnik().setIme(newNastavnik.getIme());
			nastavnikLogin.getCurrentNastavnik().setLozinka(newNastavnik.getLozinka());
			nastavnikLogin.getCurrentNastavnik().setPrezime(newNastavnik.getPrezime());
			nastavnikLogin.getCurrentNastavnik().setUsername(newNastavnik.getUsername());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Podaci izmenjeni"));
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Greska! Username koji ste uneli je vec u upotrebi."));
		}
	}
	
	public void editLozinka(){
		if(!lozinka1.isEmpty() && lozinka1.contentEquals(lozinka2)){
			nastavnikLogin.getCurrentNastavnik().setLozinka(lozinka1);
			nasService.editNastavnik(nastavnikLogin.getCurrentNastavnik());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Lozinka promenjena"));
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Greska! Niste uneli jednake lozinke"));
		}
		initLozinka();
	}
	
	public Nastavnik getNewNastavnik(){
		return newNastavnik;
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
	
	public void initnewNastavnik(){
		newNastavnik = new Nastavnik();
		newNastavnik.setIme(nastavnikLogin.getCurrentNastavnik().getIme());
		newNastavnik.setNastavnikId(nastavnikLogin.getCurrentNastavnik().getNastavnikId());
		newNastavnik.setPrezime(nastavnikLogin.getCurrentNastavnik().getPrezime());
		newNastavnik.setUsername(nastavnikLogin.getCurrentNastavnik().getUsername());
		newNastavnik.setLozinka(nastavnikLogin.getCurrentNastavnik().getLozinka());
	}
	
	public void initLozinka(){
		lozinka1="";
		lozinka2="";
	}
	
}
