package nu.danielsundberg.gameofkrowns.application.exception;

import javax.xml.ws.WebFault;

/**
 * PlayerAllreadyExists exception and webfault configuration.
 * 
 * @author dansun
 *
 */
@WebFault(name = "PlayerAlreadyExists", targetNamespace = "urn:nu.danielsundberg.goodstuff:exception")
public class PlayerAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public PlayerAlreadyExistsException(String message) {
		super(message);
	}
	
}
