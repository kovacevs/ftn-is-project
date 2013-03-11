package ftn.is.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class PripadnostGrupi implements Serializable {
	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue(generator="IdGenerator")
	private int pripadnostId;

	@ManyToOne
	private Student student;
	
	@ManyToOne
	private Grupa grupa;
	
	@OneToMany(mappedBy="pripadnostGrupi", fetch = FetchType.EAGER, orphanRemoval = true)
	//@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade(value = CascadeType.DELETE)
	private List<Prisustvo> prisustva = new ArrayList<Prisustvo>();
	
	public PripadnostGrupi() {
		super();
	}   
	public int getPripadnostId() {
		return this.pripadnostId;
	}

	public void setPripadnostId(int pripadnostId) {
		this.pripadnostId = pripadnostId;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Grupa getGrupa() {
		return grupa;
	}
	public void setGrupa(Grupa grupa) {
		this.grupa = grupa;
	}
	public List<Prisustvo> getPrisustva() {
		return prisustva;
	}
	public void setPrisustva(List<Prisustvo> prisustva) {
		this.prisustva = prisustva;
	}
   
}
