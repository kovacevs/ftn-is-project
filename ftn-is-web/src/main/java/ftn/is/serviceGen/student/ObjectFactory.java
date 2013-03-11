
package ftn.is.serviceGen.student;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ftn.is.serviceGen.student package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetStudent_QNAME = new QName("http://service.is.ftn/", "getStudent");
    private final static QName _ListaPredmetaZaPrijavu_QNAME = new QName("http://service.is.ftn/", "listaPredmetaZaPrijavu");
    private final static QName _ListaPrijavljenihIspita_QNAME = new QName("http://service.is.ftn/", "listaPrijavljenihIspita");
    private final static QName _ListaPrijavljenihIspitaResponse_QNAME = new QName("http://service.is.ftn/", "listaPrijavljenihIspitaResponse");
    private final static QName _EditLozinka_QNAME = new QName("http://service.is.ftn/", "editLozinka");
    private final static QName _GetStudentResponse_QNAME = new QName("http://service.is.ftn/", "getStudentResponse");
    private final static QName _ListaPredmetaZaPrijavuResponse_QNAME = new QName("http://service.is.ftn/", "listaPredmetaZaPrijavuResponse");
    private final static QName _PrijavaIspita_QNAME = new QName("http://service.is.ftn/", "prijavaIspita");
    private final static QName _EditLozinkaResponse_QNAME = new QName("http://service.is.ftn/", "editLozinkaResponse");
    private final static QName _PrijavaIspitaResponse_QNAME = new QName("http://service.is.ftn/", "prijavaIspitaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ftn.is.serviceGen.student
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListaPredmetaZaPrijavuResponse }
     * 
     */
    public ListaPredmetaZaPrijavuResponse createListaPredmetaZaPrijavuResponse() {
        return new ListaPredmetaZaPrijavuResponse();
    }

    /**
     * Create an instance of {@link PrijavaIspita }
     * 
     */
    public PrijavaIspita createPrijavaIspita() {
        return new PrijavaIspita();
    }

    /**
     * Create an instance of {@link EditLozinkaResponse }
     * 
     */
    public EditLozinkaResponse createEditLozinkaResponse() {
        return new EditLozinkaResponse();
    }

    /**
     * Create an instance of {@link PrijavaIspitaResponse }
     * 
     */
    public PrijavaIspitaResponse createPrijavaIspitaResponse() {
        return new PrijavaIspitaResponse();
    }

    /**
     * Create an instance of {@link ListaPrijavljenihIspita }
     * 
     */
    public ListaPrijavljenihIspita createListaPrijavljenihIspita() {
        return new ListaPrijavljenihIspita();
    }

    /**
     * Create an instance of {@link ListaPredmetaZaPrijavu }
     * 
     */
    public ListaPredmetaZaPrijavu createListaPredmetaZaPrijavu() {
        return new ListaPredmetaZaPrijavu();
    }

    /**
     * Create an instance of {@link GetStudent }
     * 
     */
    public GetStudent createGetStudent() {
        return new GetStudent();
    }

    /**
     * Create an instance of {@link ListaPrijavljenihIspitaResponse }
     * 
     */
    public ListaPrijavljenihIspitaResponse createListaPrijavljenihIspitaResponse() {
        return new ListaPrijavljenihIspitaResponse();
    }

    /**
     * Create an instance of {@link GetStudentResponse }
     * 
     */
    public GetStudentResponse createGetStudentResponse() {
        return new GetStudentResponse();
    }

    /**
     * Create an instance of {@link EditLozinka }
     * 
     */
    public EditLozinka createEditLozinka() {
        return new EditLozinka();
    }

    /**
     * Create an instance of {@link PrijavljenIspit }
     * 
     */
    public PrijavljenIspit createPrijavljenIspit() {
        return new PrijavljenIspit();
    }

    /**
     * Create an instance of {@link Odsek }
     * 
     */
    public Odsek createOdsek() {
        return new Odsek();
    }

    /**
     * Create an instance of {@link Nastavnik }
     * 
     */
    public Nastavnik createNastavnik() {
        return new Nastavnik();
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link Predmet }
     * 
     */
    public Predmet createPredmet() {
        return new Predmet();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "getStudent")
    public JAXBElement<GetStudent> createGetStudent(GetStudent value) {
        return new JAXBElement<GetStudent>(_GetStudent_QNAME, GetStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaPredmetaZaPrijavu }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "listaPredmetaZaPrijavu")
    public JAXBElement<ListaPredmetaZaPrijavu> createListaPredmetaZaPrijavu(ListaPredmetaZaPrijavu value) {
        return new JAXBElement<ListaPredmetaZaPrijavu>(_ListaPredmetaZaPrijavu_QNAME, ListaPredmetaZaPrijavu.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaPrijavljenihIspita }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "listaPrijavljenihIspita")
    public JAXBElement<ListaPrijavljenihIspita> createListaPrijavljenihIspita(ListaPrijavljenihIspita value) {
        return new JAXBElement<ListaPrijavljenihIspita>(_ListaPrijavljenihIspita_QNAME, ListaPrijavljenihIspita.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaPrijavljenihIspitaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "listaPrijavljenihIspitaResponse")
    public JAXBElement<ListaPrijavljenihIspitaResponse> createListaPrijavljenihIspitaResponse(ListaPrijavljenihIspitaResponse value) {
        return new JAXBElement<ListaPrijavljenihIspitaResponse>(_ListaPrijavljenihIspitaResponse_QNAME, ListaPrijavljenihIspitaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditLozinka }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "editLozinka")
    public JAXBElement<EditLozinka> createEditLozinka(EditLozinka value) {
        return new JAXBElement<EditLozinka>(_EditLozinka_QNAME, EditLozinka.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "getStudentResponse")
    public JAXBElement<GetStudentResponse> createGetStudentResponse(GetStudentResponse value) {
        return new JAXBElement<GetStudentResponse>(_GetStudentResponse_QNAME, GetStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaPredmetaZaPrijavuResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "listaPredmetaZaPrijavuResponse")
    public JAXBElement<ListaPredmetaZaPrijavuResponse> createListaPredmetaZaPrijavuResponse(ListaPredmetaZaPrijavuResponse value) {
        return new JAXBElement<ListaPredmetaZaPrijavuResponse>(_ListaPredmetaZaPrijavuResponse_QNAME, ListaPredmetaZaPrijavuResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrijavaIspita }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "prijavaIspita")
    public JAXBElement<PrijavaIspita> createPrijavaIspita(PrijavaIspita value) {
        return new JAXBElement<PrijavaIspita>(_PrijavaIspita_QNAME, PrijavaIspita.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditLozinkaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "editLozinkaResponse")
    public JAXBElement<EditLozinkaResponse> createEditLozinkaResponse(EditLozinkaResponse value) {
        return new JAXBElement<EditLozinkaResponse>(_EditLozinkaResponse_QNAME, EditLozinkaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrijavaIspitaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "prijavaIspitaResponse")
    public JAXBElement<PrijavaIspitaResponse> createPrijavaIspitaResponse(PrijavaIspitaResponse value) {
        return new JAXBElement<PrijavaIspitaResponse>(_PrijavaIspitaResponse_QNAME, PrijavaIspitaResponse.class, null, value);
    }

}
