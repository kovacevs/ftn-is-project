package ftn.is.util.xmlAdapters;

import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import ftn.is.model.Grupa;
import ftn.is.model.Predmet;
import ftn.is.util.CustomTManager;

public class XmlAdapterGrupa extends XmlAdapter<XmlAdapterGrupa.AdaptedGrupa, Grupa>{
	
	private CustomTManager utx;
	
	public XmlAdapterGrupa(){
	}
	
	public XmlAdapterGrupa(CustomTManager utx){
		this.utx = utx;
	}
	
	/* Ova inner klasa (AdaptedGrupa) sadzi informacije na osnovu kojih JAXB moze da 
	 * generise zeljeni XML: umesto celog objekta predmet sadrzi int
	 * sa njihovim ID-om, odnosno referencom */
	@XmlType(name="grupa")
    public static class AdaptedGrupa {
		public int grupaId;
		public Date pocetakNastave;
		public int brojTermina;
		public int predmetRef;

    	public AdaptedGrupa(){}

        public AdaptedGrupa(Grupa grupa) {
            grupaId = grupa.getGrupaId();
            pocetakNastave = grupa.getPocetakNastave();
            brojTermina = grupa.getBrojTermina();
            predmetRef = grupa.getPredmet().getPredmetId();
        }

        public Grupa getGrupa(CustomTManager utx) {
        	Grupa grupa = new Grupa();
            grupa.setGrupaId(grupaId);
            grupa.setPocetakNastave(pocetakNastave);
            grupa.setBrojTermina(brojTermina);
            //postvi referencu na postojeci managed objekat
            Predmet pred = new Predmet();
            pred.setPredmetId(predmetRef);
            grupa.setPredmet(pred); 
            
            if(pred.getGrupe()==null)
            	pred.setGrupe(new ArrayList<Grupa>());
            pred.getGrupe().add(grupa);

            grupa.setPripadnostiGrupi(null);
            //Posto je Id postavljen mora merge, persist daje exception 
            utx.save(grupa);

            return grupa;
        }
    }
	
	@Override
	public AdaptedGrupa marshal(Grupa arg0) throws Exception {
		return new AdaptedGrupa(arg0);
	}

	@Override
	public Grupa unmarshal(AdaptedGrupa arg0) throws Exception {
		return arg0.getGrupa(utx);
	}
}
