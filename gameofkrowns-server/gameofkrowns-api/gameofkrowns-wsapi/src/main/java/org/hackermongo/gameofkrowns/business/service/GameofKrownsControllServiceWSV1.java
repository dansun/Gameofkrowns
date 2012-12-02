package org.hackermongo.gameofkrowns.business.service;

import java.util.Set;

import org.hackermongo.gameofkrowns.access.domain.Game;
import org.hackermongo.gameofkrowns.access.domain.GameEntity;
import org.hackermongo.gameofkrowns.access.domain.PlayerEntity;
import org.hackermongo.gameofkrowns.application.exception.GameAlreadyExistsException;
import org.hackermongo.gameofkrowns.application.exception.GameNotFoundException;
import org.hackermongo.gameofkrowns.application.exception.PlayerAlreadyExistsException;
import org.hackermongo.gameofkrowns.application.exception.PlayerNotFoundException;
import org.hackermongo.gameofkrowns.application.exception.PlayerNotInvitedToGameException;
import org.hackermongo.gameofkrowns.application.exception.WrongPasswordException;
import org.hackermongo.gameofkrowns.application.service.GameofKrownsControllServiceV1;

public interface GameofKrownsControllServiceWSV1 extends GameofKrownsControllServiceV1 {

	@Override
	public void acceptGame(Long playerId, String password, Long gameId)
			throws PlayerNotFoundException, WrongPasswordException,
			GameNotFoundException, PlayerNotInvitedToGameException;
	
	@Override
	public GameEntity createGame(Long playerId, String password,
			String gameName) throws GameAlreadyExistsException,
			PlayerNotFoundException, WrongPasswordException;
	
	@Override
	public Set<Game<?, ?, ?>> getActiveGamesForPlayer(Long playerId,
			String password) throws PlayerNotFoundException,
			WrongPasswordException;
	
	public Set<GameEntity> getActiveGamesForPlayerWS(Long playerId,
			String password) throws PlayerNotFoundException,
			WrongPasswordException;
	
	@Override
	public void invitePlayers(Long playerId, String password, Long gameId,
			Set<Long> playersToInvite) throws PlayerNotFoundException,
			WrongPasswordException, GameNotFoundException;
	
	@Override
	public Game<?,?,?> getGame(Long playerId, String password, Long gameId)
			throws PlayerNotFoundException, WrongPasswordException,
			GameNotFoundException, PlayerNotInvitedToGameException;
	
	@Override
	public PlayerEntity registerPlayer(String playerName, String password)
			throws PlayerAlreadyExistsException;
}
