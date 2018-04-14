
package pe.com.comtecsis.webservices.loginservices;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "LoginWebService", targetNamespace = "http://loginservices.webservices.comtecsis.com.pe", wsdlLocation = "http://localhost:9080/crudprojecws/loginservice?wsdl")
public class LoginWebService
    extends Service
{

    private final static URL LOGINWEBSERVICE_WSDL_LOCATION;
    private final static WebServiceException LOGINWEBSERVICE_EXCEPTION;
    private final static QName LOGINWEBSERVICE_QNAME = new QName("http://loginservices.webservices.comtecsis.com.pe", "LoginWebService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9080/crudprojecws/loginservice?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        LOGINWEBSERVICE_WSDL_LOCATION = url;
        LOGINWEBSERVICE_EXCEPTION = e;
    }

    public LoginWebService() {
        super(__getWsdlLocation(), LOGINWEBSERVICE_QNAME);
    }

    public LoginWebService(WebServiceFeature... features) {
        super(__getWsdlLocation(), LOGINWEBSERVICE_QNAME, features);
    }

    public LoginWebService(URL wsdlLocation) {
        super(wsdlLocation, LOGINWEBSERVICE_QNAME);
    }

    public LoginWebService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, LOGINWEBSERVICE_QNAME, features);
    }

    public LoginWebService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public LoginWebService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ServiceClientServicesPortType
     */
    @WebEndpoint(name = "LoginWebServicePort")
    public ServiceClientServicesPortType getLoginWebServicePort() {
        return super.getPort(new QName("http://loginservices.webservices.comtecsis.com.pe", "LoginWebServicePort"), ServiceClientServicesPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServiceClientServicesPortType
     */
    @WebEndpoint(name = "LoginWebServicePort")
    public ServiceClientServicesPortType getLoginWebServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://loginservices.webservices.comtecsis.com.pe", "LoginWebServicePort"), ServiceClientServicesPortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (LOGINWEBSERVICE_EXCEPTION!= null) {
            throw LOGINWEBSERVICE_EXCEPTION;
        }
        return LOGINWEBSERVICE_WSDL_LOCATION;
    }

}
