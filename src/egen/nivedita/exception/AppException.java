package egen.nivedita.exception;

public class AppException extends Exception{
	
	private static final long serialVersionUID = 2824688318621632069L;

	public AppException (String msg) {
		super(msg);
	}

	public AppException(String msg, Throwable cause) {	
		super(msg,cause);
	}
}
