package ftn.is.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class Grupa implements Serializable {
	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue(generator="IdGenerator")
	private int grupaId;
	private Date pocetakNastave;
	private int brojTermina;


	@ManyToOne
	private Predmet predmet;
	
	@XmlTransient
	@OneToMany(mappedBy="grupa")
	//@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade(value = CascadeType.DELETE )
	private List<PripadnostGrupi> pripadnostiGrupi = new ArrayList<PripadnostGrupi>();
	
	
	public Grupa() {
		super();
	}   
	public int getGrupaId() {
		return this.grupaId;
	}

	public void setGrupaId(int grupaId) {
		this.grupaId = grupaId;
	}   
	public Date getPocetakNastave() {
		return this.pocetakNastave;
	}

	public void setPocetakNastave(Date pocetakNastave) {
		this.pocetakNastave = pocetakNastave;
	}   
	public int getBrojTermina() {
		return this.brojTermina;
	}

	public void setBrojTermina(int brojTermina) {
		this.brojTermina = brojTermina;
	}
	public Predmet getPredmet() {
		return predmet;
	}
	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}
	public List<PripadnostGrupi> getPripadnostiGrupi() {
		return pripadnostiGrupi;
	}
	public void setPripadnostiGrupi(List<PripadnostGrupi> pripadnostiGrupi) {
		this.pripadnostiGrupi = pripadnostiGrupi;
	}
   
}
