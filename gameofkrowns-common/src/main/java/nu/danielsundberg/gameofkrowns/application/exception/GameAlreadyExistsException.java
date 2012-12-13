package nu.danielsundberg.gameofkrowns.application.exception;


/**
 * GameAllreadyExists exception and webfault configuration.
 * 
 * @author dansun
 *
 */
public class GameAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public GameAlreadyExistsException(String message) {
		super(message);
	}
	
}
