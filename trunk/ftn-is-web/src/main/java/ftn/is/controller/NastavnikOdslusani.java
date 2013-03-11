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

import ftn.is.serviceGen.nastavnik.NastavnikService;
import ftn.is.serviceGen.nastavnik.NastavnikServiceService;
import ftn.is.serviceGen.nastavnik.OdslusanPredmet;
import ftn.is.serviceGen.nastavnik.Predmet;


@Named
@SessionScoped
public class NastavnikOdslusani implements Serializable{
	private static final long serialVersionUID = -6044132748121227992L;
	
	private NastavnikServiceService nasServiceS;
	private NastavnikService nasService;
	private List<Predmet> predmeti;
	private List<OdslusanPredmet> odslusani;
	private Predmet selectedPredmet;

	
	@Inject
	private NastavnikLogin nastavnikLogin;
	
	@PostConstruct
	public void init(){
		nasServiceS = new NastavnikServiceService();
		nasService = nasServiceS.getNastavnikServicePort();
		
		predmeti = nasService.getPredmetiForNastavnik(nastavnikLogin.getCurrentNastavnik().getNastavnikId());
		selectedPredmet = !predmeti.isEmpty() ? predmeti.get(0) : new Predmet();

		initData();
	}
	
	private void initData(){
		odslusani = nasService.getOdslusaniPredmeti(selectedPredmet.getPredmetId());
	}
	
	public void save(){
		nasService.setOdslusaniPredmeti(odslusani);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Odslusanost azurirana"));
	}
	
	public List<OdslusanPredmet> getOdslusani() {
		return odslusani;
	}

	public void selectPredmet(ValueChangeEvent e){
		if(e.getNewValue()!=null){
			selectedPredmet = (Predmet)e.getNewValue();
			initData();	
		}
	}
	
	public List<Predmet> getPredmeti(){
		return predmeti;
	}

	public Predmet getSelectedPredmet() {
		return selectedPredmet;
	}

	public void setSelectedPredmet(Predmet selectedPredmet) {
		//this.selectedPredmet = selectedPredmet; 	
	}

}
