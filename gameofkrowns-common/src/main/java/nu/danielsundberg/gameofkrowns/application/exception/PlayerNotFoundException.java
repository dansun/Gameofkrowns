package nu.danielsundberg.gameofkrowns.application.exception;


/**
 * PlayerNotFound exception and webfault configuration.
 * 
 * @author dansun
 *
 */
public class PlayerNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public PlayerNotFoundException(String message) {
		super(message);
	}
	
}
