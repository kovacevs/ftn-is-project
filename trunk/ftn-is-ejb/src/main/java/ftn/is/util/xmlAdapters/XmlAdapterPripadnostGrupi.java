package ftn.is.util.xmlAdapters;

import java.util.ArrayList;
import java.util.HashSet;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import ftn.is.model.Grupa;
import ftn.is.model.PripadnostGrupi;
import ftn.is.model.Student;
import ftn.is.util.CustomTManager;

public class XmlAdapterPripadnostGrupi extends XmlAdapter<XmlAdapterPripadnostGrupi.AdaptedPripadnostGrupi, PripadnostGrupi>{
	
	private CustomTManager utx;
	
	public XmlAdapterPripadnostGrupi(){
	}
	
	public XmlAdapterPripadnostGrupi(CustomTManager utx){
		this.utx = utx;
	}

	/* Ova inner klasa (AdaptedPripadnostGrupi) sadzi informacije na osnovu kojih JAXB moze da 
	 * generise zeljeni XML: umesto celog objekta student i grupa sadrzi string
	 * sa njihovim ID-om, odnosno referencom */
	@XmlType(name="pripadnostGrupi")
    public static class AdaptedPripadnostGrupi {
		public int pripadnostId;
		public int studentRef;
		public int grupaRef;

    	public AdaptedPripadnostGrupi(){}

        public AdaptedPripadnostGrupi(PripadnostGrupi prip) {
            pripadnostId = prip.getPripadnostId();
            studentRef = prip.getStudent().getStudentId();
            grupaRef = prip.getGrupa().getGrupaId();
        }

        public PripadnostGrupi getPripadnostGrupi(CustomTManager utx) {
            PripadnostGrupi prip = new PripadnostGrupi();
            prip.setPripadnostId(pripadnostId);
            //postvi referencu na postojeci managed objekat
            //Student stud = em.find(Student.class,studentRef);
            Student stud = new Student();
            stud.setStudentId(studentRef);
            prip.setStudent(stud);
            if(stud.getPripadnostGrupi()==null)
            	stud.setPripadnostGrupi(new HashSet<PripadnostGrupi>());
            stud.getPripadnostGrupi().add(prip);

            //Grupa grupa = em.find(Grupa.class,grupaRef);
            Grupa grupa = new Grupa();
            grupa.setGrupaId(grupaRef);
            prip.setGrupa(grupa);
            if(grupa.getPripadnostiGrupi()==null)
            	grupa.setPripadnostiGrupi(new ArrayList<PripadnostGrupi>());
            grupa.getPripadnostiGrupi().add(prip);
            
            prip.setPrisustva(null);
            
            //Posto je Id postavljen mora merge, persist daje exception
            utx.save(prip);

            return prip;
        }

    }
	
	@Override
	public AdaptedPripadnostGrupi marshal(PripadnostGrupi arg0) throws Exception {
		return new AdaptedPripadnostGrupi(arg0);
	}

	@Override
	public PripadnostGrupi unmarshal(AdaptedPripadnostGrupi arg0) throws Exception {
		return arg0.getPripadnostGrupi(utx);
	}
}
