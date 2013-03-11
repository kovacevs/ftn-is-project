package ftn.is.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import ftn.is.model.*;
import ftn.is.util.BackupHelper;
import ftn.is.util.CustomTManager;
import ftn.is.util.DbBackup;
import ftn.is.util.xmlAdapters.*;

@Stateless
@WebService
public class AdminService {
	
   @Inject
   private EntityManager em;
   
   @Inject
   private CustomTManager utx;
   
   public byte[] backup(){
	 
	   DbBackup back = new DbBackup();
	   back.loadEverything(em);
	   
	   try {
		   PrintWriter out = new PrintWriter("LastBackupTime.txt");
		   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		   String dateString = dateFormat.format(back.getTimeStamp());
		   out.println(dateString);
		   out.close();
	   } catch (FileNotFoundException e1) {
		   e1.printStackTrace();
	   }
	   
	   byte[] fajlContent = null;
	  
	   Document doc = null;
	   
	   try {
		   
		    System.out.println("Marshalling objects...");
		    
			JAXBContext jc = JAXBContext.newInstance(DbBackup.class);
			
	        Marshaller marshaller = jc.createMarshaller();
	        //marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	        marshaller.setAdapter(new XmlAdapterOdsek());
	        marshaller.setAdapter(new XmlAdapterNastavnik());
	        marshaller.setAdapter(new XmlAdapterStudent());
	        marshaller.setAdapter(new XmlAdapterPredmet());
	        marshaller.setAdapter(new XmlAdapterGrupa());
	        marshaller.setAdapter(new XmlAdapterPripadnostGrupi());
	        marshaller.setAdapter(new XmlAdapterPrisustvo());
	        marshaller.setAdapter(new XmlAdapterObaveza());
	        marshaller.setAdapter(new XmlAdapterOcena());
	        marshaller.setAdapter(new XmlAdapterPrijavljenIspit());
	        marshaller.setAdapter(new XmlAdapterOdslusanPredmet());
	
	        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	        dbf.setNamespaceAware(true);
	        DocumentBuilder db = dbf.newDocumentBuilder();
	        doc = db.newDocument();
	
	        marshaller.marshal(back, doc);
	        
	        doc = BackupHelper.encryptOdsekOcena(doc);
	        doc = BackupHelper.signDocument(doc);
	        
	        StringWriter str = new StringWriter();
	        
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer();
			
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(str);
			
			transformer.transform(source, result);

	        //encryp & sign doc
	        fajlContent = BackupHelper.createZip(str.getBuffer().toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
	   
	  System.out.println("Sending file to client."); 
	  return fajlContent;
   }
   
   
public boolean restore(byte[] fajlContent){
	   boolean returnVal = false;
	   System.out.println("\nFile received from client [size: "+fajlContent.length+"]");
	   
		try {
			//Unzip pristiglog fajla u StringReader (unmarshaller ocekuje reader)
			String unzipped = BackupHelper.unzip(fajlContent);
			StringReader reader = new StringReader(unzipped);
			
			//Ucitavanje timeStamp-a iz bekapa
	        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	        dbf.setNamespaceAware(true);
	        dbf.setIgnoringElementContentWhitespace(true);
	        DocumentBuilder dBuilder = dbf.newDocumentBuilder();
			InputSource is = new InputSource(reader);
			Document doc = dBuilder.parse(is);

			Node timeStampNode = doc.getElementsByTagName("timeStamp").item(0);
			String timeStamp = timeStampNode.getTextContent();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			Date dbDate = dateFormat.parse(timeStamp);
			
			//Ucitavanje timeSTamp-a iz fajla sa servera
			BufferedReader br = new BufferedReader(new FileReader("LastBackupTime.txt"));
			String servStrDate = br.readLine();
			Date servDate = dateFormat.parse(servStrDate);
			
			if(dbDate.equals(servDate)){
				 System.out.println("Datestamp from .bkp matches last backup time.");
				 
				 boolean signatureCheck = BackupHelper.verifySignature(doc);
				 
				 if(signatureCheck){
					 
					 doc = BackupHelper.decryptOdsekOcena(doc);				 
					 
					 //DbBackup unBack = new DbBackup();
					 //unBack.removeEverything(em);
					 utx.removeEverything();
					 
				     System.out.println("Unmarshalling received file...");
				     JAXBContext jc = JAXBContext.newInstance(DbBackup.class);
				
				     Unmarshaller unmarshaller = jc.createUnmarshaller();
	
				     unmarshaller.setAdapter(new XmlAdapterAdministrator(utx));
			         unmarshaller.setAdapter(new XmlAdapterOdsek(utx));
			         unmarshaller.setAdapter(new XmlAdapterNastavnik(utx));
			         unmarshaller.setAdapter(new XmlAdapterStudent(utx));
			         unmarshaller.setAdapter(new XmlAdapterPredmet(utx));
			         unmarshaller.setAdapter(new XmlAdapterGrupa(utx));
			         unmarshaller.setAdapter(new XmlAdapterPripadnostGrupi(utx));
			         unmarshaller.setAdapter(new XmlAdapterPrisustvo(utx));
			         unmarshaller.setAdapter(new XmlAdapterObaveza(utx));
			         unmarshaller.setAdapter(new XmlAdapterOcena(utx));
			         unmarshaller.setAdapter(new XmlAdapterPrijavljenIspit(utx));
			         unmarshaller.setAdapter(new XmlAdapterOdslusanPredmet(utx));
	
			         //unBack = unmarshall(doc,unmarshaller);
			         unmarshaller.unmarshal(doc);
			         
				     em.flush();
				     
				     //unBack.persistEverything(em);
				     
				     System.out.println("Restore Database finished sucessfully.");
				     //resLocalEM.close();
				     returnVal = true;
				 }else{
					 System.out.println("Signature not valid. Aboring backup.");
				 }
			} else{
				System.out.println("Datestamp from DbBackup.bkp does not match last backup time. Aboring backup.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	   return returnVal;
   }
   

/* ================================================
* RAD SA ADMINISTRATOROM
*/	   
   public Administrator getAdmin(String user, String pass){
	   TypedQuery<Administrator> qadmin = em.createQuery("SELECT e From Administrator e WHERE e.username=?1 AND e.lozinka=?2", Administrator.class);
	   qadmin.setParameter(1,user);
	   qadmin.setParameter(2,pass);
	   List<Administrator> tempAdmin = qadmin.getResultList();
	   if(!tempAdmin.isEmpty()){
		   System.out.printf("INFO: admin username and password found! %s [service returning Admin object]%n",tempAdmin.get(0).getUsername());
		   return tempAdmin.get(0);
	   }
	   else{
		   System.out.println("INFO: admin username password not found! [service returning null]");
		   return null;
	   }
   }
   
   public boolean editAdministrator(Administrator admin){
	   TypedQuery<Administrator> qadmin = em.createQuery("SELECT e From Administrator e WHERE e.username=?1 AND NOT e.administratorId=?2", Administrator.class);
	   qadmin.setParameter(1,admin.getUsername());
	   qadmin.setParameter(2,admin.getAdministratorId());
	   List<Administrator> tempAdmin = qadmin.getResultList();
	   if(tempAdmin.isEmpty()){
		   em.merge(admin);
		   return true;
	   }else
		   return false;
   }

   
/* ================================================
* RAD SA PREDMETIMA
*/
   public List<Predmet> listPredmeti(){
	   return em.createQuery("SELECT e From Predmet e",Predmet.class).getResultList(); 
   }
   
   public void deletePredmet(Predmet predmet){
	   Predmet p = em.merge(predmet);
	   em.remove(p);
   }
   
   public void addPredmet(Predmet predmet){
	   predmet.setPredmetId(0);
	   //predmet.setNastavnik(em.find(Nastavnik.class,predmet.getNastavnik().getNastavnikId()));
	   //predmet.setOdsek(em.find(Odsek.class, predmet.getOdsek().getOdsekId()));
	   em.persist(predmet);
   }
   
   public void editPredmet(Predmet predmet){
	   em.merge(predmet);
   }
   	   
/* ================================================
 * RAD SA NASTAVNICIMA
 */
   public List<Nastavnik> listNastavnici(){
	   return em.createQuery("SELECT e From Nastavnik e",Nastavnik.class).getResultList(); 
   }
   
   public void deleteNastavnik(Nastavnik nastavnik){
	   em.remove(em.merge(nastavnik));
   }
   
   public void addNastavnik(Nastavnik nastavnik){
	   nastavnik.setNastavnikId(0);
	   em.persist(nastavnik);
   }
   
   public void editNastavnik(Nastavnik nastavnik){
	   em.merge(nastavnik);
   }
   
/* ================================================
* RAD SA ODSECIMA
*/
   public List<Odsek> listOdseci(){
	   return em.createQuery("SELECT e From Odsek e",Odsek.class).getResultList(); 
   }
   	   
   public void deleteOdsek(Odsek odsek){
	   em.remove(em.merge(odsek));
   }
   
   public void addOdsek(Odsek odsek){
	   odsek.setOdsekId(0);
	   em.persist(odsek);
   }
   
   public void editOdsek(Odsek odsek) throws Exception{
	   em.merge(odsek);
   }
   
}
