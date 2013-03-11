
package ftn.is.serviceGen.nastavnik;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ftn.is.serviceGen.nastavnik package. 
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

    private final static QName _GetOdslusaniPredmetiResponse_QNAME = new QName("http://service.is.ftn/", "getOdslusaniPredmetiResponse");
    private final static QName _SetOdslusaniPredmetiResponse_QNAME = new QName("http://service.is.ftn/", "setOdslusaniPredmetiResponse");
    private final static QName _DeleteObaveza_QNAME = new QName("http://service.is.ftn/", "deleteObaveza");
    private final static QName _SetOdslusaniPredmeti_QNAME = new QName("http://service.is.ftn/", "setOdslusaniPredmeti");
    private final static QName _GetPrisustvaResponse_QNAME = new QName("http://service.is.ftn/", "getPrisustvaResponse");
    private final static QName _GetGrupeForPredmet_QNAME = new QName("http://service.is.ftn/", "getGrupeForPredmet");
    private final static QName _DeleteStudentResponse_QNAME = new QName("http://service.is.ftn/", "deleteStudentResponse");
    private final static QName _RemoveStudentFromGroupResponse_QNAME = new QName("http://service.is.ftn/", "removeStudentFromGroupResponse");
    private final static QName _AddStudentResponse_QNAME = new QName("http://service.is.ftn/", "addStudentResponse");
    private final static QName _EditStudentResponse_QNAME = new QName("http://service.is.ftn/", "editStudentResponse");
    private final static QName _EditGrupa_QNAME = new QName("http://service.is.ftn/", "editGrupa");
    private final static QName _DeleteObavezaResponse_QNAME = new QName("http://service.is.ftn/", "deleteObavezaResponse");
    private final static QName _AddObavezaResponse_QNAME = new QName("http://service.is.ftn/", "addObavezaResponse");
    private final static QName _SetPrisustva_QNAME = new QName("http://service.is.ftn/", "setPrisustva");
    private final static QName _RemoveStudentFromGroup_QNAME = new QName("http://service.is.ftn/", "removeStudentFromGroup");
    private final static QName _EditNastavnik_QNAME = new QName("http://service.is.ftn/", "editNastavnik");
    private final static QName _GetObaveze_QNAME = new QName("http://service.is.ftn/", "getObaveze");
    private final static QName _GetGrupeForPredmetResponse_QNAME = new QName("http://service.is.ftn/", "getGrupeForPredmetResponse");
    private final static QName _DeleteStudent_QNAME = new QName("http://service.is.ftn/", "deleteStudent");
    private final static QName _GetStudentsNotInGroups_QNAME = new QName("http://service.is.ftn/", "getStudentsNotInGroups");
    private final static QName _SetPrisustvaResponse_QNAME = new QName("http://service.is.ftn/", "setPrisustvaResponse");
    private final static QName _AddStudent_QNAME = new QName("http://service.is.ftn/", "addStudent");
    private final static QName _GetNastavnikResponse_QNAME = new QName("http://service.is.ftn/", "getNastavnikResponse");
    private final static QName _AddObaveza_QNAME = new QName("http://service.is.ftn/", "addObaveza");
    private final static QName _DeleteGrupa_QNAME = new QName("http://service.is.ftn/", "deleteGrupa");
    private final static QName _GetStudentsNotInGroupsResponse_QNAME = new QName("http://service.is.ftn/", "getStudentsNotInGroupsResponse");
    private final static QName _AddStudentToGroup_QNAME = new QName("http://service.is.ftn/", "addStudentToGroup");
    private final static QName _DeleteGrupaResponse_QNAME = new QName("http://service.is.ftn/", "deleteGrupaResponse");
    private final static QName _GetObavezeResponse_QNAME = new QName("http://service.is.ftn/", "getObavezeResponse");
    private final static QName _ListStudentiResponse_QNAME = new QName("http://service.is.ftn/", "listStudentiResponse");
    private final static QName _GetPrisustva_QNAME = new QName("http://service.is.ftn/", "getPrisustva");
    private final static QName _GetStudentsInGroupResponse_QNAME = new QName("http://service.is.ftn/", "getStudentsInGroupResponse");
    private final static QName _AddGrupaResponse_QNAME = new QName("http://service.is.ftn/", "addGrupaResponse");
    private final static QName _EditObaveza_QNAME = new QName("http://service.is.ftn/", "editObaveza");
    private final static QName _GetNastavnik_QNAME = new QName("http://service.is.ftn/", "getNastavnik");
    private final static QName _AddGrupa_QNAME = new QName("http://service.is.ftn/", "addGrupa");
    private final static QName _GetPredmetiForNastavnikResponse_QNAME = new QName("http://service.is.ftn/", "getPredmetiForNastavnikResponse");
    private final static QName _GetPredmetiForNastavnik_QNAME = new QName("http://service.is.ftn/", "getPredmetiForNastavnik");
    private final static QName _GetStudentsInGroup_QNAME = new QName("http://service.is.ftn/", "getStudentsInGroup");
    private final static QName _EditObavezaResponse_QNAME = new QName("http://service.is.ftn/", "editObavezaResponse");
    private final static QName _GetOdslusaniPredmeti_QNAME = new QName("http://service.is.ftn/", "getOdslusaniPredmeti");
    private final static QName _EditNastavnikResponse_QNAME = new QName("http://service.is.ftn/", "editNastavnikResponse");
    private final static QName _EditGrupaResponse_QNAME = new QName("http://service.is.ftn/", "editGrupaResponse");
    private final static QName _EditStudent_QNAME = new QName("http://service.is.ftn/", "editStudent");
    private final static QName _AddStudentToGroupResponse_QNAME = new QName("http://service.is.ftn/", "addStudentToGroupResponse");
    private final static QName _ListStudenti_QNAME = new QName("http://service.is.ftn/", "listStudenti");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ftn.is.serviceGen.nastavnik
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddStudentToGroupResponse }
     * 
     */
    public AddStudentToGroupResponse createAddStudentToGroupResponse() {
        return new AddStudentToGroupResponse();
    }

    /**
     * Create an instance of {@link EditStudent }
     * 
     */
    public EditStudent createEditStudent() {
        return new EditStudent();
    }

    /**
     * Create an instance of {@link EditGrupaResponse }
     * 
     */
    public EditGrupaResponse createEditGrupaResponse() {
        return new EditGrupaResponse();
    }

    /**
     * Create an instance of {@link ListStudenti }
     * 
     */
    public ListStudenti createListStudenti() {
        return new ListStudenti();
    }

    /**
     * Create an instance of {@link GetStudentsInGroup }
     * 
     */
    public GetStudentsInGroup createGetStudentsInGroup() {
        return new GetStudentsInGroup();
    }

    /**
     * Create an instance of {@link GetPredmetiForNastavnik }
     * 
     */
    public GetPredmetiForNastavnik createGetPredmetiForNastavnik() {
        return new GetPredmetiForNastavnik();
    }

    /**
     * Create an instance of {@link GetOdslusaniPredmeti }
     * 
     */
    public GetOdslusaniPredmeti createGetOdslusaniPredmeti() {
        return new GetOdslusaniPredmeti();
    }

    /**
     * Create an instance of {@link EditObavezaResponse }
     * 
     */
    public EditObavezaResponse createEditObavezaResponse() {
        return new EditObavezaResponse();
    }

    /**
     * Create an instance of {@link EditNastavnikResponse }
     * 
     */
    public EditNastavnikResponse createEditNastavnikResponse() {
        return new EditNastavnikResponse();
    }

    /**
     * Create an instance of {@link EditObaveza }
     * 
     */
    public EditObaveza createEditObaveza() {
        return new EditObaveza();
    }

    /**
     * Create an instance of {@link GetNastavnik }
     * 
     */
    public GetNastavnik createGetNastavnik() {
        return new GetNastavnik();
    }

    /**
     * Create an instance of {@link GetPredmetiForNastavnikResponse }
     * 
     */
    public GetPredmetiForNastavnikResponse createGetPredmetiForNastavnikResponse() {
        return new GetPredmetiForNastavnikResponse();
    }

    /**
     * Create an instance of {@link AddGrupa }
     * 
     */
    public AddGrupa createAddGrupa() {
        return new AddGrupa();
    }

    /**
     * Create an instance of {@link ListStudentiResponse }
     * 
     */
    public ListStudentiResponse createListStudentiResponse() {
        return new ListStudentiResponse();
    }

    /**
     * Create an instance of {@link GetStudentsInGroupResponse }
     * 
     */
    public GetStudentsInGroupResponse createGetStudentsInGroupResponse() {
        return new GetStudentsInGroupResponse();
    }

    /**
     * Create an instance of {@link AddGrupaResponse }
     * 
     */
    public AddGrupaResponse createAddGrupaResponse() {
        return new AddGrupaResponse();
    }

    /**
     * Create an instance of {@link GetPrisustva }
     * 
     */
    public GetPrisustva createGetPrisustva() {
        return new GetPrisustva();
    }

    /**
     * Create an instance of {@link SetPrisustvaResponse }
     * 
     */
    public SetPrisustvaResponse createSetPrisustvaResponse() {
        return new SetPrisustvaResponse();
    }

    /**
     * Create an instance of {@link AddStudent }
     * 
     */
    public AddStudent createAddStudent() {
        return new AddStudent();
    }

    /**
     * Create an instance of {@link GetStudentsNotInGroups }
     * 
     */
    public GetStudentsNotInGroups createGetStudentsNotInGroups() {
        return new GetStudentsNotInGroups();
    }

    /**
     * Create an instance of {@link GetNastavnikResponse }
     * 
     */
    public GetNastavnikResponse createGetNastavnikResponse() {
        return new GetNastavnikResponse();
    }

    /**
     * Create an instance of {@link AddObaveza }
     * 
     */
    public AddObaveza createAddObaveza() {
        return new AddObaveza();
    }

    /**
     * Create an instance of {@link GetStudentsNotInGroupsResponse }
     * 
     */
    public GetStudentsNotInGroupsResponse createGetStudentsNotInGroupsResponse() {
        return new GetStudentsNotInGroupsResponse();
    }

    /**
     * Create an instance of {@link DeleteGrupa }
     * 
     */
    public DeleteGrupa createDeleteGrupa() {
        return new DeleteGrupa();
    }

    /**
     * Create an instance of {@link GetObavezeResponse }
     * 
     */
    public GetObavezeResponse createGetObavezeResponse() {
        return new GetObavezeResponse();
    }

    /**
     * Create an instance of {@link DeleteGrupaResponse }
     * 
     */
    public DeleteGrupaResponse createDeleteGrupaResponse() {
        return new DeleteGrupaResponse();
    }

    /**
     * Create an instance of {@link AddStudentToGroup }
     * 
     */
    public AddStudentToGroup createAddStudentToGroup() {
        return new AddStudentToGroup();
    }

    /**
     * Create an instance of {@link RemoveStudentFromGroup }
     * 
     */
    public RemoveStudentFromGroup createRemoveStudentFromGroup() {
        return new RemoveStudentFromGroup();
    }

    /**
     * Create an instance of {@link EditNastavnik }
     * 
     */
    public EditNastavnik createEditNastavnik() {
        return new EditNastavnik();
    }

    /**
     * Create an instance of {@link DeleteStudent }
     * 
     */
    public DeleteStudent createDeleteStudent() {
        return new DeleteStudent();
    }

    /**
     * Create an instance of {@link GetGrupeForPredmetResponse }
     * 
     */
    public GetGrupeForPredmetResponse createGetGrupeForPredmetResponse() {
        return new GetGrupeForPredmetResponse();
    }

    /**
     * Create an instance of {@link GetObaveze }
     * 
     */
    public GetObaveze createGetObaveze() {
        return new GetObaveze();
    }

    /**
     * Create an instance of {@link RemoveStudentFromGroupResponse }
     * 
     */
    public RemoveStudentFromGroupResponse createRemoveStudentFromGroupResponse() {
        return new RemoveStudentFromGroupResponse();
    }

    /**
     * Create an instance of {@link DeleteObavezaResponse }
     * 
     */
    public DeleteObavezaResponse createDeleteObavezaResponse() {
        return new DeleteObavezaResponse();
    }

    /**
     * Create an instance of {@link EditGrupa }
     * 
     */
    public EditGrupa createEditGrupa() {
        return new EditGrupa();
    }

    /**
     * Create an instance of {@link EditStudentResponse }
     * 
     */
    public EditStudentResponse createEditStudentResponse() {
        return new EditStudentResponse();
    }

    /**
     * Create an instance of {@link AddStudentResponse }
     * 
     */
    public AddStudentResponse createAddStudentResponse() {
        return new AddStudentResponse();
    }

    /**
     * Create an instance of {@link SetPrisustva }
     * 
     */
    public SetPrisustva createSetPrisustva() {
        return new SetPrisustva();
    }

    /**
     * Create an instance of {@link AddObavezaResponse }
     * 
     */
    public AddObavezaResponse createAddObavezaResponse() {
        return new AddObavezaResponse();
    }

    /**
     * Create an instance of {@link SetOdslusaniPredmetiResponse }
     * 
     */
    public SetOdslusaniPredmetiResponse createSetOdslusaniPredmetiResponse() {
        return new SetOdslusaniPredmetiResponse();
    }

    /**
     * Create an instance of {@link GetOdslusaniPredmetiResponse }
     * 
     */
    public GetOdslusaniPredmetiResponse createGetOdslusaniPredmetiResponse() {
        return new GetOdslusaniPredmetiResponse();
    }

    /**
     * Create an instance of {@link DeleteObaveza }
     * 
     */
    public DeleteObaveza createDeleteObaveza() {
        return new DeleteObaveza();
    }

    /**
     * Create an instance of {@link SetOdslusaniPredmeti }
     * 
     */
    public SetOdslusaniPredmeti createSetOdslusaniPredmeti() {
        return new SetOdslusaniPredmeti();
    }

    /**
     * Create an instance of {@link DeleteStudentResponse }
     * 
     */
    public DeleteStudentResponse createDeleteStudentResponse() {
        return new DeleteStudentResponse();
    }

    /**
     * Create an instance of {@link GetGrupeForPredmet }
     * 
     */
    public GetGrupeForPredmet createGetGrupeForPredmet() {
        return new GetGrupeForPredmet();
    }

    /**
     * Create an instance of {@link GetPrisustvaResponse }
     * 
     */
    public GetPrisustvaResponse createGetPrisustvaResponse() {
        return new GetPrisustvaResponse();
    }

    /**
     * Create an instance of {@link PripadnostGrupi }
     * 
     */
    public PripadnostGrupi createPripadnostGrupi() {
        return new PripadnostGrupi();
    }

    /**
     * Create an instance of {@link Grupa }
     * 
     */
    public Grupa createGrupa() {
        return new Grupa();
    }

    /**
     * Create an instance of {@link Ocena }
     * 
     */
    public Ocena createOcena() {
        return new Ocena();
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link Obaveza }
     * 
     */
    public Obaveza createObaveza() {
        return new Obaveza();
    }

    /**
     * Create an instance of {@link Nastavnik }
     * 
     */
    public Nastavnik createNastavnik() {
        return new Nastavnik();
    }

    /**
     * Create an instance of {@link OdslusanPredmet }
     * 
     */
    public OdslusanPredmet createOdslusanPredmet() {
        return new OdslusanPredmet();
    }

    /**
     * Create an instance of {@link Odsek }
     * 
     */
    public Odsek createOdsek() {
        return new Odsek();
    }

    /**
     * Create an instance of {@link Predmet }
     * 
     */
    public Predmet createPredmet() {
        return new Predmet();
    }

    /**
     * Create an instance of {@link Prisustvo }
     * 
     */
    public Prisustvo createPrisustvo() {
        return new Prisustvo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOdslusaniPredmetiResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "getOdslusaniPredmetiResponse")
    public JAXBElement<GetOdslusaniPredmetiResponse> createGetOdslusaniPredmetiResponse(GetOdslusaniPredmetiResponse value) {
        return new JAXBElement<GetOdslusaniPredmetiResponse>(_GetOdslusaniPredmetiResponse_QNAME, GetOdslusaniPredmetiResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetOdslusaniPredmetiResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "setOdslusaniPredmetiResponse")
    public JAXBElement<SetOdslusaniPredmetiResponse> createSetOdslusaniPredmetiResponse(SetOdslusaniPredmetiResponse value) {
        return new JAXBElement<SetOdslusaniPredmetiResponse>(_SetOdslusaniPredmetiResponse_QNAME, SetOdslusaniPredmetiResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteObaveza }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "deleteObaveza")
    public JAXBElement<DeleteObaveza> createDeleteObaveza(DeleteObaveza value) {
        return new JAXBElement<DeleteObaveza>(_DeleteObaveza_QNAME, DeleteObaveza.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetOdslusaniPredmeti }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "setOdslusaniPredmeti")
    public JAXBElement<SetOdslusaniPredmeti> createSetOdslusaniPredmeti(SetOdslusaniPredmeti value) {
        return new JAXBElement<SetOdslusaniPredmeti>(_SetOdslusaniPredmeti_QNAME, SetOdslusaniPredmeti.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPrisustvaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "getPrisustvaResponse")
    public JAXBElement<GetPrisustvaResponse> createGetPrisustvaResponse(GetPrisustvaResponse value) {
        return new JAXBElement<GetPrisustvaResponse>(_GetPrisustvaResponse_QNAME, GetPrisustvaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGrupeForPredmet }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "getGrupeForPredmet")
    public JAXBElement<GetGrupeForPredmet> createGetGrupeForPredmet(GetGrupeForPredmet value) {
        return new JAXBElement<GetGrupeForPredmet>(_GetGrupeForPredmet_QNAME, GetGrupeForPredmet.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "deleteStudentResponse")
    public JAXBElement<DeleteStudentResponse> createDeleteStudentResponse(DeleteStudentResponse value) {
        return new JAXBElement<DeleteStudentResponse>(_DeleteStudentResponse_QNAME, DeleteStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveStudentFromGroupResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "removeStudentFromGroupResponse")
    public JAXBElement<RemoveStudentFromGroupResponse> createRemoveStudentFromGroupResponse(RemoveStudentFromGroupResponse value) {
        return new JAXBElement<RemoveStudentFromGroupResponse>(_RemoveStudentFromGroupResponse_QNAME, RemoveStudentFromGroupResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "addStudentResponse")
    public JAXBElement<AddStudentResponse> createAddStudentResponse(AddStudentResponse value) {
        return new JAXBElement<AddStudentResponse>(_AddStudentResponse_QNAME, AddStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "editStudentResponse")
    public JAXBElement<EditStudentResponse> createEditStudentResponse(EditStudentResponse value) {
        return new JAXBElement<EditStudentResponse>(_EditStudentResponse_QNAME, EditStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditGrupa }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "editGrupa")
    public JAXBElement<EditGrupa> createEditGrupa(EditGrupa value) {
        return new JAXBElement<EditGrupa>(_EditGrupa_QNAME, EditGrupa.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteObavezaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "deleteObavezaResponse")
    public JAXBElement<DeleteObavezaResponse> createDeleteObavezaResponse(DeleteObavezaResponse value) {
        return new JAXBElement<DeleteObavezaResponse>(_DeleteObavezaResponse_QNAME, DeleteObavezaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddObavezaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "addObavezaResponse")
    public JAXBElement<AddObavezaResponse> createAddObavezaResponse(AddObavezaResponse value) {
        return new JAXBElement<AddObavezaResponse>(_AddObavezaResponse_QNAME, AddObavezaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetPrisustva }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "setPrisustva")
    public JAXBElement<SetPrisustva> createSetPrisustva(SetPrisustva value) {
        return new JAXBElement<SetPrisustva>(_SetPrisustva_QNAME, SetPrisustva.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveStudentFromGroup }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "removeStudentFromGroup")
    public JAXBElement<RemoveStudentFromGroup> createRemoveStudentFromGroup(RemoveStudentFromGroup value) {
        return new JAXBElement<RemoveStudentFromGroup>(_RemoveStudentFromGroup_QNAME, RemoveStudentFromGroup.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditNastavnik }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "editNastavnik")
    public JAXBElement<EditNastavnik> createEditNastavnik(EditNastavnik value) {
        return new JAXBElement<EditNastavnik>(_EditNastavnik_QNAME, EditNastavnik.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetObaveze }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "getObaveze")
    public JAXBElement<GetObaveze> createGetObaveze(GetObaveze value) {
        return new JAXBElement<GetObaveze>(_GetObaveze_QNAME, GetObaveze.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGrupeForPredmetResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "getGrupeForPredmetResponse")
    public JAXBElement<GetGrupeForPredmetResponse> createGetGrupeForPredmetResponse(GetGrupeForPredmetResponse value) {
        return new JAXBElement<GetGrupeForPredmetResponse>(_GetGrupeForPredmetResponse_QNAME, GetGrupeForPredmetResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "deleteStudent")
    public JAXBElement<DeleteStudent> createDeleteStudent(DeleteStudent value) {
        return new JAXBElement<DeleteStudent>(_DeleteStudent_QNAME, DeleteStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsNotInGroups }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "getStudentsNotInGroups")
    public JAXBElement<GetStudentsNotInGroups> createGetStudentsNotInGroups(GetStudentsNotInGroups value) {
        return new JAXBElement<GetStudentsNotInGroups>(_GetStudentsNotInGroups_QNAME, GetStudentsNotInGroups.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetPrisustvaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "setPrisustvaResponse")
    public JAXBElement<SetPrisustvaResponse> createSetPrisustvaResponse(SetPrisustvaResponse value) {
        return new JAXBElement<SetPrisustvaResponse>(_SetPrisustvaResponse_QNAME, SetPrisustvaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "addStudent")
    public JAXBElement<AddStudent> createAddStudent(AddStudent value) {
        return new JAXBElement<AddStudent>(_AddStudent_QNAME, AddStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNastavnikResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "getNastavnikResponse")
    public JAXBElement<GetNastavnikResponse> createGetNastavnikResponse(GetNastavnikResponse value) {
        return new JAXBElement<GetNastavnikResponse>(_GetNastavnikResponse_QNAME, GetNastavnikResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddObaveza }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "addObaveza")
    public JAXBElement<AddObaveza> createAddObaveza(AddObaveza value) {
        return new JAXBElement<AddObaveza>(_AddObaveza_QNAME, AddObaveza.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteGrupa }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "deleteGrupa")
    public JAXBElement<DeleteGrupa> createDeleteGrupa(DeleteGrupa value) {
        return new JAXBElement<DeleteGrupa>(_DeleteGrupa_QNAME, DeleteGrupa.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsNotInGroupsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "getStudentsNotInGroupsResponse")
    public JAXBElement<GetStudentsNotInGroupsResponse> createGetStudentsNotInGroupsResponse(GetStudentsNotInGroupsResponse value) {
        return new JAXBElement<GetStudentsNotInGroupsResponse>(_GetStudentsNotInGroupsResponse_QNAME, GetStudentsNotInGroupsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudentToGroup }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "addStudentToGroup")
    public JAXBElement<AddStudentToGroup> createAddStudentToGroup(AddStudentToGroup value) {
        return new JAXBElement<AddStudentToGroup>(_AddStudentToGroup_QNAME, AddStudentToGroup.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteGrupaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "deleteGrupaResponse")
    public JAXBElement<DeleteGrupaResponse> createDeleteGrupaResponse(DeleteGrupaResponse value) {
        return new JAXBElement<DeleteGrupaResponse>(_DeleteGrupaResponse_QNAME, DeleteGrupaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetObavezeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "getObavezeResponse")
    public JAXBElement<GetObavezeResponse> createGetObavezeResponse(GetObavezeResponse value) {
        return new JAXBElement<GetObavezeResponse>(_GetObavezeResponse_QNAME, GetObavezeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListStudentiResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "listStudentiResponse")
    public JAXBElement<ListStudentiResponse> createListStudentiResponse(ListStudentiResponse value) {
        return new JAXBElement<ListStudentiResponse>(_ListStudentiResponse_QNAME, ListStudentiResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPrisustva }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "getPrisustva")
    public JAXBElement<GetPrisustva> createGetPrisustva(GetPrisustva value) {
        return new JAXBElement<GetPrisustva>(_GetPrisustva_QNAME, GetPrisustva.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsInGroupResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "getStudentsInGroupResponse")
    public JAXBElement<GetStudentsInGroupResponse> createGetStudentsInGroupResponse(GetStudentsInGroupResponse value) {
        return new JAXBElement<GetStudentsInGroupResponse>(_GetStudentsInGroupResponse_QNAME, GetStudentsInGroupResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddGrupaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "addGrupaResponse")
    public JAXBElement<AddGrupaResponse> createAddGrupaResponse(AddGrupaResponse value) {
        return new JAXBElement<AddGrupaResponse>(_AddGrupaResponse_QNAME, AddGrupaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditObaveza }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "editObaveza")
    public JAXBElement<EditObaveza> createEditObaveza(EditObaveza value) {
        return new JAXBElement<EditObaveza>(_EditObaveza_QNAME, EditObaveza.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNastavnik }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "getNastavnik")
    public JAXBElement<GetNastavnik> createGetNastavnik(GetNastavnik value) {
        return new JAXBElement<GetNastavnik>(_GetNastavnik_QNAME, GetNastavnik.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddGrupa }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "addGrupa")
    public JAXBElement<AddGrupa> createAddGrupa(AddGrupa value) {
        return new JAXBElement<AddGrupa>(_AddGrupa_QNAME, AddGrupa.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPredmetiForNastavnikResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "getPredmetiForNastavnikResponse")
    public JAXBElement<GetPredmetiForNastavnikResponse> createGetPredmetiForNastavnikResponse(GetPredmetiForNastavnikResponse value) {
        return new JAXBElement<GetPredmetiForNastavnikResponse>(_GetPredmetiForNastavnikResponse_QNAME, GetPredmetiForNastavnikResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPredmetiForNastavnik }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "getPredmetiForNastavnik")
    public JAXBElement<GetPredmetiForNastavnik> createGetPredmetiForNastavnik(GetPredmetiForNastavnik value) {
        return new JAXBElement<GetPredmetiForNastavnik>(_GetPredmetiForNastavnik_QNAME, GetPredmetiForNastavnik.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsInGroup }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "getStudentsInGroup")
    public JAXBElement<GetStudentsInGroup> createGetStudentsInGroup(GetStudentsInGroup value) {
        return new JAXBElement<GetStudentsInGroup>(_GetStudentsInGroup_QNAME, GetStudentsInGroup.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditObavezaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "editObavezaResponse")
    public JAXBElement<EditObavezaResponse> createEditObavezaResponse(EditObavezaResponse value) {
        return new JAXBElement<EditObavezaResponse>(_EditObavezaResponse_QNAME, EditObavezaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOdslusaniPredmeti }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "getOdslusaniPredmeti")
    public JAXBElement<GetOdslusaniPredmeti> createGetOdslusaniPredmeti(GetOdslusaniPredmeti value) {
        return new JAXBElement<GetOdslusaniPredmeti>(_GetOdslusaniPredmeti_QNAME, GetOdslusaniPredmeti.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditNastavnikResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "editNastavnikResponse")
    public JAXBElement<EditNastavnikResponse> createEditNastavnikResponse(EditNastavnikResponse value) {
        return new JAXBElement<EditNastavnikResponse>(_EditNastavnikResponse_QNAME, EditNastavnikResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditGrupaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "editGrupaResponse")
    public JAXBElement<EditGrupaResponse> createEditGrupaResponse(EditGrupaResponse value) {
        return new JAXBElement<EditGrupaResponse>(_EditGrupaResponse_QNAME, EditGrupaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "editStudent")
    public JAXBElement<EditStudent> createEditStudent(EditStudent value) {
        return new JAXBElement<EditStudent>(_EditStudent_QNAME, EditStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudentToGroupResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "addStudentToGroupResponse")
    public JAXBElement<AddStudentToGroupResponse> createAddStudentToGroupResponse(AddStudentToGroupResponse value) {
        return new JAXBElement<AddStudentToGroupResponse>(_AddStudentToGroupResponse_QNAME, AddStudentToGroupResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListStudenti }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "listStudenti")
    public JAXBElement<ListStudenti> createListStudenti(ListStudenti value) {
        return new JAXBElement<ListStudenti>(_ListStudenti_QNAME, ListStudenti.class, null, value);
    }

}
