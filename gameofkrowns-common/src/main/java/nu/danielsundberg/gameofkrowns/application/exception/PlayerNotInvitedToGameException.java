package nu.danielsundberg.gameofkrowns.application.exception;


/**
 * PlayerNotInvitedToGame exception and webfault configuration.
 * 
 * @author dansun
 *
 */
public class PlayerNotInvitedToGameException extends Exception {

	private static final long serialVersionUID = 1L;

	public PlayerNotInvitedToGameException(String message) {
		super(message);
	}
	
}
