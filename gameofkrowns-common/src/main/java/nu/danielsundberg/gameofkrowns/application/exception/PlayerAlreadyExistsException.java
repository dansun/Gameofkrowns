package nu.danielsundberg.gameofkrowns.application.exception;

/**
 * Player already exists exception
 */
public class PlayerAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public PlayerAlreadyExistsException(String message) {
		super(message);
	}
	
}
