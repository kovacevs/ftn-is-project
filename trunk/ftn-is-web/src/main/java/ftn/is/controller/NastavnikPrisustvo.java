package ftn.is.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import ftn.is.serviceGen.nastavnik.Grupa;
import ftn.is.serviceGen.nastavnik.NastavnikService;
import ftn.is.serviceGen.nastavnik.NastavnikServiceService;
import ftn.is.serviceGen.nastavnik.Predmet;
import ftn.is.serviceGen.nastavnik.PripadnostGrupi;
import ftn.is.serviceGen.nastavnik.Prisustvo;


@Named
@SessionScoped
public class NastavnikPrisustvo implements Serializable{
	private static final long serialVersionUID = 5341459390474970102L;
	
	private NastavnikServiceService nasServiceS;
	private NastavnikService nasService;
	private List<Predmet> predmeti;
	private List<Grupa> grupe;
	
	private Predmet selectedPredmet;
	private Grupa selectedGrupa;

	private DataModel<String> rowDataModel;
	private DataModel<Date> columnDataModel;
	private List<PripadnostGrupi> pripadnosti;
	
	@Inject
	private NastavnikLogin nastavnikLogin;
	
	@PostConstruct
	public void init(){
		nasServiceS = new NastavnikServiceService();
		nasService = nasServiceS.getNastavnikServicePort();
		
		predmeti = nasService.getPredmetiForNastavnik(nastavnikLogin.getCurrentNastavnik().getNastavnikId());
		selectedPredmet = !predmeti.isEmpty() ? predmeti.get(0) : new Predmet();
		grupe = nasService.getGrupeForPredmet(selectedPredmet.getPredmetId());
		selectedGrupa = !grupe.isEmpty() ? grupe.get(0) : new Grupa();
		initData();
	}
	
	public void initData(){
		pripadnosti = nasService.getPrisustva(selectedGrupa.getGrupaId());
		
		List<String> tempS = new ArrayList<String>();
		List<Date> tempD = new ArrayList<Date>();
		
		if(!pripadnosti.isEmpty()){
			for(Prisustvo tp: pripadnosti.get(0).getPrisustva())
				tempD.add(tp.getTermin());
		
			for(PripadnostGrupi tPripadnost:pripadnosti)
				tempS.add(tPripadnost.getStudent().getBrojIndeksa());
		}
		
		rowDataModel = new ListDataModel<String>(tempS);
		columnDataModel = new ListDataModel<Date>(tempD);
	}
	
	public DataModel<Date> getColumnDataModel(){
		return columnDataModel;
	}
	
	public DataModel<String> getRowDataModel() {
		return rowDataModel;
	}
	
	public Boolean getTableValue(){
		if(rowDataModel.isRowAvailable()){
			String indexStudenta = rowDataModel.getRowData();
			if(columnDataModel.isRowAvailable()){
				Date termin = columnDataModel.getRowData();
				
				for(PripadnostGrupi prip:pripadnosti)
					if(prip.getStudent().getBrojIndeksa().equals(indexStudenta))
						for(Prisustvo pris: prip.getPrisustva())
							if(pris.getTermin().equals(termin))
								return pris.getPrisutan();				
			}
		}
		System.out.println("GRESKA u getTableValue");
		return null;
	}
	
	public void setTableValue(Boolean val){
		if(rowDataModel.isRowAvailable()){
			String indexStudenta = rowDataModel.getRowData();
			if(columnDataModel.isRowAvailable()){
				Date termin = columnDataModel.getRowData();

				for(PripadnostGrupi prip:pripadnosti)
					if(prip.getStudent().getBrojIndeksa().equals(indexStudenta))
						for(Prisustvo pris: prip.getPrisustva())
							if(pris.getTermin().equals(termin))
								pris.setPrisutan(val);											
			}
		}
	}
	
	public void save(){				
		nasService.setPrisustva(pripadnosti);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Prisustva azurirana"));
	}

	public void selectPredmet(ValueChangeEvent e){
		if(e.getNewValue()!=null){
			selectedPredmet = (Predmet)e.getNewValue();
			grupe = nasService.getGrupeForPredmet(selectedPredmet.getPredmetId());
			selectedGrupa = !grupe.isEmpty() ? grupe.get(0) : new Grupa();
			initData();
		}
	}
	
	public void selectGrupa(ValueChangeEvent e){
		if(e.getNewValue()!=null){
			selectedGrupa = (Grupa)e.getNewValue();
			initData();
		}
	}
	
	public List<Grupa> getGrupe() {
		return grupe;
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

	public Grupa getSelectedGrupa() {
		return selectedGrupa;
	}

	public void setSelectedGrupa(Grupa selectedGrupa) {
		/* ovo je koristilo jedino da se prilikom izbora selectOneMeny setuje izabrani objekat
		 * medjutim kada sam stavio da radi eventima, ovaj set je pravio probleme jer je pamtio
		 * prethodnu vrednost, i nakon obrade eventa i rendera strane vracao selected grupu na
		 * prethodnu vrednost. Tako da posto sve setujem u eventu, ovo je cist visak
		 */
		//this.selectedGrupa = selectedGrupa;
	}

}
