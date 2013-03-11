package ftn.is.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import ftn.is.model.*;
import ftn.is.util.xmlAdapters.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DbBackup {
	
	private Date timeStamp = new Date();
	
	@XmlElementWrapper
	@XmlElement(name="administrator")
	@XmlJavaTypeAdapter(XmlAdapterAdministrator.class) 
	private List<Administrator> administratori = new ArrayList<>();
	
	@XmlElementWrapper
	@XmlElement(name="odsek")
	@XmlJavaTypeAdapter(XmlAdapterOdsek.class) 
	private List<Odsek> odseci = new ArrayList<>();
	
	@XmlElementWrapper
	@XmlElement(name="nastavnik")
	@XmlJavaTypeAdapter(XmlAdapterNastavnik.class) 
	private List<Nastavnik> nastavnici = new ArrayList<>();
	
	@XmlElementWrapper
	@XmlElement(name="student")
	@XmlJavaTypeAdapter(XmlAdapterStudent.class) 
	private List<Student> studenti = new ArrayList<>();
	
	@XmlElementWrapper
	@XmlElement(name="predmet")
	//Neophodan mi je adapter da bih u predmetu imao reference na odsek i nastavnik (ID) a ne sve podatke
	@XmlJavaTypeAdapter(XmlAdapterPredmet.class) 
	private List<Predmet> predmeti = new ArrayList<>();
	
	@XmlElementWrapper
	@XmlElement(name="grupa")
	@XmlJavaTypeAdapter(XmlAdapterGrupa.class) 
	private List<Grupa> grupe = new ArrayList<>();

	@XmlElementWrapper
	@XmlElement(name="pripadnostGrupi")
	@XmlJavaTypeAdapter(XmlAdapterPripadnostGrupi.class) 
	private List<PripadnostGrupi> pripadnostiGrupi = new ArrayList<>();
	
	@XmlElementWrapper
	@XmlElement(name="prisustvo")
	@XmlJavaTypeAdapter(XmlAdapterPrisustvo.class) 
	private List<Prisustvo> prisustva = new ArrayList<>();
	
	@XmlElementWrapper
	@XmlElement(name="obaveza")
	@XmlJavaTypeAdapter(XmlAdapterObaveza.class) 
	private List<Obaveza> obaveze = new ArrayList<>();
	
	@XmlElementWrapper
	@XmlElement(name="ocena")
	@XmlJavaTypeAdapter(XmlAdapterOcena.class) 
	private List<Ocena> ocene = new ArrayList<>();
	
	@XmlElementWrapper
	@XmlElement(name="prijavljenIspit")
	@XmlJavaTypeAdapter(XmlAdapterPrijavljenIspit.class) 
	private List<PrijavljenIspit> prijavljeniIspiti = new ArrayList<>();
	
	@XmlElementWrapper
	@XmlElement(name="odslusanPredmet")
	@XmlJavaTypeAdapter(XmlAdapterOdslusanPredmet.class) 
	private List<OdslusanPredmet> odslusaniPredmeti = new ArrayList<>();
	
	
	public void loadEverything(EntityManager em){
		
		System.out.println("Loading DbBackup data from Database...");
		
		administratori = em.createQuery("SELECT e From Administrator e",Administrator.class).getResultList();
		odseci = em.createQuery("SELECT e From Odsek e",Odsek.class).getResultList();
		nastavnici = em.createQuery("SELECT e From Nastavnik e",Nastavnik.class).getResultList();
		studenti = em.createQuery("SELECT e From Student e",Student.class).getResultList();
		predmeti = em.createQuery("SELECT e From Predmet e",Predmet.class).getResultList();
		grupe = em.createQuery("SELECT e From Grupa e",Grupa.class).getResultList();
		pripadnostiGrupi = em.createQuery("SELECT e From PripadnostGrupi e",PripadnostGrupi.class).getResultList();
		prisustva = em.createQuery("SELECT e From Prisustvo e",Prisustvo.class).getResultList();
		obaveze = em.createQuery("SELECT e From Obaveza e",Obaveza.class).getResultList();
		ocene = em.createQuery("SELECT e From Ocena e",Ocena.class).getResultList();
		prijavljeniIspiti = em.createQuery("SELECT e From PrijavljenIspit e",PrijavljenIspit.class).getResultList();
		odslusaniPredmeti = em.createQuery("SELECT e From OdslusanPredmet e",OdslusanPredmet.class).getResultList();
		timeStamp = new Date();
	}
	
	public void removeEverything(EntityManager em){
		System.out.println("Removing everything from database...");

		em.createQuery("DELETE FROM OdslusanPredmet o").executeUpdate();
		em.createQuery("DELETE FROM PrijavljenIspit o").executeUpdate();
		em.createQuery("DELETE FROM Ocena o").executeUpdate();
		em.createQuery("DELETE FROM Obaveza o").executeUpdate();
		em.createQuery("DELETE FROM Prisustvo o").executeUpdate();
		em.createQuery("DELETE FROM PripadnostGrupi o").executeUpdate();
		em.createQuery("DELETE FROM Grupa o").executeUpdate();
		em.createQuery("DELETE FROM Predmet o").executeUpdate();
		em.createQuery("DELETE FROM Student o").executeUpdate();
		em.createQuery("DELETE FROM Nastavnik o").executeUpdate();
		em.createQuery("DELETE FROM Odsek o").executeUpdate();
		em.createQuery("DELETE FROM Administrator o").executeUpdate();
		em.flush();
	}
	
	public void persistEverything(EntityManager em){
		System.out.println("Merging DbBackup to database...");
		//Napomena: posto entitiji koje zelimo sacuvati imaju setova ID, ne moze se pozvati
		//em.merge jer ce baciti exception ...detached entity passed to merge
		for(Administrator a:administratori)
			em.merge(a);
		for(Odsek o:odseci)
			em.merge(o);
		for(Nastavnik n:nastavnici)
			em.merge(n);
		for(Student s:studenti)
			em.merge(s);
		for(Predmet p:predmeti)
			em.merge(p);
		for(Grupa g:grupe)
			em.merge(g);
		for(PripadnostGrupi pg:pripadnostiGrupi)
			em.merge(pg);
		for(Prisustvo p:prisustva)
			em.merge(p);
		for(Obaveza o:obaveze)
			em.merge(o);
		for(Ocena o:ocene)
			em.merge(o);
		for(PrijavljenIspit pi:prijavljeniIspiti)
			em.merge(pi);
		for(OdslusanPredmet op:odslusaniPredmeti)
			em.merge(op);
	}
	
	public List<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}

	public List<Odsek> getOdseci() {
		return odseci;
	}

	public void setOdseci(List<Odsek> odseci) {
		this.odseci = odseci;
	}

	public List<Nastavnik> getNastavnici() {
		return nastavnici;
	}

	public void setNastavnici(List<Nastavnik> nastavnici) {
		this.nastavnici = nastavnici;
	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public List<Grupa> getGrupe() {
		return grupe;
	}

	public void setGrupe(List<Grupa> grupe) {
		this.grupe = grupe;
	}

	public List<Administrator> getAdministratori() {
		return administratori;
	}

	public void setAdministratori(List<Administrator> administratori) {
		this.administratori = administratori;
	}

	public List<PripadnostGrupi> getPripadnostiGrupi() {
		return pripadnostiGrupi;
	}

	public void setPripadnostiGrupi(List<PripadnostGrupi> pripadnostiGrupi) {
		this.pripadnostiGrupi = pripadnostiGrupi;
	}

	public List<Prisustvo> getPrisustva() {
		return prisustva;
	}

	public void setPrisustva(List<Prisustvo> prisustva) {
		this.prisustva = prisustva;
	}

	public List<Obaveza> getObaveze() {
		return obaveze;
	}

	public void setObaveze(List<Obaveza> obaveze) {
		this.obaveze = obaveze;
	}

	public List<Ocena> getOcene() {
		return ocene;
	}

	public void setOcene(List<Ocena> ocene) {
		this.ocene = ocene;
	}

	public List<PrijavljenIspit> getPrijavljeniIspiti() {
		return prijavljeniIspiti;
	}

	public void setPrijavljeniIspiti(List<PrijavljenIspit> prijavljeniIspiti) {
		this.prijavljeniIspiti = prijavljeniIspiti;
	}

	public List<OdslusanPredmet> getOdslusaniPredmeti() {
		return odslusaniPredmeti;
	}

	public void setOdslusaniPredmeti(List<OdslusanPredmet> odslusaniPredmeti) {
		this.odslusaniPredmeti = odslusaniPredmeti;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}	
	
}
