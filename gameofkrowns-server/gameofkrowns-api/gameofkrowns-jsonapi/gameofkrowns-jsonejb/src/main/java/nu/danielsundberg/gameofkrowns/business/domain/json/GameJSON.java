package nu.danielsundberg.gameofkrowns.business.domain.json;

import nu.danielsundberg.gameofkrowns.access.domain.GameEntity;
import nu.danielsundberg.gameofkrowns.access.domain.MoveEntity;
import nu.danielsundberg.gameofkrowns.access.domain.PlayerEntity;
import nu.danielsundberg.gameofkrowns.access.domain.events.GameEndedEntity;
import nu.danielsundberg.gameofkrowns.access.domain.events.GameStartedEntity;
import nu.danielsundberg.gameofkrowns.access.domain.events.GameTurnEntity;
import nu.danielsundberg.gameofkrowns.access.domain.events.PlayerFundingEntity;
import nu.danielsundberg.gameofkrowns.access.domain.game.CountyEntity;
import nu.danielsundberg.gameofkrowns.access.domain.moves.BribeEntity;
import nu.danielsundberg.gameofkrowns.access.domain.moves.PropagandaEntity;
import nu.danielsundberg.gameofkrowns.domain.Event;
import nu.danielsundberg.gameofkrowns.domain.Game;
import nu.danielsundberg.gameofkrowns.domain.GameState;
import nu.danielsundberg.gameofkrowns.domain.Player;
import nu.danielsundberg.gameofkrowns.domain.events.GameTurn;
import nu.danielsundberg.gameofkrowns.domain.game.County;
import org.codehaus.jackson.annotate.JsonWriteNullProperties;

import java.util.*;


@JsonWriteNullProperties(true)
public class GameJSON implements Game {

    private GameEntity gameEntity;

    public GameJSON(GameEntity gameEntity) {
        this.gameEntity = gameEntity;
    }

    @Override
    public Long getGameId() {
        return gameEntity.getGameId();
    }

    @Override
    public String getGameName() {
        return gameEntity.getGameName();
    }

    @Override
    public GameState getGameState() {
        return gameEntity.getGameState();
    }

    @Override
    public Date getRegistrationTime() {
        return gameEntity.getRegistrationTime();
    }

    @Override
    public Player getOwningPlayer() {
        return new PlayerJSON((PlayerEntity)gameEntity.getOwningPlayer());
    }

    @Override
    public Set<Player> getInvitedPlayers() {
        Set<Player> invitedPlayers = new HashSet<Player>();
        for(Player playerEntity : gameEntity.getInvitedPlayers()) {
            invitedPlayers.add(new PlayerJSON((PlayerEntity)playerEntity));
        }
        return invitedPlayers;
    }

    @Override
    public Set<Player> getPlayers() {
        Set<Player> playingPlayers = new HashSet<Player>();
        for(Player playerEntity : gameEntity.getPlayers()) {
            playingPlayers.add(new PlayerJSON((PlayerEntity) playerEntity));
        }
        return playingPlayers;
    }

    @Override
    public SortedSet<Event> getEvents() {
        SortedSet<Event> gameEvents = new TreeSet<Event>();
        for(Event eventEntity : gameEntity.getEvents()) {
            switch(eventEntity.getEventType()) {
                case PLAYER_FUNDING:
                    gameEvents.add(new PlayerFundingJSON((PlayerFundingEntity) eventEntity));
                    break;
                case GAME_MOVE:
                    switch(((MoveEntity)eventEntity).getMoveType()) {
                        case PROPAGANDA:
                            gameEvents.add(new PropagandaJSON((PropagandaEntity) eventEntity));
                            break;
                        case BRIBE:
                            gameEvents.add(new BribeJSON((BribeEntity) eventEntity));
                            break;
                    }
                    break;
                case GAME_FINISH:
                    gameEvents.add(new GameEndedJSON((GameEndedEntity) eventEntity));
                    break;
                case GAME_START:
                    gameEvents.add(new GameStartedJSON((GameStartedEntity) eventEntity));
                    break;
                case GAME_TURN:
                    gameEvents.add(new GameTurnJSON((GameTurnEntity) eventEntity));
                    break;
            }
        }
        return gameEvents;
    }

    @Override
    public Set<County> getCounties() {
        Set<County> counties = new HashSet<County>();
        for(County countyEntity : gameEntity.getCounties()) {
            counties.add(new CountyJSON((CountyEntity)countyEntity));
        }
        return counties;
    }

    @Override
    public GameTurn getCurrentGameTurn() {
        return gameEntity.getCurrentGameTurn()!=null?
                new GameTurnJSON((GameTurnEntity)gameEntity.getCurrentGameTurn()) :
                null;
    }

}

