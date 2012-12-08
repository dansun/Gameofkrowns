package nu.danielsundberg.droid.gameofkrowns.game.model;

import java.io.Serializable;

import nu.danielsundberg.gameofkrowns.access.domain.EventType;
import nu.danielsundberg.gameofkrowns.access.domain.Move;
import nu.danielsundberg.gameofkrowns.access.domain.MoveType;

/**
 * A game of krowns move
 * 
 * @author dansun
 *
 */

public abstract class MoveImpl extends EventImpl implements Move<PlayerImpl, GameImpl>, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private PlayerImpl player;
	
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

}
