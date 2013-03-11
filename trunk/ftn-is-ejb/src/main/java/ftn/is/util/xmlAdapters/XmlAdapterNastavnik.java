package ftn.is.util.xmlAdapters;

import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import ftn.is.model.Nastavnik;
import ftn.is.util.CustomTManager;

public class XmlAdapterNastavnik extends XmlAdapter<XmlAdapterNastavnik.AdaptedNastavnik, Nastavnik>{
	
	private CustomTManager utx;
	
	public XmlAdapterNastavnik(){
	}
	
	public XmlAdapterNastavnik(CustomTManager utx){
		this.utx = utx;
	}
	
	@XmlType(name="nastavnik")
    public static class AdaptedNastavnik {
        public int nastavnikId;
    	public String ime;
    	public String prezime;
    	public String username;
    	public String lozinka;
    	
    	public AdaptedNastavnik(){}
    	
    	public AdaptedNastavnik(Nastavnik nas){
    		nastavnikId = nas.getNastavnikId();
    		ime = nas.getIme();
    		prezime = nas.getPrezime();
    		username = nas.getUsername();
    		lozinka = nas.getLozinka();
    	}
    	
    	public Nastavnik getNastavnik(CustomTManager utx){
    		Nastavnik tmp = new Nastavnik();
    		
    		tmp.setIme(ime);
    		tmp.setNastavnikId(nastavnikId);
    		tmp.setPrezime(prezime);
    		tmp.setUsername(username);
    		tmp.setLozinka(lozinka);
    		tmp.setPredmeti(null);

    		//Posto je Id postavljen mora merge, persist daje exception 
    		utx.save(tmp);

    		return tmp;
    	}
	}

	@Override
	public AdaptedNastavnik marshal(Nastavnik v) throws Exception {
		return new AdaptedNastavnik(v);
	}

	@Override
	public Nastavnik unmarshal(AdaptedNastavnik v) throws Exception {
		return v.getNastavnik(utx);
	}
}