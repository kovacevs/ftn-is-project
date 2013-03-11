
package ftn.is.serviceGen.administrator;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ftn.is.serviceGen.administrator package. 
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

    private final static QName _DeleteOdsek_QNAME = new QName("http://service.is.ftn/", "deleteOdsek");
    private final static QName _ListOdseciResponse_QNAME = new QName("http://service.is.ftn/", "listOdseciResponse");
    private final static QName _DeleteNastavnik_QNAME = new QName("http://service.is.ftn/", "deleteNastavnik");
    private final static QName _DeletePredmetResponse_QNAME = new QName("http://service.is.ftn/", "deletePredmetResponse");
    private final static QName _EditAdministrator_QNAME = new QName("http://service.is.ftn/", "editAdministrator");
    private final static QName _AddPredmet_QNAME = new QName("http://service.is.ftn/", "addPredmet");
    private final static QName _DeleteNastavnikResponse_QNAME = new QName("http://service.is.ftn/", "deleteNastavnikResponse");
    private final static QName _DeletePredmet_QNAME = new QName("http://service.is.ftn/", "deletePredmet");
    private final static QName _GetAdmin_QNAME = new QName("http://service.is.ftn/", "getAdmin");
    private final static QName _Restore_QNAME = new QName("http://service.is.ftn/", "restore");
    private final static QName _ListOdseci_QNAME = new QName("http://service.is.ftn/", "listOdseci");
    private final static QName _EditNastavnik_QNAME = new QName("http://service.is.ftn/", "editNastavnik");
    private final static QName _DeleteOdsekResponse_QNAME = new QName("http://service.is.ftn/", "deleteOdsekResponse");
    private final static QName _ListPredmeti_QNAME = new QName("http://service.is.ftn/", "listPredmeti");
    private final static QName _AddPredmetResponse_QNAME = new QName("http://service.is.ftn/", "addPredmetResponse");
    private final static QName _GetAdminResponse_QNAME = new QName("http://service.is.ftn/", "getAdminResponse");
    private final static QName _AddOdsekResponse_QNAME = new QName("http://service.is.ftn/", "addOdsekResponse");
    private final static QName _Backup_QNAME = new QName("http://service.is.ftn/", "backup");
    private final static QName _EditOdsekResponse_QNAME = new QName("http://service.is.ftn/", "editOdsekResponse");
    private final static QName _AddOdsek_QNAME = new QName("http://service.is.ftn/", "addOdsek");
    private final static QName _EditPredmetResponse_QNAME = new QName("http://service.is.ftn/", "editPredmetResponse");
    private final static QName _EditAdministratorResponse_QNAME = new QName("http://service.is.ftn/", "editAdministratorResponse");
    private final static QName _ListNastavniciResponse_QNAME = new QName("http://service.is.ftn/", "listNastavniciResponse");
    private final static QName _ListNastavnici_QNAME = new QName("http://service.is.ftn/", "listNastavnici");
    private final static QName _ListPredmetiResponse_QNAME = new QName("http://service.is.ftn/", "listPredmetiResponse");
    private final static QName _AddNastavnikResponse_QNAME = new QName("http://service.is.ftn/", "addNastavnikResponse");
    private final static QName _AddNastavnik_QNAME = new QName("http://service.is.ftn/", "addNastavnik");
    private final static QName _RestoreResponse_QNAME = new QName("http://service.is.ftn/", "restoreResponse");
    private final static QName _EditOdsek_QNAME = new QName("http://service.is.ftn/", "editOdsek");
    private final static QName _EditNastavnikResponse_QNAME = new QName("http://service.is.ftn/", "editNastavnikResponse");
    private final static QName _BackupResponse_QNAME = new QName("http://service.is.ftn/", "backupResponse");
    private final static QName _EditPredmet_QNAME = new QName("http://service.is.ftn/", "editPredmet");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ftn.is.serviceGen.administrator
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BackupResponse }
     * 
     */
    public BackupResponse createBackupResponse() {
        return new BackupResponse();
    }

    /**
     * Create an instance of {@link EditPredmet }
     * 
     */
    public EditPredmet createEditPredmet() {
        return new EditPredmet();
    }

    /**
     * Create an instance of {@link AddNastavnikResponse }
     * 
     */
    public AddNastavnikResponse createAddNastavnikResponse() {
        return new AddNastavnikResponse();
    }

    /**
     * Create an instance of {@link EditOdsek }
     * 
     */
    public EditOdsek createEditOdsek() {
        return new EditOdsek();
    }

    /**
     * Create an instance of {@link RestoreResponse }
     * 
     */
    public RestoreResponse createRestoreResponse() {
        return new RestoreResponse();
    }

    /**
     * Create an instance of {@link AddNastavnik }
     * 
     */
    public AddNastavnik createAddNastavnik() {
        return new AddNastavnik();
    }

    /**
     * Create an instance of {@link EditNastavnikResponse }
     * 
     */
    public EditNastavnikResponse createEditNastavnikResponse() {
        return new EditNastavnikResponse();
    }

    /**
     * Create an instance of {@link ListNastavniciResponse }
     * 
     */
    public ListNastavniciResponse createListNastavniciResponse() {
        return new ListNastavniciResponse();
    }

    /**
     * Create an instance of {@link EditAdministratorResponse }
     * 
     */
    public EditAdministratorResponse createEditAdministratorResponse() {
        return new EditAdministratorResponse();
    }

    /**
     * Create an instance of {@link ListNastavnici }
     * 
     */
    public ListNastavnici createListNastavnici() {
        return new ListNastavnici();
    }

    /**
     * Create an instance of {@link ListPredmetiResponse }
     * 
     */
    public ListPredmetiResponse createListPredmetiResponse() {
        return new ListPredmetiResponse();
    }

    /**
     * Create an instance of {@link AddOdsekResponse }
     * 
     */
    public AddOdsekResponse createAddOdsekResponse() {
        return new AddOdsekResponse();
    }

    /**
     * Create an instance of {@link AddOdsek }
     * 
     */
    public AddOdsek createAddOdsek() {
        return new AddOdsek();
    }

    /**
     * Create an instance of {@link EditPredmetResponse }
     * 
     */
    public EditPredmetResponse createEditPredmetResponse() {
        return new EditPredmetResponse();
    }

    /**
     * Create an instance of {@link Backup }
     * 
     */
    public Backup createBackup() {
        return new Backup();
    }

    /**
     * Create an instance of {@link EditOdsekResponse }
     * 
     */
    public EditOdsekResponse createEditOdsekResponse() {
        return new EditOdsekResponse();
    }

    /**
     * Create an instance of {@link DeleteOdsekResponse }
     * 
     */
    public DeleteOdsekResponse createDeleteOdsekResponse() {
        return new DeleteOdsekResponse();
    }

    /**
     * Create an instance of {@link ListPredmeti }
     * 
     */
    public ListPredmeti createListPredmeti() {
        return new ListPredmeti();
    }

    /**
     * Create an instance of {@link AddPredmetResponse }
     * 
     */
    public AddPredmetResponse createAddPredmetResponse() {
        return new AddPredmetResponse();
    }

    /**
     * Create an instance of {@link GetAdminResponse }
     * 
     */
    public GetAdminResponse createGetAdminResponse() {
        return new GetAdminResponse();
    }

    /**
     * Create an instance of {@link ListOdseci }
     * 
     */
    public ListOdseci createListOdseci() {
        return new ListOdseci();
    }

    /**
     * Create an instance of {@link EditNastavnik }
     * 
     */
    public EditNastavnik createEditNastavnik() {
        return new EditNastavnik();
    }

    /**
     * Create an instance of {@link DeleteNastavnik }
     * 
     */
    public DeleteNastavnik createDeleteNastavnik() {
        return new DeleteNastavnik();
    }

    /**
     * Create an instance of {@link ListOdseciResponse }
     * 
     */
    public ListOdseciResponse createListOdseciResponse() {
        return new ListOdseciResponse();
    }

    /**
     * Create an instance of {@link DeletePredmetResponse }
     * 
     */
    public DeletePredmetResponse createDeletePredmetResponse() {
        return new DeletePredmetResponse();
    }

    /**
     * Create an instance of {@link Restore }
     * 
     */
    public Restore createRestore() {
        return new Restore();
    }

    /**
     * Create an instance of {@link GetAdmin }
     * 
     */
    public GetAdmin createGetAdmin() {
        return new GetAdmin();
    }

    /**
     * Create an instance of {@link DeletePredmet }
     * 
     */
    public DeletePredmet createDeletePredmet() {
        return new DeletePredmet();
    }

    /**
     * Create an instance of {@link DeleteNastavnikResponse }
     * 
     */
    public DeleteNastavnikResponse createDeleteNastavnikResponse() {
        return new DeleteNastavnikResponse();
    }

    /**
     * Create an instance of {@link AddPredmet }
     * 
     */
    public AddPredmet createAddPredmet() {
        return new AddPredmet();
    }

    /**
     * Create an instance of {@link EditAdministrator }
     * 
     */
    public EditAdministrator createEditAdministrator() {
        return new EditAdministrator();
    }

    /**
     * Create an instance of {@link DeleteOdsek }
     * 
     */
    public DeleteOdsek createDeleteOdsek() {
        return new DeleteOdsek();
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
     * Create an instance of {@link Nastavnik }
     * 
     */
    public Nastavnik createNastavnik() {
        return new Nastavnik();
    }

    /**
     * Create an instance of {@link Administrator }
     * 
     */
    public Administrator createAdministrator() {
        return new Administrator();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteOdsek }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "deleteOdsek")
    public JAXBElement<DeleteOdsek> createDeleteOdsek(DeleteOdsek value) {
        return new JAXBElement<DeleteOdsek>(_DeleteOdsek_QNAME, DeleteOdsek.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListOdseciResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "listOdseciResponse")
    public JAXBElement<ListOdseciResponse> createListOdseciResponse(ListOdseciResponse value) {
        return new JAXBElement<ListOdseciResponse>(_ListOdseciResponse_QNAME, ListOdseciResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteNastavnik }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "deleteNastavnik")
    public JAXBElement<DeleteNastavnik> createDeleteNastavnik(DeleteNastavnik value) {
        return new JAXBElement<DeleteNastavnik>(_DeleteNastavnik_QNAME, DeleteNastavnik.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePredmetResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "deletePredmetResponse")
    public JAXBElement<DeletePredmetResponse> createDeletePredmetResponse(DeletePredmetResponse value) {
        return new JAXBElement<DeletePredmetResponse>(_DeletePredmetResponse_QNAME, DeletePredmetResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditAdministrator }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "editAdministrator")
    public JAXBElement<EditAdministrator> createEditAdministrator(EditAdministrator value) {
        return new JAXBElement<EditAdministrator>(_EditAdministrator_QNAME, EditAdministrator.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPredmet }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "addPredmet")
    public JAXBElement<AddPredmet> createAddPredmet(AddPredmet value) {
        return new JAXBElement<AddPredmet>(_AddPredmet_QNAME, AddPredmet.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteNastavnikResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "deleteNastavnikResponse")
    public JAXBElement<DeleteNastavnikResponse> createDeleteNastavnikResponse(DeleteNastavnikResponse value) {
        return new JAXBElement<DeleteNastavnikResponse>(_DeleteNastavnikResponse_QNAME, DeleteNastavnikResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePredmet }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "deletePredmet")
    public JAXBElement<DeletePredmet> createDeletePredmet(DeletePredmet value) {
        return new JAXBElement<DeletePredmet>(_DeletePredmet_QNAME, DeletePredmet.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAdmin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "getAdmin")
    public JAXBElement<GetAdmin> createGetAdmin(GetAdmin value) {
        return new JAXBElement<GetAdmin>(_GetAdmin_QNAME, GetAdmin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Restore }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "restore")
    public JAXBElement<Restore> createRestore(Restore value) {
        return new JAXBElement<Restore>(_Restore_QNAME, Restore.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListOdseci }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "listOdseci")
    public JAXBElement<ListOdseci> createListOdseci(ListOdseci value) {
        return new JAXBElement<ListOdseci>(_ListOdseci_QNAME, ListOdseci.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteOdsekResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "deleteOdsekResponse")
    public JAXBElement<DeleteOdsekResponse> createDeleteOdsekResponse(DeleteOdsekResponse value) {
        return new JAXBElement<DeleteOdsekResponse>(_DeleteOdsekResponse_QNAME, DeleteOdsekResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListPredmeti }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "listPredmeti")
    public JAXBElement<ListPredmeti> createListPredmeti(ListPredmeti value) {
        return new JAXBElement<ListPredmeti>(_ListPredmeti_QNAME, ListPredmeti.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPredmetResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "addPredmetResponse")
    public JAXBElement<AddPredmetResponse> createAddPredmetResponse(AddPredmetResponse value) {
        return new JAXBElement<AddPredmetResponse>(_AddPredmetResponse_QNAME, AddPredmetResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAdminResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "getAdminResponse")
    public JAXBElement<GetAdminResponse> createGetAdminResponse(GetAdminResponse value) {
        return new JAXBElement<GetAdminResponse>(_GetAdminResponse_QNAME, GetAdminResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddOdsekResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "addOdsekResponse")
    public JAXBElement<AddOdsekResponse> createAddOdsekResponse(AddOdsekResponse value) {
        return new JAXBElement<AddOdsekResponse>(_AddOdsekResponse_QNAME, AddOdsekResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Backup }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "backup")
    public JAXBElement<Backup> createBackup(Backup value) {
        return new JAXBElement<Backup>(_Backup_QNAME, Backup.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditOdsekResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "editOdsekResponse")
    public JAXBElement<EditOdsekResponse> createEditOdsekResponse(EditOdsekResponse value) {
        return new JAXBElement<EditOdsekResponse>(_EditOdsekResponse_QNAME, EditOdsekResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddOdsek }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "addOdsek")
    public JAXBElement<AddOdsek> createAddOdsek(AddOdsek value) {
        return new JAXBElement<AddOdsek>(_AddOdsek_QNAME, AddOdsek.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditPredmetResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "editPredmetResponse")
    public JAXBElement<EditPredmetResponse> createEditPredmetResponse(EditPredmetResponse value) {
        return new JAXBElement<EditPredmetResponse>(_EditPredmetResponse_QNAME, EditPredmetResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditAdministratorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "editAdministratorResponse")
    public JAXBElement<EditAdministratorResponse> createEditAdministratorResponse(EditAdministratorResponse value) {
        return new JAXBElement<EditAdministratorResponse>(_EditAdministratorResponse_QNAME, EditAdministratorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListNastavniciResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "listNastavniciResponse")
    public JAXBElement<ListNastavniciResponse> createListNastavniciResponse(ListNastavniciResponse value) {
        return new JAXBElement<ListNastavniciResponse>(_ListNastavniciResponse_QNAME, ListNastavniciResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListNastavnici }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "listNastavnici")
    public JAXBElement<ListNastavnici> createListNastavnici(ListNastavnici value) {
        return new JAXBElement<ListNastavnici>(_ListNastavnici_QNAME, ListNastavnici.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListPredmetiResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "listPredmetiResponse")
    public JAXBElement<ListPredmetiResponse> createListPredmetiResponse(ListPredmetiResponse value) {
        return new JAXBElement<ListPredmetiResponse>(_ListPredmetiResponse_QNAME, ListPredmetiResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddNastavnikResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "addNastavnikResponse")
    public JAXBElement<AddNastavnikResponse> createAddNastavnikResponse(AddNastavnikResponse value) {
        return new JAXBElement<AddNastavnikResponse>(_AddNastavnikResponse_QNAME, AddNastavnikResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddNastavnik }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "addNastavnik")
    public JAXBElement<AddNastavnik> createAddNastavnik(AddNastavnik value) {
        return new JAXBElement<AddNastavnik>(_AddNastavnik_QNAME, AddNastavnik.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RestoreResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "restoreResponse")
    public JAXBElement<RestoreResponse> createRestoreResponse(RestoreResponse value) {
        return new JAXBElement<RestoreResponse>(_RestoreResponse_QNAME, RestoreResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditOdsek }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "editOdsek")
    public JAXBElement<EditOdsek> createEditOdsek(EditOdsek value) {
        return new JAXBElement<EditOdsek>(_EditOdsek_QNAME, EditOdsek.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link BackupResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "backupResponse")
    public JAXBElement<BackupResponse> createBackupResponse(BackupResponse value) {
        return new JAXBElement<BackupResponse>(_BackupResponse_QNAME, BackupResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditPredmet }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.is.ftn/", name = "editPredmet")
    public JAXBElement<EditPredmet> createEditPredmet(EditPredmet value) {
        return new JAXBElement<EditPredmet>(_EditPredmet_QNAME, EditPredmet.class, null, value);
    }

}
