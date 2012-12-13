package nu.danielsundberg.gameofkrowns.application.exception;


/**
 * PlayerNotFound exception and webfault configuration.
 * 
 * @author dansun
 *
 */
public class GameNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public GameNotFoundException(String message) {
		super(message);
	}
	
}
