package nu.danielsundberg.gameofkrowns.application.exception;

/**
 * Player not found exception
 */
public class PlayerNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public PlayerNotFoundException(String message) {
		super(message);
	}
	
}
