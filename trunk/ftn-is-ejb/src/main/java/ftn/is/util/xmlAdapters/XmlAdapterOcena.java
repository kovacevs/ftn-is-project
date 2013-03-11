package ftn.is.util.xmlAdapters;

import java.util.Date;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import ftn.is.model.Obaveza;
import ftn.is.model.Ocena;
import ftn.is.util.CustomTManager;

public class XmlAdapterOcena extends XmlAdapter<XmlAdapterOcena.AdaptedOcena, Ocena>{
	
	private CustomTManager utx;
	
	public XmlAdapterOcena(){
	}
	
	public XmlAdapterOcena(CustomTManager utx){
		this.utx = utx;
	}
	
	/* Ova inner klasa (AdaptedOcena) sadzi informacije na osnovu kojih JAXB moze da 
	 * generise zeljeni XML: umesto celog objekta obaveza sadrzi int
	 * sa njihovim ID-om, odnosno referencom  */
	@XmlType(name="ocena")
    public static class AdaptedOcena {
		public int ocenaId;
		public int ocena;
		public Date datum;
		public int obavezaRef;

    	public AdaptedOcena(){}

        public AdaptedOcena(Ocena ocn) {
            ocenaId = ocn.getOcenaId();
            ocena = ocn.getOcena();
            datum = ocn.getDatum();
            obavezaRef = ocn.getObaveza().getObavezaId();
        }

        public Ocena getOcena(CustomTManager utx) {
            Ocena ocn = new Ocena();
            ocn.setOcenaId(ocenaId);
            ocn.setOcena(ocena);
            ocn.setDatum(datum);
            //postvi referencu na postojeci managed objekat
            //Obaveza obv = em.find(Obaveza.class,obavezaRef);
            Obaveza obv = new Obaveza();
            obv.setObavezaId(obavezaRef);
            ocn.setObaveza(obv);
            obv.setOcena(ocn);

            //Posto je Id postavljen mora merge, persist daje exception
            utx.save(ocn);

            return ocn;
        }
    }
	
	@Override
	public AdaptedOcena marshal(Ocena arg0) throws Exception {
		return new AdaptedOcena(arg0);
	}

	@Override
	public Ocena unmarshal(AdaptedOcena arg0) throws Exception {
		return arg0.getOcena(utx);
	}
}
