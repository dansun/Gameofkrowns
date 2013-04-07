package nu.danielsundberg.droid.gameofkrowns.game.model;

import nu.danielsundberg.gameofkrowns.domain.Game;
import nu.danielsundberg.gameofkrowns.domain.GameState;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.SortedSet;

/**
 * A Game of Krowns representation
 */
public class GameImpl implements Game, Serializable {

	private static final long serialVersionUID = 1L;

    private Long gameId;
    private String gameName;
    private GameState gameState;
    private Date registrationDate;
    private Long owningPlayerId;
    private Set<Long> invitedPlayerIds;
    private Set<Long> playingPlayerIds;
    private SortedSet<Long> eventIds;
    private Set<Long> countyIds;
    private Long currentGameTurnId;

    public GameImpl(){

    }

    @Override
    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    @Override
    public Long getGameId() {
        return this.gameId;
    }

    @Override
    public String getGameName() {
        return this.gameName;
    }

    @Override
    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    @Override
    public GameState getGameState() {
        return this.gameState;
    }

    @Override
    public Date getRegistrationTime() {
        return this.registrationDate;
    }

    @Override
    public Long getOwningPlayerId() {
        return this.owningPlayerId;
    }

    @Override
    public Set<Long> getInvitedPlayerIds() {
        return this.invitedPlayerIds;
    }

    @Override
    public Set<Long> getPlayerIds() {
        return this.playingPlayerIds;
    }

    @Override
    public SortedSet<Long> getEventIds() {
        return this.eventIds;
    }

    @Override
    public Set<Long> getCountyIds() {
        return this.countyIds;
    }

    @Override
    public Long getCurrentGameTurnId() {
        return this.currentGameTurnId;
    }

}
