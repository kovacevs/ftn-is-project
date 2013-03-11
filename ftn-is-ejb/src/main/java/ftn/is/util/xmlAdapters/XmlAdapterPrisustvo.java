package ftn.is.util.xmlAdapters;

import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import ftn.is.model.PripadnostGrupi;
import ftn.is.model.Prisustvo;
import ftn.is.util.CustomTManager;

public class XmlAdapterPrisustvo extends XmlAdapter<XmlAdapterPrisustvo.AdaptedPrisustvo, Prisustvo>{
	
	private CustomTManager utx;
	
	public XmlAdapterPrisustvo(){
	}
	
	public XmlAdapterPrisustvo(CustomTManager utx){
		this.utx = utx;
	}
	
	/* Ova inner klasa (AdaptedPrisustvo) sadzi informacije na osnovu kojih JAXB moze da 
	 * generise zeljeni XML: umesto celog objekta pripadnostGrupi sadrzi int
	 * sa njihovim ID-om, odnosno referencom 	 */
	@XmlType(name="Prisustvo")
    public static class AdaptedPrisustvo {
		public int prisustvoId;
		public Boolean prisutan;
		public Date termin;
		public int pripadnostGrupiRef;

    	public AdaptedPrisustvo(){}

        public AdaptedPrisustvo(Prisustvo pris) {
            prisustvoId = pris.getPrisustvoId();
            prisutan = pris.getPrisutan();
            termin = pris.getTermin();
            pripadnostGrupiRef = pris.getPripadnostGrupi().getPripadnostId();
        }

        public Prisustvo getPrisustvo(CustomTManager utx) {
            Prisustvo pris = new Prisustvo();
            //EntityManager em =utx.getEM();
            pris.setPrisustvoId(prisustvoId);
            pris.setPrisutan(prisutan);
            pris.setTermin(termin);
            //postvi referencu na postojeci managed objekat
            //PripadnostGrupi prip = em.find(PripadnostGrupi.class,pripadnostGrupiRef);
            PripadnostGrupi prip = new PripadnostGrupi();
            prip.setPripadnostId(pripadnostGrupiRef);
            pris.setPripadnostGrupi(prip);
            if(prip.getPrisustva()==null)
            	prip.setPrisustva(new ArrayList<Prisustvo>());
            prip.getPrisustva().add(pris);

            //Posto je Id postavljen mora merge, persist daje exception
            utx.save(pris);

            return pris;
        }
    }
	
	@Override
	public AdaptedPrisustvo marshal(Prisustvo arg0) throws Exception {
		return new AdaptedPrisustvo(arg0);
	}

	@Override
	public Prisustvo unmarshal(AdaptedPrisustvo arg0) throws Exception {
		return arg0.getPrisustvo(utx);
	}
}
