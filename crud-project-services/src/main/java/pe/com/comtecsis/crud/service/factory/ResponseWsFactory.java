package pe.com.comtecsis.crud.service.factory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import pe.com.comtecsis.crud.service.base.ResponseWs;

@Service
public class ResponseWsFactory {
	
	@Value("codeSuccess")
	private String codeSuccess;

	@Value("messageSuccess")
	private String messageSuccess;
	
	public <T extends ResponseWs> void success(T response) {
		response.setCode(codeSuccess);
		response.setMessage(messageSuccess);
	}
	
	public boolean isValidResponse(String code) { 
		return codeSuccess.equals(code);
	}
	
}
