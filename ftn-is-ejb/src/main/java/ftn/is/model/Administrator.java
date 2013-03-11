package ftn.is.model;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Administrator implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=IDENTITY, generator="IdGenerator")
	private int administratorId;
	private String ime;
	private String prezime;
	private String username;
	private String lozinka;

	public Administrator() {
		super();
	}   
	public int getAdministratorId() {
		return this.administratorId;
	}

	public void setAdministratorId(int administratorId) {
		this.administratorId = administratorId;
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
   
}
