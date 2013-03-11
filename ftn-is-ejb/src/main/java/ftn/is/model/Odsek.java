package ftn.is.model;

import java.io.Serializable;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
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
public class Odsek implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(generator="IdGenerator")
	private int odsekId;
	private String naziv;

	@XmlTransient 					//potrebno da bih izbegao circular dependecy prilikom marshallinga za xml
	@OneToMany(mappedBy="odsek")
	//@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade(value = CascadeType.DELETE)
	private Set<Predmet> predmeti = new HashSet<Predmet>();
	
	public Odsek() {
		super();
	}   
   
	public int getOdsekId() {
		return this.odsekId;
	}

	public void setOdsekId(int odsekId) {
		this.odsekId = odsekId;
	}   
	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Set<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(Set<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	
	//Ova metoda je potrebna za ubacivanje objekta u SelectOneMeny u jsf (pored konvertera)
	//public boolean equals(Object other) {
	//    return other instanceof Odsek ? odsekId == ((Odsek)other).odsekId : other == this;
	//}
}
