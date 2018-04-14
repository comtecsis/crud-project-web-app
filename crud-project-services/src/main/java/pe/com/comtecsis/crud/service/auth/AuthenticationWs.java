package pe.com.comtecsis.crud.service.auth;

import pe.com.comtecsis.crud.service.bean.User;
import pe.com.comtecsis.crud.service.exception.WsException;

public interface AuthenticationWs {
	
	User getUser();

	void setUser(User user);

	String getToken();

	void setToken(String token);

	void execHandler() throws WsException;
}
