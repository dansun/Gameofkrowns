package nu.danielsundberg.gameofkrowns.access.domain;

import nu.danielsundberg.gameofkrowns.domain.Event;
import nu.danielsundberg.gameofkrowns.domain.EventType;
import nu.danielsundberg.gameofkrowns.domain.Move;
import nu.danielsundberg.gameofkrowns.domain.MoveType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A game of krowns move
 * 
 * @author dansun
 *
 */
@Entity
@Table(name = "MOVES")
@NamedQueries({
    @NamedQuery(
            name = "move.findByGame",
            query = "SELECT move " +
                    "FROM MoveEntity move " +
                    "WHERE move.game = :game")
})
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class MoveEntity extends EventEntity implements Move<PlayerEntity, GameEntity>, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
    @JoinColumn(name = "PLAYER_ID", referencedColumnName = "PLAYERID")
	private PlayerEntity player;
	
	@Column(name="MOVETYPE", nullable=false)
	@Enumerated(EnumType.STRING)
	private MoveType moveType;
	
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

    @Override
    public int compareTo(Event<GameEntity> o) {
        if(this.getEventId().equals(o.getEventId())) {
            return 0;
        } else {
            return -1;
        }
    }
}
