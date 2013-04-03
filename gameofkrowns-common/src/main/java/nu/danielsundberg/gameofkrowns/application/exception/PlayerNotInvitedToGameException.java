package nu.danielsundberg.gameofkrowns.application.exception;

/**
 * Player not invited to game exception.
 */
public class PlayerNotInvitedToGameException extends Exception {

	private static final long serialVersionUID = 1L;

	public PlayerNotInvitedToGameException(String message) {
		super(message);
	}
	
}
