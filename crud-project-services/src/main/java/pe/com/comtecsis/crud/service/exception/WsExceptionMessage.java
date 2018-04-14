package pe.com.comtecsis.crud.service.exception;

public class WsExceptionMessage extends WsException {

	private static final long serialVersionUID = -7558763132293902453L;

	private String code;

	public WsExceptionMessage() {
		super();

	}

	public WsExceptionMessage(String message, String code) {
		super(message);
		setCode(code);
	}

	public WsExceptionMessage(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public WsExceptionMessage(String message, Throwable cause) {
		super(message, cause);

	}

	public WsExceptionMessage(String message) {
		super(message);

	}

	public WsExceptionMessage(Throwable cause) {
		super(cause);

	}

	private void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

}
