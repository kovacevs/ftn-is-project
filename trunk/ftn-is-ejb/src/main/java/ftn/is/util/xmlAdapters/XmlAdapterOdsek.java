package ftn.is.util.xmlAdapters;

import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import ftn.is.model.Odsek;
import ftn.is.util.CustomTManager;

public class XmlAdapterOdsek extends XmlAdapter<XmlAdapterOdsek.AdaptedOdsek, Odsek>{
	
	private CustomTManager utx;

	public XmlAdapterOdsek(){
	}
	
	public XmlAdapterOdsek(CustomTManager utx){
		this.utx = utx;
	}
	
	@XmlType(name="odsek")
    public static class AdaptedOdsek {
        public int odsekId;
    	public String naziv;
    	
    	public AdaptedOdsek(){}
    	
    	public AdaptedOdsek(Odsek ods){
    		odsekId = ods.getOdsekId();
    		naziv = ods.getNaziv();
    	}
    	
    	public Odsek getOdsek(CustomTManager utx){
    		Odsek tmp = new Odsek();
    		tmp.setNaziv(naziv);
    		tmp.setOdsekId(odsekId);
    		tmp.setPredmeti(null);
    		//Posto je Id postavljen mora merge, persist daje exception
    		utx.save(tmp);
    		return tmp;
    	}
	}

	@Override
	public AdaptedOdsek marshal(Odsek v) throws Exception {
		return new AdaptedOdsek(v);
	}

	@Override
	public Odsek unmarshal(AdaptedOdsek v) throws Exception {
		return v.getOdsek(utx);
	}
}
