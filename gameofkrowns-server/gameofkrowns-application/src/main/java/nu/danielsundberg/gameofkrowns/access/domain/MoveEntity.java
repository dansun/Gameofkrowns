package nu.danielsundberg.gameofkrowns.access.domain;

import nu.danielsundberg.gameofkrowns.access.domain.events.GameTurnEntity;
import nu.danielsundberg.gameofkrowns.domain.Event;
import nu.danielsundberg.gameofkrowns.domain.EventType;
import nu.danielsundberg.gameofkrowns.domain.Move;
import nu.danielsundberg.gameofkrowns.domain.MoveType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A Game of Krowns persisted move
 */
@Entity
@Table(name = "MOVES")
@NamedQueries({
    @NamedQuery(
            name = "move.findByGame",
            query = "SELECT move " +
                    "FROM MoveEntity move " +
                    "WHERE move.game = :game"),
    @NamedQuery(
            name = "move.findByPlayerAndGameTurn",
            query = "SELECT move " +
                    "FROM MoveEntity move " +
                    "WHERE move.player = :player " +
                    "AND move.gameTurn = :gameTurn"),
    @NamedQuery(
            name = "move.findMovesForGameTurn",
            query = "SELECT move " +
                    "FROM MoveEntity move " +
                    "WHERE move.gameTurn = :gameTurn")
})
@DiscriminatorColumn(name = "MOVETYPE", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class MoveEntity extends EventEntity implements Move<PlayerEntity, GameEntity, GameTurnEntity>, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
    @JoinColumn(name = "PLAYER_ID", referencedColumnName = "PLAYERID")
	private PlayerEntity player;

    @ManyToOne
    @JoinColumn(name = "TURN_EVENT_ID", referencedColumnName = "EVENTID")
    private GameTurnEntity gameTurn;
	
	@Column(name="MOVETYPE", nullable=false)
	@Enumerated(EnumType.STRING)
	protected MoveType moveType;

    public MoveEntity() {
        this.eventType = EventType.GAME_MOVE;
    }

    public PlayerEntity getPlayer() {
		return player;
	}

	public void setPlayer(PlayerEntity player) {
		this.player = player;
	}
	
	public MoveType getMoveType() {
		return moveType;
	}
	
	public final EventType getEventType() {
		return EventType.GAME_MOVE;
	}

    public void setGameTurn(GameTurnEntity gameTurn) {
        this.gameTurn = gameTurn;
    }

    public GameTurnEntity getGameTurn() {
        return this.gameTurn;
    }

    @Override
    public int compareTo(Event<GameEntity> o) {
        if(this.getEventId().equals(o.getEventId())) {
            return 0;
        } else {
            return -1;
        }
    }
}
