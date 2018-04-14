package pe.com.comtecsis.crud.service.factory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import pe.com.comtecsis.crud.service.exception.WsException;
import pe.com.comtecsis.crud.service.exception.WsExceptionMessage;

@Service
public class ExceptionWsFactory {
	
	@Value("wsErrorMessage")
	private String wsErrorMessage;
	
	@Value("wsErrorCode")
	private String wsErrorCode;

	@Value("wsAccessDeniedMessage")
	private String wsAccessDeniedMessage;
	
	@Value("wsAccessDeniedCode")
	private String wsAccessDeniedCode;
	
	@Value("wsResponseErrorMessage")
	private String wsResponseErrorMessage;
	
	public WsException errorWs(Exception e) {
		return new WsException(e.getMessage(), new WsExceptionMessage(wsErrorCode, wsErrorMessage));
	}
	
	public WsException errorResponse(String code, String message) {
		return new WsException(wsResponseErrorMessage, new WsExceptionMessage(code, message));
	}
	
	public WsException errorAccessWs() {
		return new WsException(wsAccessDeniedMessage, new WsExceptionMessage(wsAccessDeniedCode, wsAccessDeniedMessage));
	}
	
}
