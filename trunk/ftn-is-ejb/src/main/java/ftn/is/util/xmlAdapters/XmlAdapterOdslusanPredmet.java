package ftn.is.util.xmlAdapters;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import ftn.is.model.OdslusanPredmet;
import ftn.is.model.Predmet;
import ftn.is.model.Student;
import ftn.is.util.CustomTManager;

public class XmlAdapterOdslusanPredmet extends XmlAdapter<XmlAdapterOdslusanPredmet.AdaptedOdslusanPredmet, OdslusanPredmet>{
	
	private CustomTManager utx;
	
	public XmlAdapterOdslusanPredmet(){
	}
	
	public XmlAdapterOdslusanPredmet(CustomTManager utx){
		this.utx = utx;
	}

	/* Ova inner klasa (AdaptedOdslusanPredmet) sadzi informacije na osnovu kojih JAXB moze da 
	 * generise zeljeni XML: umesto celih objekata student i predmet sadrzi int
	 * sa njihovim ID-om, odnosno referencom 	 */
	@XmlType(name="odslusanPredmet")
    public static class AdaptedOdslusanPredmet {
		public int odslusanPredmetId;
		public boolean odslusan;
		public int studentRef;
		public int predmetRef;

    	public AdaptedOdslusanPredmet(){}

        public AdaptedOdslusanPredmet(OdslusanPredmet ods) {
            odslusanPredmetId = ods.getOdslusanPredmetId();
            odslusan = ods.getOdslusan();
            studentRef = ods.getStudent().getStudentId();
            predmetRef = ods.getPredmet().getPredmetId();
        }

        public OdslusanPredmet getOdslusanPredmet(CustomTManager utx) {
            OdslusanPredmet ods = new OdslusanPredmet();
            ods.setOdslusanPredmetId(odslusanPredmetId);
            ods.setOdslusan(odslusan);
            //postvi referencu na postojeci managed objekat
            //Student stud = em.find(Student.class,studentRef);
            Student stud = new Student();
            stud.setStudentId(studentRef);
            ods.setStudent(stud);
            if(stud.getOdslusaniPredmeti()==null)
            	stud.setOdslusaniPredmeti(new ArrayList<OdslusanPredmet>());
            stud.getOdslusaniPredmeti().add(ods);
            
            Predmet pred = new Predmet();
            pred.setPredmetId(predmetRef);
            ods.setPredmet(pred);
            if(pred.getOdslusaniPredmeti()==null)
            	pred.setOdslusaniPredmeti(new ArrayList<OdslusanPredmet>());
            pred.getOdslusaniPredmeti().add(ods);
            
            //Posto je Id postavljen mora merge, persist daje exception
            utx.save(ods);

            return ods;
        }
    }
	
	@Override
	public AdaptedOdslusanPredmet marshal(OdslusanPredmet arg0) throws Exception {
		return new AdaptedOdslusanPredmet(arg0);
	}

	@Override
	public OdslusanPredmet unmarshal(AdaptedOdslusanPredmet arg0) throws Exception {
		return arg0.getOdslusanPredmet(utx);
	}
}
