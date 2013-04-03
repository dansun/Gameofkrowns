package nu.danielsundberg.gameofkrowns.business.service;

import nu.danielsundberg.gameofkrowns.access.domain.GameEntity;
import nu.danielsundberg.gameofkrowns.access.domain.PlayerEntity;
import nu.danielsundberg.gameofkrowns.application.exception.*;
import nu.danielsundberg.gameofkrowns.application.service.GameofKrownsControllServiceV1;
import nu.danielsundberg.gameofkrowns.domain.Game;

import java.util.Set;

public interface GameofKrownsControllServiceWSV1 extends GameofKrownsControllServiceV1 {

	@Override
	public void acceptGame(Long playerId, String password, Long gameId)
            throws PlayerNotFoundException, WrongPasswordException,
            GameNotFoundException, PlayerNotInvitedToGameException, IllegalGameStateException;
	
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
	public void invitePlayer(Long playerId, String password, Long gameId,
			Long playerToInvite) throws PlayerNotFoundException,
			WrongPasswordException, GameNotFoundException;
	
	@Override
	public Game<?,?,?> getGame(Long playerId, String password, Long gameId)
			throws PlayerNotFoundException, WrongPasswordException,
			GameNotFoundException, PlayerNotInvitedToGameException;
	
	@Override
	public PlayerEntity registerPlayer(String playerName, String password)
			throws PlayerAlreadyExistsException;
}
