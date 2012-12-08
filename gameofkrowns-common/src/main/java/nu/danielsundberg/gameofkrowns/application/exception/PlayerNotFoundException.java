package nu.danielsundberg.gameofkrowns.application.exception;

import javax.xml.ws.WebFault;

/**
 * PlayerNotFound exception and webfault configuration.
 * 
 * @author dansun
 *
 */
@WebFault(name = "PlayerNotFound", targetNamespace = "urn:nu.danielsundberg.goodstuff:exception")
public class PlayerNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public PlayerNotFoundException(String message) {
		super(message);
	}
	
}
