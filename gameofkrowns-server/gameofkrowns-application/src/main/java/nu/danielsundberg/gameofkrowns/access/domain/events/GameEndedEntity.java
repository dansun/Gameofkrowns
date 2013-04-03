package nu.danielsundberg.gameofkrowns.access.domain.events;

import nu.danielsundberg.gameofkrowns.access.domain.EventEntity;
import nu.danielsundberg.gameofkrowns.access.domain.GameEntity;
import nu.danielsundberg.gameofkrowns.access.domain.PlayerEntity;
import nu.danielsundberg.gameofkrowns.domain.EventType;
import nu.danielsundberg.gameofkrowns.domain.events.GameEnded;

import javax.persistence.*;

/**
 * Event representing end of a game
 */
@Entity
@DiscriminatorValue(value = "GAME_FINISH")
@Table(name = "GAME_FINISHED_EVENT")
public class GameEndedEntity extends EventEntity implements GameEnded<PlayerEntity, GameEntity> {

	private static final long serialVersionUID = 1L;

	@ManyToOne
    @JoinColumn(name = "GAME_FINISHED_PLAYER_ID", referencedColumnName = "PLAYERID")
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

}
