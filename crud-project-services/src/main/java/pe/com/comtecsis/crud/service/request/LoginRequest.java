package pe.com.comtecsis.crud.service.request;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlTransient;

public class LoginRequest implements Serializable{
	
	private static final long serialVersionUID = 1523661365956622990L;
	
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@XmlTransient
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
