package pe.com.comtecsis.crud.service.auth.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import pe.com.comtecsis.crud.service.auth.AuthenticationWs;
import pe.com.comtecsis.crud.service.bean.User;
import pe.com.comtecsis.crud.service.enums.ConstantsEnum;
import pe.com.comtecsis.crud.service.exception.WsException;
import pe.com.comtecsis.crud.service.factory.ExceptionWsFactory;

@Service
public class AuthenticationWsImpl implements AuthenticationWs{

	@Resource
	private WebServiceContext context;

	@Autowired
	private ExceptionWsFactory exceptionWsFactory;
	
	public WebServiceContext getContext() {
		return context;
	}

	public void setContext(WebServiceContext context) {
		this.context = context;
	}

	private User user;
	private String token;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void execHandler() throws WsException {
		MessageContext ctx = context.getMessageContext();
		Object objUser = ConstantsEnum.USER.get(ctx, Object.class);
		if (objUser != null && objUser instanceof User) {
			user = (User) objUser;
		}else {
			throw exceptionWsFactory.errorAccessWs();
		}
	}
	
	@PostConstruct
	public void enableAutowiredInjectionForWebServices()
	{
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
}
