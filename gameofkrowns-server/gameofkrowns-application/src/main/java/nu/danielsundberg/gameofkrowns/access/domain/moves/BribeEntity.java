package nu.danielsundberg.gameofkrowns.access.domain.moves;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import nu.danielsundberg.gameofkrowns.access.domain.GameEntity;
import nu.danielsundberg.gameofkrowns.access.domain.MoveEntity;
import nu.danielsundberg.gameofkrowns.access.domain.PlayerEntity;
import nu.danielsundberg.gameofkrowns.domain.Event;
import nu.danielsundberg.gameofkrowns.domain.moves.Bribe;

import java.math.BigDecimal;

@Entity
@Table(name="BRIBE")
public class BribeEntity extends MoveEntity implements Bribe<PlayerEntity, GameEntity>{

	private static final long serialVersionUID = 1L;

    @Column(name="BRIBE_AMOUNT")
    private BigDecimal amount;

    @Override
    public int compareTo(Event<GameEntity> o) {
        if(this.eventType==o.getEventType()) {
            if(this.getRegistrationTime().equals(o.getRegistrationTime())) {
                if(this.getPlayer().equals(((BribeEntity)o).getPlayer())) {
                    if(this.getEventId().equals(o.getEventId())) {
                        return 0;
                    } else {
                        return -1;
                    }
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        } else {
            return super.compareTo(o);
        }
    }

}
