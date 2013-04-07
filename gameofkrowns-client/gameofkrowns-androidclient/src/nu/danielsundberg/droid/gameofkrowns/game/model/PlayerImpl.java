package nu.danielsundberg.droid.gameofkrowns.game.model;

import nu.danielsundberg.gameofkrowns.domain.Player;

import java.io.Serializable;
import java.util.Set;

/**
 * A Game of Krowns Player representation
 */
public class PlayerImpl implements Player, Serializable {

	private static final long serialVersionUID = 1L;

    private Long playerId;
    private String playerName;
    private String password;

    private Set<Long> invitedGameIds;
    private Set<Long> ownedGameIds;
    private Set<Long> playingGameIds;


    @Override
    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    @Override
    public long getPlayerId() {
        return this.playerId;
    }

    @Override
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public String getPlayerName() {
        return this.playerName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Set<Long> getInvitedGameIds() {
        return this.invitedGameIds;
    }

    @Override
    public Set<Long> getOwnedGameIds() {
        return this.ownedGameIds;
    }

    @Override
    public Set<Long> getPlayingGameIds() {
        return this.playingGameIds;
    }

}
