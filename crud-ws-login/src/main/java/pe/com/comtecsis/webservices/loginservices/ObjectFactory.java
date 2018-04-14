
package pe.com.comtecsis.webservices.loginservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pe.com.comtecsis.webservices.loginservices package. 
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

    private final static QName _WsException_QNAME = new QName("http://loginservices.webservices.comtecsis.com.pe", "WsException");
    private final static QName _Login_QNAME = new QName("http://loginservices.webservices.comtecsis.com.pe", "login");
    private final static QName _LoginResponse_QNAME = new QName("http://loginservices.webservices.comtecsis.com.pe", "loginResponse");
    private final static QName _LogoutResponse_QNAME = new QName("http://loginservices.webservices.comtecsis.com.pe", "logoutResponse");
    private final static QName _Logout_QNAME = new QName("http://loginservices.webservices.comtecsis.com.pe", "logout");
    private final static QName _Init_QNAME = new QName("http://loginservices.webservices.comtecsis.com.pe", "init");
    private final static QName _InitResponse_QNAME = new QName("http://loginservices.webservices.comtecsis.com.pe", "initResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pe.com.comtecsis.webservices.loginservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Init }
     * 
     */
    public Init createInit() {
        return new Init();
    }

    /**
     * Create an instance of {@link Logout }
     * 
     */
    public Logout createLogout() {
        return new Logout();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link LogoutResponse }
     * 
     */
    public LogoutResponse createLogoutResponse() {
        return new LogoutResponse();
    }

    /**
     * Create an instance of {@link InitResponse }
     * 
     */
    public InitResponse createInitResponse() {
        return new InitResponse();
    }

    /**
     * Create an instance of {@link WsException }
     * 
     */
    public WsException createWsException() {
        return new WsException();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link LoginResult }
     * 
     */
    public LoginResult createLoginResult() {
        return new LoginResult();
    }

    /**
     * Create an instance of {@link LoginRequest }
     * 
     */
    public LoginRequest createLoginRequest() {
        return new LoginRequest();
    }

    /**
     * Create an instance of {@link LogoutResult }
     * 
     */
    public LogoutResult createLogoutResult() {
        return new LogoutResult();
    }

    /**
     * Create an instance of {@link InitResult }
     * 
     */
    public InitResult createInitResult() {
        return new InitResult();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WsException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://loginservices.webservices.comtecsis.com.pe", name = "WsException")
    public JAXBElement<WsException> createWsException(WsException value) {
        return new JAXBElement<WsException>(_WsException_QNAME, WsException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://loginservices.webservices.comtecsis.com.pe", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://loginservices.webservices.comtecsis.com.pe", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogoutResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://loginservices.webservices.comtecsis.com.pe", name = "logoutResponse")
    public JAXBElement<LogoutResponse> createLogoutResponse(LogoutResponse value) {
        return new JAXBElement<LogoutResponse>(_LogoutResponse_QNAME, LogoutResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Logout }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://loginservices.webservices.comtecsis.com.pe", name = "logout")
    public JAXBElement<Logout> createLogout(Logout value) {
        return new JAXBElement<Logout>(_Logout_QNAME, Logout.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Init }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://loginservices.webservices.comtecsis.com.pe", name = "init")
    public JAXBElement<Init> createInit(Init value) {
        return new JAXBElement<Init>(_Init_QNAME, Init.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InitResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://loginservices.webservices.comtecsis.com.pe", name = "initResponse")
    public JAXBElement<InitResponse> createInitResponse(InitResponse value) {
        return new JAXBElement<InitResponse>(_InitResponse_QNAME, InitResponse.class, null, value);
    }

}
