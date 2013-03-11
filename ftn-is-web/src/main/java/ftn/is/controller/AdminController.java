package ftn.is.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.myfaces.custom.fileupload.UploadedFile;
import ftn.is.serviceGen.administrator.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;


@Named
@SessionScoped
public class AdminController implements Serializable {
	private static final long serialVersionUID = -853401354808392974L;
	
	private List<Odsek> odseci = new ArrayList<Odsek>();
	private Odsek newOdsek;
	
	private List<Nastavnik> nastavnici = new ArrayList<Nastavnik>();
	private Nastavnik newNastavnik;
	
	private List<Predmet> predmeti = new ArrayList<Predmet>();
	private Predmet newPredmet;
	
	@Inject
	private AdminLogin adminLogin;
	private Administrator newAdmin;
	
	private String lozinka1;
	private String lozinka2;
	
	private AdminServiceService admServ;
	private AdminService as;
	
	private UploadedFile backupFile;
	
	
	
	@PostConstruct
	public void init(){
		initnewNastavnik();
		initnewOdsek();
		initnewPredmet();
		initnewAdmin();
	    admServ = new AdminServiceService();
	    as = admServ.getAdminServicePort();
	    
	    //ucitavanje svega
	    predmeti = as.listPredmeti();
	    nastavnici = as.listNastavnici();
	    odseci = as.listOdseci();
	}
	
	public void editAdmin(){
		if(as.editAdministrator(newAdmin)){
			adminLogin.getCurrentAdmin().setIme(newAdmin.getIme());
			adminLogin.getCurrentAdmin().setLozinka(newAdmin.getLozinka());
			adminLogin.getCurrentAdmin().setPrezime(newAdmin.getPrezime());
			adminLogin.getCurrentAdmin().setUsername(newAdmin.getUsername());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Podaci izmenjeni"));
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Greska! Username koji ste uneli je vec u upotrebi."));
		}
	}
	
	public Administrator getNewAdmin(){
		return newAdmin;
	}
	
	public void editLozinka(){
		if(!lozinka1.isEmpty() && lozinka1.contentEquals(lozinka2)){
			adminLogin.getCurrentAdmin().setLozinka(lozinka1);
			as.editAdministrator(adminLogin.getCurrentAdmin());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Lozinka promenjena"));
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Greska! Niste uneli jednake lozinke"));
		}
		initLozinka();
	}
	
	public String getLozinka1(){
		return lozinka1;
	}
	
	public void setLozinka1(String s){
		lozinka1 = s;
	}
	
	public void setLozinka2(String s){
		lozinka2 = s;
	}
	
	public String getLozinka2(){
		return lozinka2;
	}
	
	public void initLozinka(){
		lozinka1="";
		lozinka2="";
	}
	
	public void initnewAdmin(){
		newAdmin = new Administrator();
		newAdmin.setAdministratorId(adminLogin.getCurrentAdmin().getAdministratorId());
		newAdmin.setIme(adminLogin.getCurrentAdmin().getIme());
		newAdmin.setLozinka(adminLogin.getCurrentAdmin().getLozinka());
		newAdmin.setPrezime(adminLogin.getCurrentAdmin().getPrezime());
		newAdmin.setUsername(adminLogin.getCurrentAdmin().getUsername());
	}
	
/* ================================================
 * Backup
 */	
	
	public void backup(){
		byte[] fajl = as.backup();
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
	    ExternalContext externalContext = facesContext.getExternalContext();

	    // Postavljanje ovih hedera otvara SaveAs dijalog     
	    externalContext.setResponseHeader("Content-Type", "application/zip");
	    Integer length = fajl.length;
	    externalContext.setResponseHeader("Content-Length", length.toString());
	    externalContext.setResponseHeader("Content-Disposition", "attachment; filename=\"Database.bkp\"");

	    try {
	    	OutputStream os = externalContext.getResponseOutputStream();
	    	os.write(fajl);
	    	os.close();
	    } catch (IOException e) {
			e.printStackTrace();
		} 

	    // Vazno! bez ovoga JSF bi probao da renderuje response, sto nece raditi jer je response sacuvan u fajlu 
	    facesContext.responseComplete(); 
	}
	
	public void restore(){

	    byte[] bytes = null;
	    if(backupFile!=null && backupFile.getSize()>0){
		    try {
				bytes = backupFile.getBytes();
			} catch (IOException e) {
				e.printStackTrace();
			}
			boolean restored = as.restore(bytes);
			
			if(restored)
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Baza uspesno restorovana."));
			else
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"GRESKA! Baza nije uspesno restorovana.",null));
	    }else{
	    	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"GRESKA! Izaberite fajl.",null));
	    }
	}
	
	
	public UploadedFile getBackupFile() {
		return backupFile;
	}

	public void setBackupFile(UploadedFile backupPath) {
		this.backupFile = backupPath;
	}

	/* ================================================
 * RAD SA PREDMETIMA
 */	
	public List<Predmet> getPredmeti(){
		return predmeti;
	}
	
	public void addPredmet(){		
	    boolean ima = false;
	    for(Predmet pred : predmeti)
	    	if(pred.getPredmetId()==newPredmet.getPredmetId())
	    		ima=true;
	    
		if(!ima){
		    as.addPredmet(newPredmet);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Novi predmet dodat"));
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Predmet izmenjen"));
			as.editPredmet(newPredmet);
		}
		
		initnewPredmet();
		predmeti = as.listPredmeti();
	}
	
	public void removePredmet(Predmet pred){
	    as.deletePredmet(pred);
	    predmeti = as.listPredmeti();
	}
	
	public void editPredmet(Predmet pred){
		newPredmet = pred;
	}
	
	public Predmet getNewPredmet() {
		return newPredmet;
	}
	
	public void initnewPredmet() {
	      newPredmet = new Predmet();
	}
	
	
/* ================================================
 * RAD SA NASTAVNICIMA
 */	
	public List<Nastavnik> getNastavnici(){
		return nastavnici;
	}
	
	public void addNastavnik(){
	    boolean ima = false;
	    for(Nastavnik nas : nastavnici)
	    	if(nas.getNastavnikId()==newNastavnik.getNastavnikId())
	    		ima=true;
	    
		if(!ima){
		    as.addNastavnik(newNastavnik);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Novi nastavnik dodat"));
		}else{
			as.editNastavnik(newNastavnik);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nastavnik izmenjen"));
		}
		
		initnewNastavnik();
		nastavnici = as.listNastavnici();
	}
	
	public void removeNastavnik(Nastavnik nas){
	    as.deleteNastavnik(nas);
	    nastavnici = as.listNastavnici();
	}
	
	public void editNastavnik(Nastavnik nas){
		newNastavnik = nas;
	}

	public Nastavnik getNewNastavnik() {
		return newNastavnik;
	}

	public void initnewNastavnik() {
	      newNastavnik = new Nastavnik();
	}
	
	
	
/* ================================================
 * RAD SA ODSECIMA
 */

	public List<Odsek> getOdseci(){
		return odseci;
	}
	
	public void addOdsek(){
	    boolean ima = false;
	    for(Odsek od : odseci)
	    	if(od.getOdsekId()==newOdsek.getOdsekId())
	    		ima=true;
	    
		if(!ima){
		    as.addOdsek(newOdsek);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Novi odsek dodat"));
		}else{
			as.editOdsek(newOdsek);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Odsek izmenjen"));
		}
		
		initnewOdsek();
		odseci = as.listOdseci();
	}
	
	public void removeOdsek(Odsek ods){
	    as.deleteOdsek(ods);
	    odseci = as.listOdseci();
	}
	
	public void editOdsek(Odsek ods){
		newOdsek = ods;
	}

	public Odsek getNewOdsek() {
		return newOdsek;
	}

	public void initnewOdsek() {
	      newOdsek = new Odsek();
	}
}
