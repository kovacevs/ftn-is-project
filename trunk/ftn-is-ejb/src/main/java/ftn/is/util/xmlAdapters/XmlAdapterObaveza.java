package ftn.is.util.xmlAdapters;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import ftn.is.model.Obaveza;
import ftn.is.model.Predmet;
import ftn.is.model.Student;
import ftn.is.util.CustomTManager;

public class XmlAdapterObaveza extends XmlAdapter<XmlAdapterObaveza.AdaptedObaveza, Obaveza>{
	
	private CustomTManager utx;
	
	public XmlAdapterObaveza(){
	}
	
	public XmlAdapterObaveza(CustomTManager utx){
		this.utx = utx;
	}
	
	/* Ova inner klasa (AdaptedObaveza) sadzi informacije na osnovu kojih JAXB moze da 
	 * generise zeljeni XML: umesto celog objekta student i predmet sadrzi int
	 * sa njihovim ID-om, odnosno referencom */
	@XmlType(name="obaveza")
    public static class AdaptedObaveza {
		public int obavezaId;
		public String naziv;
		public int studentRef;
		public int predmetRef;

    	public AdaptedObaveza(){}

        public AdaptedObaveza(Obaveza obv) {
            obavezaId = obv.getObavezaId();
            naziv = obv.getNaziv();
            studentRef = obv.getStudent().getStudentId();
            predmetRef = obv.getPredmet().getPredmetId();
        }

        public Obaveza getObaveza(CustomTManager utx) {
            Obaveza obv = new Obaveza();
            obv.setObavezaId(obavezaId);
            obv.setNaziv(naziv);
            //postvi referencu na postojeci managed objekat
            //Student stud = em.find(Student.class,studentRef);
            Student stud = new Student();
            stud.setStudentId(studentRef);
            obv.setStudent(stud);
            if(stud.getObaveze()==null)
            	stud.setObaveze(new ArrayList<Obaveza>());
            stud.getObaveze().add(obv);
            
            //Predmet pred = em.find(Predmet.class, predmetRef);
            Predmet pred = new Predmet();
            pred.setPredmetId(predmetRef);
            obv.setPredmet(pred);
            if(pred.getObaveze()==null)
            	pred.setObaveze(new ArrayList<Obaveza>());
            pred.getObaveze().add(obv);
            
            obv.setOcena(null);
            
            //Posto je Id postavljen mora merge, persist daje exception
            utx.save(obv);

            return obv;
        }
    }
	
	
	@Override
	public AdaptedObaveza marshal(Obaveza arg0) throws Exception {
		return new AdaptedObaveza(arg0);
	}

	@Override
	public Obaveza unmarshal(AdaptedObaveza arg0) throws Exception {
		return arg0.getObaveza(utx);
	}

}
