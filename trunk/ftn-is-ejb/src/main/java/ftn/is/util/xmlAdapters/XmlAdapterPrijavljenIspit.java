package ftn.is.util.xmlAdapters;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import ftn.is.model.Predmet;
import ftn.is.model.PrijavljenIspit;
import ftn.is.model.Student;
import ftn.is.util.CustomTManager;

public class XmlAdapterPrijavljenIspit extends XmlAdapter<XmlAdapterPrijavljenIspit.AdaptedPrijavljenIspit, PrijavljenIspit>{
	
	private CustomTManager utx;
	
	public XmlAdapterPrijavljenIspit(){}
	
	public XmlAdapterPrijavljenIspit(CustomTManager utx){
		this.utx = utx;
	}

	/* Ova inner klasa (AdaptedPrijavljenIspit) sadzi informacije na osnovu kojih JAXB moze da 
	 * generise zeljeni XML: umesto celoih objekata student i predmet sadrzi int
	 * sa njihovim ID-om, odnosno referencom  */
	@XmlType(name="prijavljenIspit")
    public static class AdaptedPrijavljenIspit {
		public int prijavljenIspitId;
		public Date datum;
		public int studentRef;
		public int predmetRef;

    	public AdaptedPrijavljenIspit(){}

        public AdaptedPrijavljenIspit(PrijavljenIspit pris) {
            prijavljenIspitId = pris.getPrijavljenIspitId();
            datum = pris.getDatum();
            studentRef = pris.getStudent().getStudentId();
            predmetRef = pris.getPredmet().getPredmetId();
        }

        public PrijavljenIspit getPrijavljenIspit(CustomTManager utx) {
            PrijavljenIspit pris = new PrijavljenIspit();
            pris.setPrijavljenIspitId(prijavljenIspitId);
            pris.setDatum(datum);
            //postvi referencu na postojeci managed objekat
            //Student stud = em.find(Student.class,studentRef);
            Student stud = new Student();
            stud.setStudentId(studentRef);
            pris.setStudent(stud);
            if(stud.getPrijavljeniIspiti()==null)
            	stud.setPrijavljeniIspiti(new ArrayList<PrijavljenIspit>());
            stud.getPrijavljeniIspiti().add(pris);
            
            //Predmet pred = em.find(Predmet.class,predmetRef);
            Predmet pred = new Predmet();
            pred.setPredmetId(predmetRef);
            pris.setPredmet(pred);
            if(pred.getPrijavljeniIspiti()==null)
            	pred.setPrijavljeniIspiti(new HashSet<PrijavljenIspit>());
            pred.getPrijavljeniIspiti().add(pris);

            //Posto je Id postavljen mora merge, persist daje exception
            utx.save(pris);

            return pris;
        }
    }
	
	@Override
	public AdaptedPrijavljenIspit marshal(PrijavljenIspit arg0) throws Exception {
		return new AdaptedPrijavljenIspit(arg0);
	}

	@Override
	public PrijavljenIspit unmarshal(AdaptedPrijavljenIspit arg0) throws Exception {
		return arg0.getPrijavljenIspit(utx);
	}
}
