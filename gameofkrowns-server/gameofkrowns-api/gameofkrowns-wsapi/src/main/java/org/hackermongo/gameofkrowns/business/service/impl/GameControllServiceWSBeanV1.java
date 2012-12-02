package org.hackermongo.gameofkrowns.business.service.impl;

import java.math.BigDecimal;
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
import org.hackermongo.gameofkrowns.access.domain.GameEntity;
import org.hackermongo.gameofkrowns.access.domain.PlayerEntity;
import org.hackermongo.gameofkrowns.application.exception.GameAlreadyExistsException;
import org.hackermongo.gameofkrowns.application.exception.GameNotFoundException;
import org.hackermongo.gameofkrowns.application.exception.IllegalMoveException;
import org.hackermongo.gameofkrowns.application.exception.PlayerAlreadyExistsException;
import org.hackermongo.gameofkrowns.application.exception.PlayerNotFoundException;
import org.hackermongo.gameofkrowns.application.exception.PlayerNotInvitedToGameException;
import org.hackermongo.gameofkrowns.application.exception.WrongPasswordException;
import org.hackermongo.gameofkrowns.application.service.GameofKrownsControllServiceV1;
import org.hackermongo.gameofkrowns.business.service.GameofKrownsControllServiceWSV1;

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
public class GameControllServiceWSBeanV1 implements GameofKrownsControllServiceWSV1 {
	
	@EJB(mappedName="gameofkrownsControllServiceBean-v0.0.2")
	private GameofKrownsControllServiceV1 serviceBean;
	
	/**
	 * Define getGamesForPlayer operation.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@WebMethod(operationName="getGamesForPlayer")
	public @WebResult(name="Game", 
						partName="Game", 
						targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:game") Set<GameEntity> 
			getActiveGamesForPlayerWS(
		@WebParam(name="PlayerId", 
			partName = "PlayerId", 
			targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:player") Long playerId, 
		@WebParam(name="PlayerPassword", 
			partName = "PlayerPassword", 
					targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:player") String password) 
	throws 
		PlayerNotFoundException, 
		WrongPasswordException {
		return (Set)serviceBean.getActiveGamesForPlayer(playerId, password);
	}
	
	/**
	 * Define registerPlayer operation.
	 */
	@WebMethod(operationName="registerPlayer")
	public @WebResult(name="Player", 
			partName="Player", 
			targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:player") PlayerEntity
			registerPlayer(
		@WebParam(name="PlayerName", 
			partName = "PlayerName", 
			targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:player") String playerName, 
		@WebParam(name="PlayerPassword", 
			partName = "PlayerPassword", 
			targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:player") String password) 
	throws 
		PlayerAlreadyExistsException {
		return (PlayerEntity) serviceBean.registerPlayer(playerName, password);
	}
	
	/**
	 * Define createGame operation.
	 */
	@WebMethod(operationName="createGame")
	public @WebResult(name="Game", 
			partName="Game", 
			targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:game") GameEntity
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
		return (GameEntity) serviceBean.createGame(playerId, password, gameName);
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

	@Override
	@WebMethod(exclude = true)
	public Set<Game<?, ?, ?>> getActiveGamesForPlayer(Long playerId,
			String password) throws PlayerNotFoundException,
			WrongPasswordException {
		throw new PlayerNotFoundException("Method incompatible with WS Implementation, use getActiveGamesForPlayerWS.");
	}

	
	@WebMethod(operationName="reportBribeMove")
	public void reportBribeMove(
		@WebParam(name="PlayerId", 
			partName = "PlayerId", 
			targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:player") Long playerId, 
		@WebParam(name="PlayerPassword", 
			partName = "PlayerPassword", 
			targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:player") String password, 
		@WebParam(name="GameId", 
			partName = "GameId", 
			targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:game") Long gameId,
		@WebParam(name="CountyName", 
			partName = "CaountyName", 
			targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:county") String countyName, 
		@WebParam(name="Amount", 
			partName = "Amount", 
			targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:move") BigDecimal amount)
	throws 
			PlayerNotFoundException, 
			WrongPasswordException,
			GameNotFoundException, 
			PlayerNotInvitedToGameException,
			IllegalMoveException {
		serviceBean.reportBribeMove(playerId, password, gameId, countyName, amount);
	}

	@WebMethod(operationName="reportPropagandaMove")
	public void reportPropagandaMove(
		@WebParam(name="PlayerId", 
			partName = "PlayerId", 
			targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:player") Long playerId, 
		@WebParam(name="PlayerPassword", 
			partName = "PlayerPassword", 
			targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:player") String password, 
		@WebParam(name="GameId", 
			partName = "GameId", 
			targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:game") Long gameId,
		@WebParam(name="CountyName", 
			partName = "CaountyName", 
			targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:county") String countyName, 
		@WebParam(name="Amount", 
			partName = "Amount", 
			targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:move") BigDecimal amount)
	throws 
			PlayerNotFoundException, 
			WrongPasswordException,
			GameNotFoundException, 
			PlayerNotInvitedToGameException,
			IllegalMoveException {
		serviceBean.reportBribeMove(playerId, password, gameId, countyName, amount);
	}

	@WebMethod(operationName="getGame")
	public GameEntity getGame(
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
		return (GameEntity) serviceBean.getGame(playerId, password, gameId);
	}

	@WebMethod(operationName="getPlayer")
	public PlayerEntity getPlayer(
		@WebParam(name="PlayerName", 
			partName = "PlayerName", 
			targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:player") String playerName, 
		@WebParam(name="PlayerPassword", 
			partName = "PlayerPassword", 
			targetNamespace="urn:org.hackermongo.gameofkrowns:gamecontrollservice:player") String password)
	throws 
			PlayerNotFoundException, 
			WrongPasswordException {
		return (PlayerEntity) serviceBean.getPlayer(playerName, password);
	}

	
}
