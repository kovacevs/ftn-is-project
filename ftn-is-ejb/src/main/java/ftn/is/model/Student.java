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
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue(generator="IdGenerator")
	private int studentId;
	private String ime;
	private String prezime;
	private String lozinka;
	private String username;
	private String brojIndeksa;
	private int godinaUpisa;


	@XmlTransient  //potrebno da bih izbegao circular dependecy prilikom marshallinga za xml
	@OneToMany(mappedBy="student")
	@Cascade(value = CascadeType.DELETE)
	private List<Obaveza> obaveze = new ArrayList<Obaveza>();
	
	@XmlTransient
	@OneToMany(mappedBy="student")
	@Cascade(value = CascadeType.DELETE)
	private Set<PripadnostGrupi> pripadnostGrupi = new HashSet<PripadnostGrupi>();
	
	@XmlTransient
	@OneToMany(mappedBy="student")
	//@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade(value = CascadeType.DELETE)
	private List<PrijavljenIspit> prijavljeniIspiti = new ArrayList<PrijavljenIspit>();
	
	@XmlTransient
	@OneToMany(mappedBy="student")
	@Cascade(value = CascadeType.DELETE)
	private List<OdslusanPredmet> odslusaniPredmeti = new ArrayList<OdslusanPredmet>();
	
	public Student() {
		super();
	}   
	public int getStudentId() {
		return this.studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
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
   
	public String getLozinka() {
		return lozinka;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getBrojIndeksa() {
		return brojIndeksa;
	}
	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}
	public int getGodinaUpisa() {
		return godinaUpisa;
	}
	public void setGodinaUpisa(int godinaUpisa) {
		this.godinaUpisa = godinaUpisa;
	}
	public List<Obaveza> getObaveze() {
		return obaveze;
	}
	public void setObaveze(ArrayList<Obaveza> obaveze) {
		this.obaveze = obaveze;
	}
	public Set<PripadnostGrupi> getPripadnostGrupi() {
		return pripadnostGrupi;
	}
	public void setPripadnostGrupi(Set<PripadnostGrupi> pripadnostGrupi) {
		this.pripadnostGrupi = pripadnostGrupi;
	}
	public List<PrijavljenIspit> getPrijavljeniIspiti() {
		return prijavljeniIspiti;
	}
	public void setPrijavljeniIspiti(List<PrijavljenIspit> prijavljeniIspiti) {
		this.prijavljeniIspiti = prijavljeniIspiti;
	}
	public List<OdslusanPredmet> getOdslusaniPredmeti() {
		return odslusaniPredmeti;
	}
	public void setOdslusaniPredmeti(List<OdslusanPredmet> odslusaniPredmeti) {
		this.odslusaniPredmeti = odslusaniPredmeti;
	}

}
