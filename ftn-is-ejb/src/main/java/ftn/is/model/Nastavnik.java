package ftn.is.model;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Nastavnik implements Serializable {

	   
	@Id
	@GeneratedValue(generator="IdGenerator")
	private int nastavnikId;
	private String ime;
	private String prezime;
	private String username;
	private String lozinka;
	private static final long serialVersionUID = 1L;

	@XmlTransient //potrebno da bih izbegao circular dependecy prilikom marshallinga za xml
	//eager mora da bi lista bila popunjena kada mi ustreba (inace je radilo tek sa nekim println)
	//Kada je @OneToMany property tipa List a ne Ser, fetchType.eager moze da se koristi ako postoji
	//samo jedan takav property, cim ima vise List propertyja bice exceptiona "cannot fetch multiple bags"
	@OneToMany(mappedBy="nastavnik", fetch=FetchType.EAGER) 
	//@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade(value = CascadeType.DELETE)
	private List<Predmet> predmeti = new ArrayList<Predmet>();
	
	public Nastavnik() {
		super();
	}   
	public int getNastavnikId() {
		return this.nastavnikId;
	}

	public void setNastavnikId(int nastavnikId) {
		this.nastavnikId = nastavnikId;
	}
	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}   
	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}   
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}   
	public String getLozinka() {
		return this.lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	public List<Predmet> getPredmeti() {
		return predmeti;
	}
	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
}
