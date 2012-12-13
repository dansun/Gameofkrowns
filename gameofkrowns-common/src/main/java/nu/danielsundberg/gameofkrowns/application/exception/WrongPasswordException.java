package nu.danielsundberg.gameofkrowns.application.exception;


/**
 * WrongPassword exception and webfault configuration.
 * 
 * @author dansun
 *
 */
public class WrongPasswordException extends Exception {

	private static final long serialVersionUID = 1L;

	public WrongPasswordException(String message) {
		super(message);
	}
	
}
