package ftn.is.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class PrijavljenIspit implements Serializable {
	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue(generator="IdGenerator")
	private int prijavljenIspitId;
	private Date datum;

	@ManyToOne
	private Predmet predmet;

	@ManyToOne
	private Student student;

	
	
	public PrijavljenIspit() {
		super();
	}   
	public int getPrijavljenIspitId() {
		return this.prijavljenIspitId;
	}

	public void setPrijavljenIspitId(int prijavljenIspitId) {
		this.prijavljenIspitId = prijavljenIspitId;
	}   
	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public Predmet getPredmet() {
		return predmet;
	}
	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
   
	
}
