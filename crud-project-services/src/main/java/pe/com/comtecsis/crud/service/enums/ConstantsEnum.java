package pe.com.comtecsis.crud.service.enums;

import java.io.Serializable;

import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

public enum ConstantsEnum {
	
	X_AUTH_TOKEN("X-AUTH-TOKEN"),
	USER("USER");

	String value;
	
	private ConstantsEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getAttribute(HttpSession session, Class<T> clazz) {
		return (T)session.getAttribute(value);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T get(MessageContext context, Class<T> clazz) {
		return (T)context.get(value);
	}
	
	public <T extends Serializable> void setAttribute(HttpSession session, T object) {
		session.setAttribute(value, object);
	}
	
}
