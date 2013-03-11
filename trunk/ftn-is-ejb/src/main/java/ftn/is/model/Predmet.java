package ftn.is.model;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Predmet implements Serializable {

	   
	@Id
	@GeneratedValue(generator="IdGenerator")
	private int predmetId;
	private String naziv;
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Nastavnik nastavnik;
	
	@ManyToOne
	private Odsek odsek;
	
	@XmlTransient  //potrebno da bih izbegao circular dependecy prilikom marshallinga za xml
	@OneToMany(mappedBy="predmet")
	@Cascade(value = CascadeType.DELETE)
	private List<Obaveza> obaveze = new ArrayList<Obaveza>();
	
	@XmlTransient
	@OneToMany(mappedBy="predmet")
	//@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade(value = CascadeType.DELETE)
	private List<Grupa> grupe = new ArrayList<Grupa>();
	
	@XmlTransient
	@OneToMany(mappedBy="predmet")
	@Cascade(value = CascadeType.DELETE)
	private Set<PrijavljenIspit> prijavljeniIspiti = new HashSet<PrijavljenIspit>();
	
	@XmlTransient
	@OneToMany(mappedBy="predmet")
	//@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade(value = CascadeType.DELETE)
	private List<OdslusanPredmet> odslusaniPredmeti = new ArrayList<OdslusanPredmet>();
	
	
	public Predmet() {
		super();
	}   
	
	public int getPredmetId() {
		return this.predmetId;
	}

	public void setPredmetId(int predmetId) {
		this.predmetId = predmetId;
	}   
	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	public Nastavnik getNastavnik() {
		return nastavnik;
	}
	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}
	
	public Odsek getOdsek() {
		return odsek;
	}
	public void setOdsek(Odsek odsek) {
		this.odsek = odsek;
	}
	public List<Obaveza> getObaveze() {
		return obaveze;
	}
	public void setObaveze(List<Obaveza> obaveze) {
		this.obaveze = obaveze;
	}
	public List<Grupa> getGrupe() {
		return grupe;
	}
	public void setGrupe(List<Grupa> grupe) {
		this.grupe = grupe;
	}
	public Set<PrijavljenIspit> getPrijavljeniIspiti() {
		return prijavljeniIspiti;
	}
	public void setPrijavljeniIspiti(Set<PrijavljenIspit> prijavljeniIspiti) {
		this.prijavljeniIspiti = prijavljeniIspiti;
	}
	public List<OdslusanPredmet> getOdslusaniPredmeti() {
		return odslusaniPredmeti;
	}
	public void setOdslusaniPredmeti(List<OdslusanPredmet> odslusaniPredmeti) {
		this.odslusaniPredmeti = odslusaniPredmeti;
	}
   
	
}
