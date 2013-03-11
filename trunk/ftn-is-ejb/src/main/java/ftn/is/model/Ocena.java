package ftn.is.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Ocena implements Serializable {
	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue(generator="IdGenerator")
	private int ocenaId;
	private int ocena;
	private Date datum;

	@XmlTransient
	@OneToOne
	private Obaveza obaveza;	
	
	public Ocena() {
		super();
	}   
	public int getOcenaId() {
		return this.ocenaId;
	}

	public void setOcenaId(int ocenaId) {
		this.ocenaId = ocenaId;
	}   
	
	public int getOcena() {
		return this.ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}   
	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public Obaveza getObaveza() {
		return obaveza;
	}
	public void setObaveza(Obaveza obaveza) {
		this.obaveza = obaveza;
	}
   
}
