package nu.danielsundberg.gameofkrowns.application.exception;

import javax.xml.ws.WebFault;

/**
 * PlayerNotFound exception and webfault configuration.
 * 
 * @author dansun
 *
 */
@WebFault(name = "PlayerNotFound", targetNamespace = "urn:nu.danielsundberg.gameofkrowns:exception")
public class GameNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public GameNotFoundException(String message) {
		super(message);
	}
	
}
