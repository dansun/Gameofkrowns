package nu.danielsundberg.gameofkrowns.business.service.impl;

import nu.danielsundberg.gameofkrowns.access.domain.GameEntity;
import nu.danielsundberg.gameofkrowns.access.domain.PlayerEntity;
import nu.danielsundberg.gameofkrowns.application.exception.*;
import nu.danielsundberg.gameofkrowns.application.service.impl.GameofKrownsControllServiceBeanV1;
import nu.danielsundberg.gameofkrowns.business.domain.json.GameJSON;
import nu.danielsundberg.gameofkrowns.business.domain.json.PlayerJSON;
import nu.danielsundberg.gameofkrowns.business.service.GameofKrownsControllServiceJSONV1;
import nu.danielsundberg.gameofkrowns.domain.Game;
import nu.danielsundberg.gameofkrowns.domain.Player;

import javax.ejb.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Game of Krowns game controller REST service V1
 */
@Stateless(mappedName="gameofkrownsControllServiceJSONBeanV1")
@TransactionManagement(value= TransactionManagementType.CONTAINER)
@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
public class GameofKrownsControllServiceJSONBeanV1
        extends GameofKrownsControllServiceBeanV1
        implements GameofKrownsControllServiceJSONV1 {

	private static final long serialVersionUID = 1L;

    @Override
    public Player registerPlayer(String playerName, String password)
            throws PlayerAlreadyExistsException {
        return new PlayerJSON((PlayerEntity) super.registerPlayer(playerName, password));
    }

    @Override
    public Player getPlayer(String playerName, String password)
            throws PlayerNotFoundException, WrongPasswordException {
        return new PlayerJSON((PlayerEntity) super.getPlayer(playerName, password));
    }

    @Override
    public Game createGame(Long playerId, String password, String gameName)
            throws GameAlreadyExistsException, PlayerNotFoundException, WrongPasswordException {
        return new GameJSON((GameEntity) super.createGame(playerId, password, gameName));
    }

    @Override
    public Game getGame(Long playerId, String password, Long gameId)
            throws PlayerNotFoundException, WrongPasswordException, GameNotFoundException, PlayerNotInvitedToGameException {
        return new GameJSON((GameEntity) super.getGame(playerId, password, gameId));
    }

    @Override
    public Set<Game> getActiveGamesForPlayer(Long playerId, String password)
            throws PlayerNotFoundException, WrongPasswordException {
        Set<Game> jsonGames = new HashSet<Game>();
        for(Game game : super.getActiveGamesForPlayer(playerId, password)) {
            jsonGames.add(new GameJSON((GameEntity)game));
        }
        return jsonGames;
    }

}