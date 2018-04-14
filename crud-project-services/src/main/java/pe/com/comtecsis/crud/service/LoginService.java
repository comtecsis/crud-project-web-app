package pe.com.comtecsis.crud.service;

import javax.xml.ws.WebServiceContext;
import pe.com.comtecsis.crud.service.exception.WsException;
import pe.com.comtecsis.crud.service.request.LoginRequest;
import pe.com.comtecsis.crud.service.response.InitResult;
import pe.com.comtecsis.crud.service.response.LoginResult;
import pe.com.comtecsis.crud.service.response.LogoutResult;
import pe.com.comtecsis.crud.service.response.ValidateResult;

public interface LoginService {
	public LoginResult login(LoginRequest request, WebServiceContext webServiceContext) throws WsException;

	public InitResult init(LoginRequest request, WebServiceContext webServiceContext) throws WsException;

	public LogoutResult logout(WebServiceContext webServiceContext) throws WsException;

	public ValidateResult validate(WebServiceContext webServiceContext) throws WsException;
}
