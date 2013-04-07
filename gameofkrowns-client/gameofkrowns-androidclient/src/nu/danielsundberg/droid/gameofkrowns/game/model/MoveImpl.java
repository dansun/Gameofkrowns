package nu.danielsundberg.droid.gameofkrowns.game.model;

import nu.danielsundberg.droid.gameofkrowns.game.model.events.GameTurnImpl;
import nu.danielsundberg.gameofkrowns.domain.Event;
import nu.danielsundberg.gameofkrowns.domain.EventType;
import nu.danielsundberg.gameofkrowns.domain.Move;
import nu.danielsundberg.gameofkrowns.domain.MoveType;

import java.io.Serializable;

/**
 * A Game of Krowns abstract move representation
 */

public abstract class MoveImpl extends EventImpl implements Move, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private PlayerImpl player;

    private GameImpl game;

    private GameTurnImpl gameTurn;
	
	private MoveType moveType;
	
	public PlayerImpl getPlayer() {
		return player;
	}

	public void setPlayer(PlayerImpl player) {
		this.player = player;
	}
	
	public MoveType getMoveType() {
		return moveType;
	}
	
	public final EventType getEventType() {
		return EventType.GAME_MOVE;
	}

    @Override
    public Long getPlayerId() {
        return this.player.getPlayerId();
    }

    @Override
    public Long getGameTurnId() {
        return this.gameTurn.getEventId();
    }

    @Override
    public Long getGameId() {
        return this.game.getGameId();
    }

    @Override
    public int compareTo(Event o) {
        //TODO compare
        return -1;
    }

}
