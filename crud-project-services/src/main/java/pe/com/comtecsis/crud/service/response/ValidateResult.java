package pe.com.comtecsis.crud.service.response;

import java.io.Serializable;

import pe.com.comtecsis.crud.service.base.ResponseWs;
import pe.com.comtecsis.crud.service.bean.User;

public class ValidateResult implements ResponseWs, Serializable {

	private static final long serialVersionUID = -5883620695416424264L;

	private String code;
	private String message;

	private User user;

	@Override
	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String getCode() {
		return this.code;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
