
package pe.com.comtecsis.webservices.loginservices;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ServiceClientServicesPortType", targetNamespace = "http://loginservices.webservices.comtecsis.com.pe")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ServiceClientServicesPortType {


    /**
     * 
     * @return
     *     returns pe.com.comtecsis.webservices.loginservices.LogoutResult
     * @throws WsException_Exception
     */
    @WebMethod(action = "https://crud.comtecsis.com.pe/login-services/logout")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "logout", targetNamespace = "http://loginservices.webservices.comtecsis.com.pe", className = "pe.com.comtecsis.webservices.loginservices.Logout")
    @ResponseWrapper(localName = "logoutResponse", targetNamespace = "http://loginservices.webservices.comtecsis.com.pe", className = "pe.com.comtecsis.webservices.loginservices.LogoutResponse")
    public LogoutResult logout()
        throws WsException_Exception
    ;

    /**
     * 
     * @param request
     * @return
     *     returns pe.com.comtecsis.webservices.loginservices.InitResult
     * @throws WsException_Exception
     */
    @WebMethod(action = "https://crud.comtecsis.com.pe/login-services/init")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "init", targetNamespace = "http://loginservices.webservices.comtecsis.com.pe", className = "pe.com.comtecsis.webservices.loginservices.Init")
    @ResponseWrapper(localName = "initResponse", targetNamespace = "http://loginservices.webservices.comtecsis.com.pe", className = "pe.com.comtecsis.webservices.loginservices.InitResponse")
    public InitResult init(
        @WebParam(name = "request", targetNamespace = "")
        LoginRequest request)
        throws WsException_Exception
    ;

    /**
     * 
     * @param request
     * @return
     *     returns pe.com.comtecsis.webservices.loginservices.LoginResult
     * @throws WsException_Exception
     */
    @WebMethod(action = "https://crud.comtecsis.com.pe/login-services/login")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "login", targetNamespace = "http://loginservices.webservices.comtecsis.com.pe", className = "pe.com.comtecsis.webservices.loginservices.Login")
    @ResponseWrapper(localName = "loginResponse", targetNamespace = "http://loginservices.webservices.comtecsis.com.pe", className = "pe.com.comtecsis.webservices.loginservices.LoginResponse")
    public LoginResult login(
        @WebParam(name = "request", targetNamespace = "")
        LoginRequest request)
        throws WsException_Exception
    ;

}
