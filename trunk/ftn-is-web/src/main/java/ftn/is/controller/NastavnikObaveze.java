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
import ftn.is.serviceGen.nastavnik.Obaveza;
import ftn.is.serviceGen.nastavnik.Ocena;
import ftn.is.serviceGen.nastavnik.Predmet;
import ftn.is.serviceGen.nastavnik.Student;


@Named
@SessionScoped
public class NastavnikObaveze implements Serializable{
	private static final long serialVersionUID = -6044132748121227992L;
	
	private NastavnikServiceService nasServiceS;
	private NastavnikService nasService;
	
	private List<Predmet> predmeti;
	private List<Grupa> grupe;
	private List<Student> studenti;
	private Predmet selectedPredmet;
	private Grupa selectedGrupa;
	private Student selectedStudent;
	
	private List<Obaveza> obaveze;
	private Obaveza newObaveza;
	
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
		studenti = nasService.getStudentsInGroup(selectedGrupa.getGrupaId());
		selectedStudent = !studenti.isEmpty() ? studenti.get(0) : new Student();
		initNewObaveza();
		initData();
	}
	
	public void initData(){
		obaveze = nasService.getObaveze(selectedStudent.getStudentId(),selectedPredmet.getPredmetId());
	}
	
	public void initNewObaveza(){
		newObaveza = new Obaveza();
		newObaveza.setOcena(new Ocena());
	}
	
	public void addObaveza(){		
	    boolean ima = false;
	    if(obaveze!=null || !obaveze.isEmpty())
	    	for(Obaveza o : obaveze)
	    		if(o.getObavezaId()==newObaveza.getObavezaId())
	    			ima=true;
	    
	    if(newObaveza.getOcena().getOcena()==0){
	    	newObaveza.setOcena(null);
	    }
	    
	    newObaveza.setPredmet(selectedPredmet);
	    newObaveza.setStudent(selectedStudent);
	    
		if(!ima){
			nasService.addObaveza(newObaveza);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nova obaveza dodata"));
		}else{
			nasService.editObaveza(newObaveza);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Obaveza izmenjena"));
		}

		initNewObaveza();
		initData();
	}
	
	public void removeObaveza(Obaveza o){
		nasService.deleteObaveza(o);
		initData();
	}
	
	public void editObaveza(Obaveza o){
		if(o.getOcena()==null)
			o.setOcena(new Ocena());
		newObaveza = o;
	}
	
	public void selectPredmet(ValueChangeEvent e){
		if(e.getNewValue()!=null){
			selectedPredmet = (Predmet)e.getNewValue();
			grupe = nasService.getGrupeForPredmet(selectedPredmet.getPredmetId());
			selectedGrupa = !grupe.isEmpty() ? grupe.get(0) : new Grupa();
			studenti = nasService.getStudentsInGroup(selectedGrupa.getGrupaId());
			selectedStudent = !studenti.isEmpty() ? studenti.get(0) : new Student();
			initData();
		}		
	}
	
	public void selectGrupa(ValueChangeEvent e){
		if(e.getNewValue()!=null){
			selectedGrupa = (Grupa)e.getNewValue();
			studenti = nasService.getStudentsInGroup(selectedGrupa.getGrupaId());
			selectedStudent = !studenti.isEmpty() ? studenti.get(0) : new Student();
			initData();
		}
	}
	
	public void selectStudent(ValueChangeEvent e){
		if(e.getNewValue()!=null){
			selectedStudent = (Student)e.getNewValue();
			initData();
		}
	}
	
	public List<Grupa> getGrupe() {
		return grupe;
	}

	public List<Predmet> getPredmeti(){
		return predmeti;
	}

	public List<Student> getStudenti(){
		return studenti;
	}
	
	public Student getSelectedStudent(){
		return selectedStudent;
	}
	
	public void setSelectedStudent(Student s){
		//this.selectedStudent = s
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

	public List<Obaveza> getObaveze() {
		return obaveze;
	}

	public Obaveza getNewObaveza() {
		return newObaveza;
	}

	public void setNewObaveza(Obaveza newObaveza) {
		this.newObaveza = newObaveza;
	}


}
