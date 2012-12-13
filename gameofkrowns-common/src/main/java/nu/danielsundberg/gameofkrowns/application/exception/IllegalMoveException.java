package nu.danielsundberg.gameofkrowns.application.exception;


/**
 * PlayerNotInvitedToGame exception and webfault configuration.
 * 
 * @author dansun
 *
 */
public class IllegalMoveException extends Exception {

	private static final long serialVersionUID = 1L;

	public IllegalMoveException(String message) {
		super(message);
	}
	
}
