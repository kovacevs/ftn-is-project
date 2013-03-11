package ftn.is.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;

import ftn.is.serviceGen.nastavnik.Grupa;
import ftn.is.serviceGen.nastavnik.NastavnikService;
import ftn.is.serviceGen.nastavnik.NastavnikServiceService;
import ftn.is.serviceGen.nastavnik.Predmet;
import ftn.is.serviceGen.nastavnik.Student;


@Named
@SessionScoped
public class NastavnikPripadnost implements Serializable{
	private static final long serialVersionUID = -6044132748121227992L;
	
	private NastavnikServiceService nasServiceS;
	private NastavnikService nasService;
	private List<Predmet> predmeti;
	private List<Grupa> grupe;
	private Predmet selectedPredmet;
	private Grupa selectedGrupa;
	private List<Student> studentiUGrupi;
	private List<Student> studentiVanGrupe;
	
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
		initStudenti();
	}
	
	public void initStudenti(){
		studentiUGrupi = nasService.getStudentsInGroup(selectedGrupa.getGrupaId());
		studentiVanGrupe = nasService.getStudentsNotInGroups(selectedPredmet.getPredmetId());
	}
	
	public void addStudentToGroup(Student student){		
		nasService.addStudentToGroup(student, selectedGrupa);
		initStudenti();
	}
	
	public void removeStudentFromGroup(Student student){
		nasService.removeStudentFromGroup(student, selectedGrupa);
		initStudenti();
	}
	
	public void selectPredmet(ValueChangeEvent e){
		if(e.getNewValue()!=null){
			selectedPredmet = (Predmet)e.getNewValue();
			grupe = nasService.getGrupeForPredmet(selectedPredmet.getPredmetId());
			selectedGrupa = !grupe.isEmpty() ? grupe.get(0) : new Grupa();
			initStudenti();	
		}
	}
	
	public void selectGrupa(ValueChangeEvent e){
		if(e.getNewValue()!=null){
			selectedGrupa = (Grupa)e.getNewValue();
			initStudenti();
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

	public List<Student> getStudentiUGrupi() {
		return studentiUGrupi;
	}

	public List<Student> getStudentiVanGrupe() {
		return studentiVanGrupe;
	}

}
