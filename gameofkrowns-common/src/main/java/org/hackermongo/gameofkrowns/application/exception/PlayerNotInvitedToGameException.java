package org.hackermongo.gameofkrowns.application.exception;

import javax.xml.ws.WebFault;

/**
 * PlayerNotInvitedToGame exception and webfault configuration.
 * 
 * @author dansun
 *
 */
@WebFault(name = "PlayerNotInvited", targetNamespace = "urn:org.hackermongo.gameofkrowns:exception")
public class PlayerNotInvitedToGameException extends Exception {

	private static final long serialVersionUID = 1L;

	public PlayerNotInvitedToGameException(String message) {
		super(message);
	}
	
}
