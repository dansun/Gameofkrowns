package nu.danielsundberg.gameofkrowns.application.exception;

import javax.xml.ws.WebFault;

/**
 * PlayerNotInvitedToGame exception and webfault configuration.
 * 
 * @author dansun
 *
 */
@WebFault(name = "IllegalMove", targetNamespace = "urn:nu.danielsundberg.gameofkrowns:exception")
public class IllegalMoveException extends Exception {

	private static final long serialVersionUID = 1L;

	public IllegalMoveException(String message) {
		super(message);
	}
	
}
