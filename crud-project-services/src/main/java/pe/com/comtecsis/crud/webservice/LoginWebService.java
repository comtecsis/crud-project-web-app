package pe.com.comtecsis.crud.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import pe.com.comtecsis.crud.service.exception.WsException;
import pe.com.comtecsis.crud.service.request.LoginRequest;
import pe.com.comtecsis.crud.service.response.InitResult;
import pe.com.comtecsis.crud.service.response.LoginResult;
import pe.com.comtecsis.crud.service.response.LogoutResult;
import pe.com.comtecsis.crud.service.response.ValidateResult;

@WebService(name = "ServiceClientServicesPortType", targetNamespace = "http://loginservices.webservices.comtecsis.com.pe")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface LoginWebService {
	
	@WebMethod(operationName = "login", action = "https://crud.comtecsis.com.pe/login-services/login")
    public LoginResult login(@WebParam(name = "request") LoginRequest request) throws WsException;
	
	@WebMethod(operationName = "init", action = "https://crud.comtecsis.com.pe/login-services/init")
    public InitResult init(@WebParam(name = "request") LoginRequest request) throws WsException;
	
	@WebMethod(operationName = "validate", action = "https://crud.comtecsis.com.pe/login-services/validate")
    public ValidateResult validate() throws WsException;
	
	@WebMethod(operationName = "logout", action = "https://crud.comtecsis.com.pe/login-services/logout")
    public LogoutResult logout() throws WsException;
	
}
