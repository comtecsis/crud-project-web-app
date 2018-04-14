package pe.com.comtecsis.crud.security.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class CrudUserToken extends UsernamePasswordAuthenticationToken{

	private static final Logger logger = LoggerFactory.getLogger(CrudUserToken.class);
	
	private static final long serialVersionUID = 1L;
	
	public CrudUserToken(Object principal, Object credentials) {
		super(principal, credentials);
		logger.debug("Se realiza creacion de login.");
	}

}
