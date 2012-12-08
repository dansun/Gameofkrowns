package nu.danielsundberg.gameofkrowns.access.domain.events;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import nu.danielsundberg.gameofkrowns.access.domain.EventEntity;
import nu.danielsundberg.gameofkrowns.access.domain.GameEntity;
import nu.danielsundberg.gameofkrowns.access.domain.PlayerEntity;
import nu.danielsundberg.gameofkrowns.domain.Event;
import nu.danielsundberg.gameofkrowns.domain.EventType;
import nu.danielsundberg.gameofkrowns.domain.events.GameEnded;

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
