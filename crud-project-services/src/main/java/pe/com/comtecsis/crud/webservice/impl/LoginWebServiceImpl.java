package pe.com.comtecsis.crud.webservice.impl;

import javax.annotation.Resource;
import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import org.springframework.beans.factory.annotation.Autowired;
import pe.com.comtecsis.crud.service.auth.impl.AuthenticationWsImpl;
import pe.com.comtecsis.crud.service.exception.WsException;
import pe.com.comtecsis.crud.service.impl.LoginServiceImpl;
import pe.com.comtecsis.crud.service.request.LoginRequest;
import pe.com.comtecsis.crud.service.response.InitResult;
import pe.com.comtecsis.crud.service.response.LoginResult;
import pe.com.comtecsis.crud.service.response.LogoutResult;
import pe.com.comtecsis.crud.service.response.ValidateResult;
import pe.com.comtecsis.crud.webservice.LoginWebService;

/**
 * @author Elvis
 *
 */
@WebService(endpointInterface = "pe.com.comtecsis.crud.webservice.LoginWebService", portName = "LoginWebServicePort", serviceName = "LoginWebService", targetNamespace = "http://loginservices.webservices.comtecsis.com.pe")
@HandlerChain(file = "handlers.xml")
public class LoginWebServiceImpl extends AuthenticationWsImpl implements LoginWebService{
	
	@Resource
	private WebServiceContext context;
	
	@Autowired
	private LoginServiceImpl loginService;

	@Override
	public LoginResult login(LoginRequest request) throws WsException {
		return loginService.login(request, context);
	}

	@Override
	public InitResult init(LoginRequest request) throws WsException {
		return loginService.init(request, context);
	}

	@Override
	public ValidateResult validate() throws WsException {
		return loginService.validate(context);
	}

	@Override
	public LogoutResult logout() throws WsException {
		return loginService.logout(context);
	}
	
	public void setLoginService(LoginServiceImpl loginService) {
		this.loginService = loginService;
	}
}
