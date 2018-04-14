package pe.com.comtecsis.crud.service.exception;

public class WsException extends Exception{

	private static final long serialVersionUID = 3930336657696686519L;

	@SuppressWarnings("unused") 
	// Se devuelve al cliente en caso de error
	private WsExceptionMessage wsExceptionMessage;
	
	public WsException() {
		super();
	}
	
	public WsException(String message, WsExceptionMessage wsExceptionMessage) {
		super(message);
		setWsExceptionMessage(wsExceptionMessage);
	}

	public WsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public WsException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public WsException(String message) {
		super(message);
		
	}

	public WsException(Throwable cause) {
		super(cause);
		
	}
	
	private void setWsExceptionMessage(WsExceptionMessage wsExceptionMessage) {
		this.wsExceptionMessage = wsExceptionMessage;
	}
}
