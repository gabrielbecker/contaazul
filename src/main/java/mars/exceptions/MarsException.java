package mars.exceptions;

/**
 * Exceção base do software. Toda exceção do softaware deve extender-la. 
 * @author gabriel
 *
 */
public class MarsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MarsException(String message) {
		super(message);
	}
	
	public MarsException(Throwable cause) {
		super(cause);
	}
	
	public MarsException(String message, Throwable cause) {
		super(message, cause);
	}

}
