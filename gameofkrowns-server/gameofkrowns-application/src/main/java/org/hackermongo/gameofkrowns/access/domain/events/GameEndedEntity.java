package org.hackermongo.gameofkrowns.access.domain.events;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hackermongo.gameofkrowns.access.domain.Event;
import org.hackermongo.gameofkrowns.access.domain.EventEntity;
import org.hackermongo.gameofkrowns.access.domain.EventType;
import org.hackermongo.gameofkrowns.access.domain.GameEntity;
import org.hackermongo.gameofkrowns.access.domain.PlayerEntity;

/**
 * Event representing end of a game
 */
@Entity
@Table(name = "GAME_FINISHED_EVENT")
public class GameEndedEntity extends EventEntity implements GameEnded<PlayerEntity, GameEntity> {

	private static final long serialVersionUID = 1L;

	@OneToOne
	private PlayerEntity winningPlayer;

	public GameEndedEntity() {
		this.eventType = EventType.GAME_FINISH;
	}
	
	public PlayerEntity getWinningPlayer() {
		return winningPlayer;
	}

	public void setWinningPlayer(PlayerEntity winningPlayer) {
		this.winningPlayer = winningPlayer;
	}

	@Override
	public int compareTo(Event<GameEntity> o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
