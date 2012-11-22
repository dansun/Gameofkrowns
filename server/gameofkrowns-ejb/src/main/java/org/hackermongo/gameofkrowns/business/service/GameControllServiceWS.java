package org.hackermongo.gameofkrowns.business.service;

import java.util.Set;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;

import org.hackermongo.gameofkrowns.access.domain.Game;
import org.hackermongo.gameofkrowns.access.domain.Player;
import org.hackermongo.gameofkrowns.application.exception.GameAllreadyExistsException;
import org.hackermongo.gameofkrowns.application.exception.PlayerAllreadyExistsException;
import org.hackermongo.gameofkrowns.application.exception.PlayerNotFoundException;
import org.hackermongo.gameofkrowns.application.exception.WrongPasswordException;
import org.hackermongo.gameofkrowns.application.service.impl.GameofKrownsControllServiceBean;

/**
 * GameControllerService Webservice wrapper
 * 
 * @author dansun
 *
 */
@Stateless
@WebService(name="GameControllService", 
	targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice")
@SOAPBinding(style = javax.jws.soap.SOAPBinding.Style.DOCUMENT)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class GameControllServiceWS extends GameofKrownsControllServiceBean {
	
	/**
	 * Excluded from webservice.
	 */
	@Override
	@WebMethod(exclude=true)
	public void setEntityManager(EntityManager entityManager) {
		super.setEntityManager(entityManager);
	}

	/**
	 * Define getGamesForPlayer operation.
	 */
	@Override
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
					targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:player") String password) throws PlayerNotFoundException, WrongPasswordException {
		return super.getActiveGamesForPlayer(playerId, password);
	}
	
	/**
	 * Define registerPlayer operation.
	 */
	@Override
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
					targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:player") String password) throws PlayerAllreadyExistsException {
		return super.registerPlayer(playerName, password);
	}
	
	/**
	 * Define createGame operation.
	 */
	@Override
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
					targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:game") String gameName) throws GameAllreadyExistsException, PlayerNotFoundException, WrongPasswordException {
		return super.createGame(playerId, password, gameName);
	}
	
	/**
	 * Define acceptGame operation.
	 */
	@Override
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
					targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:game") Long gameId) {
		super.acceptGame(playerId, password, gameId);
	}
	
	/**
	 * Define invitePlayers operation.
	 */
	@Override
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
			targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:player") Set<Player> playersToInvite) {
		super.invitePlayers(playerId, password, gameId, playersToInvite);
	}
	
}
