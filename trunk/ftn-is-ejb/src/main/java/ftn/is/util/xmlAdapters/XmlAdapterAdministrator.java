package ftn.is.util.xmlAdapters;

import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import ftn.is.model.Administrator;
import ftn.is.util.CustomTManager;

public class XmlAdapterAdministrator extends XmlAdapter<XmlAdapterAdministrator.AdaptedAdministrator, Administrator>{
	
	private CustomTManager utx;
	
	public XmlAdapterAdministrator(){
	}
	
	public XmlAdapterAdministrator(CustomTManager utx){
		this.utx = utx;
	}
	
	@XmlType(name="administrator")
    public static class AdaptedAdministrator {
		public int administratorId;
		public String ime;
		public String prezime;
		public String username;
		public String lozinka;
    	
    	public AdaptedAdministrator(){}
    	
    	public AdaptedAdministrator(Administrator admin){
    		administratorId = admin.getAdministratorId();
    		ime = admin.getIme();
    		prezime = admin.getPrezime();
    		username = admin.getUsername();
    		lozinka = admin.getLozinka();
    	}
    	
    	public Administrator getAdministrator(CustomTManager utx){
    		Administrator tmp = new Administrator();
    		
    		tmp.setIme(ime);
    		tmp.setAdministratorId(administratorId);
    		tmp.setPrezime(prezime);
    		tmp.setUsername(username);
    		tmp.setLozinka(lozinka);

    		//Posto je Id postavljen mora merge, persist daje exception 
    		utx.save(tmp);	    	
    		
    		return tmp;
    	}
	}

	@Override
	public AdaptedAdministrator marshal(Administrator v) throws Exception {
		return new AdaptedAdministrator(v);
	}

	@Override
	public Administrator unmarshal(AdaptedAdministrator v) throws Exception {
		return v.getAdministrator(utx);
	}
}