package ftn.is.serviceGen.nastavnik;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.4.6
 * 2012-12-17T00:22:10.218+01:00
 * Generated source version: 2.4.6
 * 
 */
@WebServiceClient(name = "NastavnikServiceService", 
                  wsdlLocation = "http://localhost:80/ftn-is-ejb-1.0/NastavnikService?wsdl",
                  targetNamespace = "http://service.is.ftn/") 
public class NastavnikServiceService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://service.is.ftn/", "NastavnikServiceService");
    public final static QName NastavnikServicePort = new QName("http://service.is.ftn/", "NastavnikServicePort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:80/ftn-is-ejb-1.0/NastavnikService?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(NastavnikServiceService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:80/ftn-is-ejb-1.0/NastavnikService?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public NastavnikServiceService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public NastavnikServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public NastavnikServiceService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public NastavnikServiceService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public NastavnikServiceService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public NastavnikServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns NastavnikService
     */
    @WebEndpoint(name = "NastavnikServicePort")
    public NastavnikService getNastavnikServicePort() {
        return super.getPort(NastavnikServicePort, NastavnikService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns NastavnikService
     */
    @WebEndpoint(name = "NastavnikServicePort")
    public NastavnikService getNastavnikServicePort(WebServiceFeature... features) {
        return super.getPort(NastavnikServicePort, NastavnikService.class, features);
    }

}
