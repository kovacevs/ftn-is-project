package ftn.is.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.xml.security.encryption.EncryptedData;
import org.apache.xml.security.encryption.EncryptedKey;
import org.apache.xml.security.encryption.XMLCipher;
import org.apache.xml.security.keys.KeyInfo;
import org.apache.xml.security.keys.keyresolver.implementations.RSAKeyValueResolver;
import org.apache.xml.security.keys.keyresolver.implementations.X509CertificateResolver;
import org.apache.xml.security.signature.XMLSignature;
import org.apache.xml.security.transforms.Transforms;
import org.apache.xml.security.utils.Constants;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class BackupHelper {
	
	/*
    static {
        org.apache.xml.security.Init.init();
    }
	*/
	
	public static Document signDocument(Document doci)throws Exception{
		
		System.out.println("Signing document...");
		
		Document doc = reserialize(doci);
		
		//Ucitavamo serverski certifikat i privatni kljuc za potpis
		KeyStore ks = KeyStore.getInstance("JKS", "SUN");
		BufferedInputStream in = new BufferedInputStream(new FileInputStream("ServerKeystore.jks"));
		ks.load(in, "burek".toCharArray());
		Certificate serverCert = ks.getCertificate("ftn-is");
		PrivateKey serverPK = (PrivateKey) ks.getKey("ftn-is", "burek".toCharArray());
		in.close();
		
		Element rootEl = doc.getDocumentElement();
		
		//XMLSignature objekat inicijalizujemo algoritmom za potpis RSA sa SHA hes funkcijom
		XMLSignature signature = new XMLSignature(doc, null, XMLSignature.ALGO_ID_SIGNATURE_RSA_SHA1);
		//Transformacije nad dokumentom za potpis
		Transforms transforms = new Transforms(doc);
		//Iz potpisa uklanja Signature element, enveloped tip po specifikaciji
		transforms.addTransform(Transforms.TRANSFORM_ENVELOPED_SIGNATURE);
		transforms.addTransform(Transforms.TRANSFORM_C14N_WITH_COMMENTS); 
		    
		//potpisuje se citav dokument (URI "")
		signature.addDocument("", transforms, Constants.ALGO_ID_DIGEST_SHA1);
		    
		//U KeyInfo se postavalja Javni kljuc samostalno i citav sertifikat
		signature.addKeyInfo(serverCert.getPublicKey());
		signature.addKeyInfo((X509Certificate) serverCert);

		rootEl.appendChild(signature.getElement());
		    
		//potpisivanje
		signature.sign(serverPK);
		
		return doc;
	}
	
	public static boolean verifySignature(Document doc)throws Exception{
		
		System.out.println("Verifying signature...");
		
		//Pronalazi se prvi Signature element 
		NodeList signatures = doc.getElementsByTagNameNS("http://www.w3.org/2000/09/xmldsig#", "Signature");
		Element signatureEl = (Element) signatures.item(0);
		
		//kreira se signature objekat od elementa
		XMLSignature signature = new XMLSignature(signatureEl, null);
		KeyInfo keyInfo = signature.getKeyInfo();

		if(keyInfo != null) {
			//registruju se resolver-i za javni kljuc i sertifikat
			keyInfo.registerInternalKeyResolver(new RSAKeyValueResolver());
		    keyInfo.registerInternalKeyResolver(new X509CertificateResolver());
		    
		    //ako sadrzi sertifikat
		    if(keyInfo.containsX509Data() && keyInfo.itemX509Data(0).containsCertificate()) { 
		        Certificate cert = keyInfo.itemX509Data(0).itemCertificate(0).getX509Certificate();
		        //ako postoji sertifikat, provera potpisa
		        if(cert != null) 
		        	return signature.checkSignatureValue((X509Certificate) cert);
		        else
		        	return false;
		    }
		    else
		    	return false;
		}
		else
			return false;
	}
	
	
    public static Document encryptOdsekOcena(Document doc) throws Exception{
		
		System.out.println("Encrypting data...");
		
		//Prvo generisemo simetricni kljuc za kriptovanje podataka
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(128);
		SecretKey secretKey = keyGenerator.generateKey();
		
		//Zatim ucitavamo serverski certifikat za kriptovanje simetricnog kljuca
		KeyStore ks = KeyStore.getInstance("JKS", "SUN");
		BufferedInputStream in = new BufferedInputStream(new FileInputStream("ServerKeystore.jks"));
		ks.load(in, "burek".toCharArray());
		Certificate serverCert = ks.getCertificate("ftn-is");
		in.close();
		
		//cipher za kriptovanje simetricnog kljuca, koristi se Javni RSA kljuc za kriptovanje
		XMLCipher keyCipher = XMLCipher.getInstance(XMLCipher.RSA_v1dot5);
	    //inicijalizacija za kriptovanje tajnog kljuca javnim RSA kljucem
	    keyCipher.init(XMLCipher.WRAP_MODE, serverCert.getPublicKey());
	    EncryptedKey encryptedKey = keyCipher.encryptKey(doc, secretKey);
		
	    //cipher za kriptovanje XML-a
	    XMLCipher xmlCipher = XMLCipher.getInstance(XMLCipher.AES_128);
	    xmlCipher.init(XMLCipher.ENCRYPT_MODE, secretKey);
	    
	    //u EncryptedData element koji se kriptuje kao KeyInfo stavljamo kriptovan simetricni kljuc
	    EncryptedData encryptedData = xmlCipher.getEncryptedData();
        //kreira se KeyInfo
	    KeyInfo keyInfo = new KeyInfo(doc);
	    keyInfo.add(encryptedKey);
        encryptedData.setKeyInfo(keyInfo);
		
		//trazi se element 'obaveze' ciji sadrzaj se kriptuje
		NodeList obavezeList = doc.getElementsByTagName("obaveze");
		Element obaveze = (Element) obavezeList.item(0);
		if(obaveze!=null){
			xmlCipher.doFinal(doc, obaveze, true); //kriptuje sa sadrzaj
		}
		
		//kriptovanje elementa 'ocene'
		EncryptedData encryptedData2 = xmlCipher.getEncryptedData();
	    KeyInfo keyInfo2 = new KeyInfo(doc);
	    keyInfo2.add(encryptedKey);
        encryptedData2.setKeyInfo(keyInfo2);
		
		NodeList oceneList = doc.getElementsByTagName("ocene");
		Element ocene = (Element) oceneList.item(0);
		if(ocene!=null){
			xmlCipher.doFinal(doc, ocene, true); 
		}
		
		return doc;
    }
    
    
    public static Document decryptOdsekOcena(Document doc) throws Exception{
    	
		System.out.println("Decrypting data...");
		
		//Prvo ucitavamo serverski private key za dekriptovanje kljuca
		KeyStore ks = KeyStore.getInstance("JKS", "SUN");
		BufferedInputStream in = new BufferedInputStream(new FileInputStream("ServerKeystore.jks"));
		ks.load(in, "burek".toCharArray());
		PrivateKey serverPrivateKey = (PrivateKey) ks.getKey("ftn-is", "burek".toCharArray());
		in.close();
		
		//cipher za dekritpovanje XML-a
		XMLCipher xmlCipher = XMLCipher.getInstance();
		xmlCipher.init(XMLCipher.DECRYPT_MODE, null);
		//Kljuc za dekriptovanje tajnog kljuca
		xmlCipher.setKEK(serverPrivateKey);
		
		//trazi se prvi EncryptedData element, 
		NodeList encDataList = doc.getElementsByTagNameNS("http://www.w3.org/2001/04/xmlenc#", "EncryptedData");
		//dekriptovanje odseka
		Element encData = (Element) encDataList.item(0);
		if(encData!=null){
			//Dekriptuje se simetricni kljuc, pa onda njime podaci
			xmlCipher.doFinal(doc, encData); 
		}
		
		//dekriptovanje ocena
		encData = (Element) encDataList.item(1);
		if(encData!=null){
			xmlCipher.doFinal(doc, encData); 
		}
	
    	return doc;
    }
    
    public static Document reserialize(Document request) {
        Document r = null;
        try{
	        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	        dbf.setNamespaceAware(true);
	        DocumentBuilder db = dbf.newDocumentBuilder();

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "no");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            StreamResult result = new StreamResult(baos);
            DOMSource src = new DOMSource(request);
            transformer.transform(src, result);
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            r = db.parse(bais);
        }catch(Exception e){
            e.printStackTrace();
        }
        return r;
    }
    
	
   public static byte[] createZip(String s) throws IOException {  
	    System.out.println("Compressing file...");
	    ByteArrayOutputStream bos = new ByteArrayOutputStream();  
	    ZipOutputStream zipfile = new ZipOutputStream(bos);  
	    ZipEntry zipentry = new ZipEntry("DBbackup.xml");
        zipfile.putNextEntry(zipentry);  
        zipfile.write(s.getBytes());  
	    zipfile.close();  
	    return bos.toByteArray();  
	}  
   
   public static String unzip(byte[] fajl){
	   System.out.println("UnCompressing file...");
	   String s = null;
	   try{
		   ByteArrayOutputStream bos = new ByteArrayOutputStream();
		   byte[] buffer = new byte[1024];
		   
		   ZipInputStream zipfile = new ZipInputStream(new ByteArrayInputStream(fajl));
		   zipfile.getNextEntry();
		   
		   int len;
           while ((len = zipfile.read(buffer)) > 0) {
      		bos.write(buffer, 0, len);
           }
           
		   s = bos.toString();
	   }catch(IOException e){
		   System.out.println("UNZIP EXCEPTION");
	   }
	   return s;
   }
	
   
   
}
