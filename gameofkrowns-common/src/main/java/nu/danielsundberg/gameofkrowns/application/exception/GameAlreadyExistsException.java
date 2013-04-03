package nu.danielsundberg.gameofkrowns.application.exception;

/**
 * Game already exists exception
 */
public class GameAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public GameAlreadyExistsException(String message) {
		super(message);
	}
	
}
