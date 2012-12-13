package nu.danielsundberg.gameofkrowns.application.exception;


/**
 * PlayerAllreadyExists exception and webfault configuration.
 * 
 * @author dansun
 *
 */
public class PlayerAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public PlayerAlreadyExistsException(String message) {
		super(message);
	}
	
}
