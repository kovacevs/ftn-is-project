package ftn.is.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;

import ftn.is.serviceGen.nastavnik.Grupa;
import ftn.is.serviceGen.nastavnik.NastavnikService;
import ftn.is.serviceGen.nastavnik.NastavnikServiceService;
import ftn.is.serviceGen.nastavnik.Predmet;


@Named
@SessionScoped
public class NastavnikGrupe implements Serializable{
	private static final long serialVersionUID = 9214866893364376L;

	private NastavnikServiceService nasServiceS;
	private NastavnikService nasService;
	private List<Predmet> predmeti;
	private List<Grupa> grupe;
	private Grupa newGrupa;
	private Predmet selectedPredmet;
	
	@Inject
	private NastavnikLogin nastavnikLogin;
	
	@PostConstruct
	public void init(){
		nasServiceS = new NastavnikServiceService();
		nasService = nasServiceS.getNastavnikServicePort();
		
		initnewGrupa();
		predmeti = nasService.getPredmetiForNastavnik(nastavnikLogin.getCurrentNastavnik().getNastavnikId());
		selectedPredmet = !predmeti.isEmpty() ? predmeti.get(0) : new Predmet();
		grupe = nasService.getGrupeForPredmet(selectedPredmet.getPredmetId());
	}
	
	public void addGrupa(){		
	    boolean ima = false;
	    if(grupe!=null || !grupe.isEmpty())
	    	for(Grupa g : grupe)
	    		if(g.getGrupaId()==newGrupa.getGrupaId())
	    			ima=true;
	    
		if(!ima){
			nasService.addGrupa(newGrupa);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nova grupa dodata"));
		}else{
			nasService.editGrupa(newGrupa);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Grupa izmenjena"));
		}
		initnewGrupa();
		grupe = nasService.getGrupeForPredmet(selectedPredmet.getPredmetId());
	}
	
	
	public void removeGrupa(Grupa grupa){
		nasService.deleteGrupa(grupa);
		grupe = nasService.getGrupeForPredmet(selectedPredmet.getPredmetId());
	}
	
	public void selectPredmet(ValueChangeEvent e){
		if(e.getNewValue()!=null){
			selectedPredmet = (Predmet)e.getNewValue();
			grupe = nasService.getGrupeForPredmet(selectedPredmet.getPredmetId());
		}
	}
	
	
	public void editGrupa(Grupa grupa){
		newGrupa = grupa;
	}
	
	public List<Grupa> getGrupe() {
		return grupe;
	}

	public List<Predmet> getPredmeti(){
		return predmeti;
	}
	
	public Grupa getnewGrupa() {
		return newGrupa;
	}

	public Predmet getSelectedPredmet() {
		return selectedPredmet;
	}

	public void setSelectedPredmet(Predmet selectedPredmet) {
		this.selectedPredmet = selectedPredmet;
	}

	public void initnewGrupa(){
		newGrupa = new Grupa();
	}
}
