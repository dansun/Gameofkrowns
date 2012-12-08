package nu.danielsundberg.gameofkrowns.application.exception;

import javax.xml.ws.WebFault;

/**
 * GameAllreadyExists exception and webfault configuration.
 * 
 * @author dansun
 *
 */
@WebFault(name = "GameAlreadyExists", targetNamespace = "urn:nu.danielsundberg.gameofkrowns:exception")
public class GameAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public GameAlreadyExistsException(String message) {
		super(message);
	}
	
}
