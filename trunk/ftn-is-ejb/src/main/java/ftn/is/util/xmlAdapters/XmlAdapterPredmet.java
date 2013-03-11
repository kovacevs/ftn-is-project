package ftn.is.util.xmlAdapters;

import java.util.ArrayList;
import java.util.HashSet;
import javax.persistence.EntityManager;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import ftn.is.model.Nastavnik;
import ftn.is.model.Odsek;
import ftn.is.model.Predmet;
import ftn.is.util.CustomTManager;

public class XmlAdapterPredmet extends XmlAdapter<XmlAdapterPredmet.AdaptedPredmet, Predmet>{
	
	private CustomTManager utx;
	
	public XmlAdapterPredmet(){}
	
	public XmlAdapterPredmet(CustomTManager utx){
		this.utx = utx;
	}
	
	/* Ova inner klasa (AdaptedPremet) sadzi informacije na osnovu kojih JAXB moze da 
	 * generise zeljeni XML: umesto celog objekta nastavnik i odsek sadrzi string
	 * sa njihovim ID-om, odnosno referencom 	 */
	@XmlType(name="predmet")
    public static class AdaptedPredmet {
        public int predmetId;
    	public String naziv;
    	public int nastavnikRef;
    	public int odsekRef;

    	public AdaptedPredmet(){}

        public AdaptedPredmet(Predmet predmet) {
            predmetId = predmet.getPredmetId();
            naziv = predmet.getNaziv();
            nastavnikRef = predmet.getNastavnik().getNastavnikId();
            odsekRef = predmet.getOdsek().getOdsekId();
        }

        public Predmet getPredmet(CustomTManager utx) {
            Predmet predmet = new Predmet();
            
            EntityManager em = utx.getEM();
            
            predmet.setPredmetId(predmetId);
            predmet.setNaziv(naziv);
            //postvi referencu na postojeci managed objekat
            Nastavnik nas = em.find(Nastavnik.class,nastavnikRef);            
            predmet.setNastavnik(nas);
            if(nas.getPredmeti()==null)
            	nas.setPredmeti(new ArrayList<Predmet>());
            nas.getPredmeti().add(predmet);

            //Odsek o = em.find(Odsek.class,odsekRef);
            Odsek o = new Odsek();
            o.setOdsekId(odsekRef);
            predmet.setOdsek(o);
            if(o.getPredmeti()==null)
            	o.setPredmeti(new HashSet<Predmet>());
            o.getPredmeti().add(predmet);

            predmet.setGrupe(null);
            predmet.setObaveze(null);
            predmet.setOdslusaniPredmeti(null);
            predmet.setPrijavljeniIspiti(null);

            //Posto je Id postavljen mora merge, persist daje exception
            utx.save(predmet);        

            return predmet;
        }

    }
	
	@Override
	public AdaptedPredmet marshal(Predmet arg0) throws Exception {
		return new AdaptedPredmet(arg0);
	}

	@Override
	public Predmet unmarshal(AdaptedPredmet arg0) throws Exception {
		return arg0.getPredmet(utx);
	}
}
