package nu.danielsundberg.gameofkrowns.access.domain.events;

import nu.danielsundberg.gameofkrowns.access.domain.EventEntity;
import nu.danielsundberg.gameofkrowns.access.domain.GameEntity;
import nu.danielsundberg.gameofkrowns.domain.EventType;
import nu.danielsundberg.gameofkrowns.domain.events.GameTurn;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Date;

/**
 * Event representing one turn complete of a game, IE all players have registered a move.
 * @author dansun
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(
			name="findAllTimedOutEvents",
			query="SELECT gameturn.game " +
                  "FROM GameTurnEntity gameturn " +
                  "WHERE gameturn.timeout < :currentdate")
})
@DiscriminatorValue(value = "GAME_TURN")
@Table(name = "GAME_TURN_EVENT")
public class GameTurnEntity extends EventEntity implements GameTurn<GameEntity> {

	private static final long serialVersionUID = 1L;

	public GameTurnEntity() {
		this.eventType = EventType.GAME_TURN;
		this.timeout = new DateTime().plusHours(1).toDate();
	}
	
	@Column(name="TIMEOUT")
	private Date timeout;
	
	public Date getTimeout() {
		return timeout;
	}

}
