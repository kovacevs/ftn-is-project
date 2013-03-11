package ftn.is.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class OdslusanPredmet implements Serializable {
	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue(generator="IdGenerator")
	private int odslusanPredmetId;
	private boolean odslusan;

	@ManyToOne
	private Predmet predmet;
	
	@ManyToOne
	private Student student;
	
	
	public OdslusanPredmet() {
		super();
	}   
	public int getOdslusanPredmetId() {
		return this.odslusanPredmetId;
	}

	public void setOdslusanPredmetId(int odslusanPredmetId) {
		this.odslusanPredmetId = odslusanPredmetId;
	}   
	public boolean getOdslusan() {
		return this.odslusan;
	}

	public void setOdslusan(boolean odslusan) {
		this.odslusan = odslusan;
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
