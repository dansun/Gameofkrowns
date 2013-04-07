package nu.danielsundberg.gameofkrowns.access.domain.moves;

import nu.danielsundberg.gameofkrowns.access.domain.MoveEntity;
import nu.danielsundberg.gameofkrowns.domain.Event;
import nu.danielsundberg.gameofkrowns.domain.MoveType;
import nu.danielsundberg.gameofkrowns.domain.moves.Propaganda;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "PROPAGANDA")
@Table(name="PROPAGANDA")
public class PropagandaEntity extends MoveEntity implements Propaganda {

	private static final long serialVersionUID = 1L;

    @Column(name="PROPAGANDA_AMOUNT")
    private BigDecimal amount;


    public PropagandaEntity() {
        this.moveType = MoveType.PROPAGANDA;
    }

    @Override
    public BigDecimal getAmount() {
        return amount;
    }

    public int compareTo(Event o) {
		if(this.eventType==o.getEventType()) {
            if(this.getRegistrationTime().equals(o.getRegistrationTime())) {
                if(this.getPlayer().equals(((PropagandaEntity)o).getPlayer())) {
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
