package ftn.is.util.xmlAdapters;

import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import ftn.is.model.Student;
import ftn.is.util.CustomTManager;

public class XmlAdapterStudent extends XmlAdapter<XmlAdapterStudent.AdaptedStudent, Student>{
	
	private CustomTManager utx;
	
	public XmlAdapterStudent(){
	}
	
	public XmlAdapterStudent(CustomTManager utx){
		this.utx = utx;
	}
	
	@XmlType(name="student")
    public static class AdaptedStudent {
        public int studentId;
    	public String ime;
    	public String prezime;
    	public String username;
    	public String lozinka;
    	public String brojIndeksa;
    	public int godinaUpisa;
    	
    	public AdaptedStudent(){}
    	
    	public AdaptedStudent(Student stud){
    		studentId = stud.getStudentId();
    		ime = stud.getIme();
    		prezime = stud.getPrezime();
    		username = stud.getUsername();
    		lozinka = stud.getLozinka();
    		brojIndeksa = stud.getBrojIndeksa();
    		godinaUpisa = stud.getGodinaUpisa();
    	}
    	
    	public Student getStudent(CustomTManager utx){
    		Student tmp = new Student();
    		tmp.setIme(ime);
    		tmp.setStudentId(studentId);
    		tmp.setPrezime(prezime);
    		tmp.setUsername(username);
    		tmp.setLozinka(lozinka);
    		tmp.setBrojIndeksa(brojIndeksa);
    		tmp.setGodinaUpisa(godinaUpisa);
    		tmp.setObaveze(null);
    		tmp.setOdslusaniPredmeti(null);
    		tmp.setPrijavljeniIspiti(null);
    		tmp.setPripadnostGrupi(null);
    		
    		//postvi referencu na postojeci managed objekat
    		utx.save(tmp);

    		return tmp;
    	}
	}

	@Override
	public AdaptedStudent marshal(Student v) throws Exception {
		return new AdaptedStudent(v);
	}

	@Override
	public Student unmarshal(AdaptedStudent v) throws Exception {
		return v.getStudent(utx);
	}
}