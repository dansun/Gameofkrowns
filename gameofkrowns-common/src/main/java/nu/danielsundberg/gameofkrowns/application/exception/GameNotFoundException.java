package nu.danielsundberg.gameofkrowns.application.exception;

/**
 * Game not found exception
 */
public class GameNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public GameNotFoundException(String message) {
		super(message);
	}
	
}
