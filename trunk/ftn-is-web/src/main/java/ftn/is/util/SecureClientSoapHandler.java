package ftn.is.util;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.xml.namespace.QName;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import org.apache.ws.security.WSPasswordCallback;
import org.apache.ws.security.WSSConfig;
import org.apache.ws.security.WSSecurityEngine;
import org.apache.ws.security.components.crypto.Crypto;
import org.apache.ws.security.components.crypto.CryptoFactory;
import org.apache.ws.security.message.WSSecEncrypt;
import org.apache.ws.security.message.WSSecHeader;
import org.apache.ws.security.message.WSSecSignature;
import org.w3c.dom.Document;

 public class SecureClientSoapHandler implements SOAPHandler<SOAPMessageContext>{
	 
	 private Properties encryptProp;
	 private Properties signatureProp;
	 
	 static{//static init, bez ovoga ne radi enkripcija
		 WSSConfig.init();
	 }
	 
	 
	 @PostConstruct
	 public void init(){
		 System.out.println("Client security handler initializing");
         encryptProp = new Properties();
         //Svi klijenti ce simetricni kljuc kriptovati javnim kljucem servera, pa password za tajni kljuc nije potreban
         encryptProp.put("org.apache.ws.security.crypto.provider","org.apache.ws.security.components.crypto.Merlin");
         encryptProp.put("org.apache.ws.security.crypto.merlin.keystore.type", "jks");
         encryptProp.put("org.apache.ws.security.crypto.merlin.keystore.password", "burek");
         encryptProp.put("org.apache.ws.security.crypto.merlin.file","ClientKeystore.jks");
         encryptProp.put("alias","ftn-is");
         
         signatureProp = new Properties();
         //Klijent potpisuje poruku svojim tajnim kljucem, naknadno je potrebno staviti alias i pass u property
         signatureProp.put("org.apache.ws.security.crypto.provider","org.apache.ws.security.components.crypto.Merlin");
         signatureProp.put("org.apache.ws.security.crypto.merlin.keystore.type", "jks");
         signatureProp.put("org.apache.ws.security.crypto.merlin.keystore.password", "burek");
         signatureProp.put("org.apache.ws.security.crypto.merlin.file","ClientKeystore.jks");
	 }
	
	 
	 public boolean handleMessage(SOAPMessageContext messageContext){
	
		 Boolean outboundProperty = (Boolean)messageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

		 if (outboundProperty.booleanValue()) {
			 //OUTBOUND: Potpisivanje i enkripcija se radi ako u messageContextu postoji studentAlias
			 if(messageContext.containsKey("studentAlias")){
				 System.out.println("Client encrypting message");
				 try {
					 SOAPMessage soapMsg = messageContext.getMessage();
					 String alias = (String)messageContext.get("studentAlias");
			          
			         EncryptSOAPBody(soapMsg,encryptProp);
			          
			         signatureProp.put("alias",alias);
			         signatureProp.put("password","burek");
			          
			         SignSOAPEnvelope(soapMsg, signatureProp);
				
				} catch (Exception e) {
					e.printStackTrace();
				} 
			 }else{
				 System.out.println("Client sending unencrypted message");
			 }
		 } else {
			 //INBOUND: dekriptuj ako je kriptovano
			 try {
				 SOAPMessage soapMsg = messageContext.getMessage();
				 SOAPHeader head = soapMsg.getSOAPHeader();
				 
				 if(head!=null && head.getFirstChild()!=null && head.getFirstChild().getLocalName().equals("Security")){
					  System.out.println("Client received encrypted message. Decrypting...");     
					  
					  DecryptAndCheckSignature(soapMsg,encryptProp);
					  
/*#DEBUG			  System.out.println("DEKRIPTOVANA PORUKA");
					  soapMsg.writeTo(System.out);
*/
				 }else{
					 System.out.println("Client received unencrypted message.");
				 }
			} catch (Exception e) {
				e.printStackTrace();
			} 
		 }

		 return true;
	 }
		
/*
	private static void dumpDocument(Node root) throws TransformerException {
		
	    Transformer transformer = TransformerFactory.newInstance().newTransformer();
	    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	    transformer.transform(new DOMSource(root), new StreamResult(System.out));
	    
	  }	 
*/
     private static SOAPMessage updateSOAPMessage(Document doc, SOAPMessage message) throws SOAPException {

         DOMSource domSource = new DOMSource(doc);
         message.getSOAPPart().setContent(domSource);

         return message;
     }

	 
    private static Document toDocument(SOAPMessage soapMsg) throws SOAPException, TransformerException {
         Source src = soapMsg.getSOAPPart().getContent();
         TransformerFactory tf = TransformerFactory.newInstance();
         Transformer transformer = tf.newTransformer();

         DOMResult result = new DOMResult();
         transformer.transform(src, result);
         return (Document) result.getNode();
    }

    
    private void SignSOAPEnvelope(SOAPMessage soapMsg, Properties prop) throws Exception {
         // WSSecSignature potpisuje SOAP envelope prema WS-Specification(X509 profile) 
    	 // i dodaje potpis i informacije u header.

         WSSecSignature signer = new WSSecSignature();
         WSSecHeader wsSecHeader = new WSSecHeader();

         String alias = prop.getProperty("alias");
         String password = prop.getProperty("password");

         signer.setUserInfo(alias,password);
         Crypto crypto = CryptoFactory.getInstance(prop);
         Document doc = toDocument(soapMsg);
         wsSecHeader.setMustUnderstand(false);
         wsSecHeader.insertSecurityHeader(doc);
         
         Document signedDoc = signer.build(doc, crypto, wsSecHeader);

/*DEBUG  //test for invalidating signature: posle potpisa promenim argument, dobije se
         //org.apache.ws.security.WSSecurityException: The signature or decryption was invalid
         Node envelope = signedDoc.getFirstChild();
         Node header = envelope.getFirstChild();
         Node body = header.getNextSibling();
         Node method = body.getFirstChild();
         Node argument = method.getFirstChild();
         System.out.println("KLIJENT: argNode "+argument.getNodeName()+"|"+argument.getTextContent());
         argument.setTextContent("2");
*/
         
         DOMSource domSource = new DOMSource(signedDoc);
         soapMsg.getSOAPPart().setContent(domSource);
     }
	

     private void EncryptSOAPBody(SOAPMessage soapMsg,Properties prop) throws Exception {
         WSSecEncrypt encrypter = new WSSecEncrypt();
         WSSecHeader wsSecHeader = new WSSecHeader();

         String alias = prop.getProperty("alias");
         String password = prop.getProperty("password");

         encrypter.setUserInfo(alias, password);

         Crypto crypto = CryptoFactory.getInstance(prop);
         
         Document doc = toDocument(soapMsg);
         wsSecHeader.setMustUnderstand(false);
         wsSecHeader.insertSecurityHeader(doc);
         
         encrypter.prepare(doc, crypto);
         Document encryptedDoc = encrypter.build(doc, crypto, wsSecHeader);
         
         DOMSource domSource = new DOMSource(encryptedDoc);
         soapMsg.getSOAPPart().setContent(domSource);
    }
     
     private void DecryptAndCheckSignature(SOAPMessage soapMsg,Properties prop) throws Exception {
    	 //Metoda vrsi procesiranje svega iz headera - decrypt i provera potpisa
    	 //napomena: prilikom provere potpisa se proverava i da li sertifikat postoji u lokalnom keystoru
    	 //u slucaju greske: org.apache.ws.security.WSSecurityException: The signature or decryption was invalid
    	 
	     Crypto crypto = CryptoFactory.getInstance(prop);
	     Document doc = toDocument(soapMsg);
         //dumpDocument(doc);

         WSSecurityEngine engine = new WSSecurityEngine();
         // process verification
         engine.processSecurityHeader(doc,null, new PassHandle(), crypto);
 
         updateSOAPMessage(doc,soapMsg);

         soapMsg.getSOAPHeader().removeContents();
         soapMsg.getSOAPBody().removeAttribute("wsu:Id");
         soapMsg.getSOAPBody().removeNamespaceDeclaration("wsu");
     }
     
	 private class PassHandle implements CallbackHandler {

		@Override
		public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
			String password;

			for (Callback cb : callbacks) {
				if (cb instanceof WSPasswordCallback) {

					WSPasswordCallback pc = (WSPasswordCallback) cb;
			        password = "burek";
			        if (pc.getIdentifier() != null)
			        	pc.setPassword(password);
			     }
			 }
		}
	 }

	 public Set<QName> getHeaders(){
		 return null;
	 }
     
	 public boolean handleFault(SOAPMessageContext messageContext){
		 return true;
	 }
	 
	 public void close(MessageContext messageContext)
	 {
	 }
}