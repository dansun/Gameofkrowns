package org.hackermongo.gameofkrowns.business.service;

import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.hackermongo.gameofkrowns.access.domain.Game;
import org.hackermongo.gameofkrowns.access.domain.Player;
import org.hackermongo.gameofkrowns.application.exception.GameAlreadyExistsException;
import org.hackermongo.gameofkrowns.application.exception.GameNotFoundException;
import org.hackermongo.gameofkrowns.application.exception.PlayerAlreadyExistsException;
import org.hackermongo.gameofkrowns.application.exception.PlayerNotFoundException;
import org.hackermongo.gameofkrowns.application.exception.PlayerNotInvitedToGameException;
import org.hackermongo.gameofkrowns.application.exception.WrongPasswordException;
import org.hackermongo.gameofkrowns.application.service.GameofKrownsControllServiceV1;

/**
 * GameControllerService Webservice wrapper
 * 
 * @author dansun
 *
 */
@Stateless(mappedName="gameofkrownsControllServiceWS-v0.0.2")
@WebService(name="GameControllService", 
	targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice")
@SOAPBinding(style = javax.jws.soap.SOAPBinding.Style.DOCUMENT)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class GameControllServiceWSV1 implements GameofKrownsControllServiceV1 {
	
	@EJB(mappedName="gameofkrownsControllServiceBean-v0.0.2")
	private GameofKrownsControllServiceV1 serviceBean;
	
	/**
	 * Define getGamesForPlayer operation.
	 */
	@WebMethod(operationName="getGamesForPlayer")
	public @WebResult(name="Game", 
						partName="Game", 
						targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:game") Set<Game> 
			getActiveGamesForPlayer(
		@WebParam(name="PlayerId", 
			partName = "PlayerId", 
			targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:player") Long playerId, 
		@WebParam(name="PlayerPassword", 
			partName = "PlayerPassword", 
					targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:player") String password) 
	throws 
		PlayerNotFoundException, 
		WrongPasswordException {
		return serviceBean.getActiveGamesForPlayer(playerId, password);
	}
	
	/**
	 * Define registerPlayer operation.
	 */
	@WebMethod(operationName="registerPlayer")
	public @WebResult(name="Player", 
			partName="Player", 
			targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:player") Player 
			registerPlayer(
		@WebParam(name="PlayerName", 
			partName = "PlayerName", 
			targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:player") String playerName, 
		@WebParam(name="PlayerPassword", 
			partName = "PlayerPassword", 
			targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:player") String password) 
	throws 
		PlayerAlreadyExistsException {
		return serviceBean.registerPlayer(playerName, password);
	}
	
	/**
	 * Define createGame operation.
	 */
	@WebMethod(operationName="createGame")
	public @WebResult(name="Game", 
			partName="Game", 
			targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:game") Game 
			createGame(
		@WebParam(name="PlayerId", 
			partName = "PlayerId", 
			targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:player") Long playerId, 
		@WebParam(name="PlayerPassword", 
			partName = "PlayerPassword", 
			targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:player") String password, 
		@WebParam(name="GameName", 
			partName = "GameName", 
			targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:game") String gameName) 
	throws 
		GameAlreadyExistsException, 
		PlayerNotFoundException, 
		WrongPasswordException {
		return serviceBean.createGame(playerId, password, gameName);
	}
	
	/**
	 * Define acceptGame operation.
	 * @throws PlayerNotInvitedToGameException 
	 * @throws GameNotFoundException 
	 * @throws WrongPasswordException 
	 * @throws PlayerNotFoundException 
	 */
	@WebMethod(operationName="acceptGame")
	public void acceptGame(
		@WebParam(name="PlayerId", 
			partName = "PlayerId", 
			targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:player") Long playerId, 
		@WebParam(name="PlayerPassword", 
			partName = "PlayerPassword", 
			targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:player") String password, 
		@WebParam(name="GameId", 
			partName = "GameId", 
			targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:game") Long gameId) 
	throws 
		PlayerNotFoundException, 
		WrongPasswordException, 
		GameNotFoundException, 
		PlayerNotInvitedToGameException {
		serviceBean.acceptGame(playerId, password, gameId);
	}
	
	/**
	 * Define invitePlayers operation.
	 * @throws GameNotFoundException 
	 * @throws WrongPasswordException 
	 * @throws PlayerNotFoundException 
	 */
	@WebMethod(operationName="invitePlayers")
	public void invitePlayers(@WebParam(name="PlayerId", 
			partName = "PlayerId", 
			targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:player") Long playerId, 
		@WebParam(name="PlayerPassword", 
			partName = "PlayerPassword", 
			targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:player") String password, 
		@WebParam(name="GameId", 
			partName = "GameId", 
			targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:game") Long gameId,	
		@WebParam(name="Player", 
			partName="Player", 
			targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:player") Set<Long> playerIdsToInvite) 
	throws 
		PlayerNotFoundException, WrongPasswordException, GameNotFoundException {
		serviceBean.invitePlayers(playerId, password, gameId, playerIdsToInvite);
	}
	
}
