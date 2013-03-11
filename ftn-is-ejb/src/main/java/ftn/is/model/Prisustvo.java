package ftn.is.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Prisustvo implements Serializable {
	private static final long serialVersionUID = -818838849800017528L;
	
	@Id
	@GeneratedValue(generator="IdGenerator")
	private int prisustvoId;
	private Boolean prisutan=false;
	private Date termin;

	@XmlTransient //da bi izbegao circular dependecy, a ovoga puta je na ovoj strani relacije, jer ce se uvek koristiti iz PripadnostGrupi
	@ManyToOne
	private PripadnostGrupi pripadnostGrupi;
	
	
	public Prisustvo() {
		super();
	}   
	public int getPrisustvoId() {
		return this.prisustvoId;
	}

	public void setPrisustvoId(int prisustvoId) {
		this.prisustvoId = prisustvoId;
	}   
	public Date getTermin() {
		return this.termin;
	}

	public void setTermin(Date termin) {
		this.termin = termin;
	}
	public PripadnostGrupi getPripadnostGrupi() {
		return pripadnostGrupi;
	}
	public void setPripadnostGrupi(PripadnostGrupi pripadnostGrupi) {
		this.pripadnostGrupi = pripadnostGrupi;
	}
	public Boolean getPrisutan() {
		return prisutan;
	}
	public void setPrisutan(Boolean prisutan) {
		this.prisutan = prisutan;
	}
   
	
}
