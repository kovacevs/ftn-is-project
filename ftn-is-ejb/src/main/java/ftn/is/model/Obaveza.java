package ftn.is.model;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Obaveza implements Serializable {
	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue(generator="IdGenerator")
	private int obavezaId;
	private String naziv;

	@ManyToOne
	private Student student;
	
	@ManyToOne
	private Predmet predmet;
	
	@XmlElement(nillable = true)
	@OneToOne(mappedBy="obaveza", fetch=FetchType.EAGER)
	@Cascade(value = { CascadeType.DELETE })
	private Ocena ocena;
	
	public Obaveza() {
		super();
	}   

	public int getObavezaId() {
		return obavezaId;
	}

	public void setObavezaId(int obavezaId) {
		this.obavezaId = obavezaId;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Predmet getPredmet() {
		return predmet;
	}
	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}
	public Ocena getOcena() {
		return ocena;
	}
	public void setOcena(Ocena ocena) {
		this.ocena = ocena;
	}
   
}
