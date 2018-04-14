package pe.com.comtecsis.crud.service.bean;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = 3157551935831074938L;
	
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
