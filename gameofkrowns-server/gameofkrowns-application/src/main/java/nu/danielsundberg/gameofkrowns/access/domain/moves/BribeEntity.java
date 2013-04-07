package nu.danielsundberg.gameofkrowns.access.domain.moves;

import nu.danielsundberg.gameofkrowns.access.domain.MoveEntity;
import nu.danielsundberg.gameofkrowns.domain.Event;
import nu.danielsundberg.gameofkrowns.domain.MoveType;
import nu.danielsundberg.gameofkrowns.domain.moves.Bribe;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "BRIBE")
@Table(name="BRIBE")
public class BribeEntity extends MoveEntity implements Bribe {

	private static final long serialVersionUID = 1L;

    @Column(name="BRIBE_AMOUNT")
    private BigDecimal amount;

    public BribeEntity() {
        this.moveType = MoveType.BRIBE;
    }

    @Override
    public BigDecimal getAmount() {
        return amount;
    }

    public int compareTo(Event o) {
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
