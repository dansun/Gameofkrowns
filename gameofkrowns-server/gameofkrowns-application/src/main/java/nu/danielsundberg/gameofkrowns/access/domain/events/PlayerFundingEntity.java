package nu.danielsundberg.gameofkrowns.access.domain.events;

import nu.danielsundberg.gameofkrowns.access.domain.EventEntity;
import nu.danielsundberg.gameofkrowns.access.domain.PlayerEntity;
import nu.danielsundberg.gameofkrowns.domain.EventType;
import nu.danielsundberg.gameofkrowns.domain.events.PlayerFunding;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "PLAYER_FUNDING")
@Table(name = "PLAYER_FUNDING_EVENT")
public class PlayerFundingEntity extends EventEntity implements PlayerFunding {

    private static final long serialVersionUID = 1L;

    public PlayerFundingEntity() {
        this.eventType = EventType.PLAYER_FUNDING;
    }

    @Column(name="AMOUNT")
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "PLAYER_ID", referencedColumnName = "PLAYERID")
    private PlayerEntity player;


    public void setPlayer(PlayerEntity player) {
        this.player = player;
    }

    public PlayerEntity getPlayer() {
        return player;
    }

    @Override
    public Long getPlayerId() {
        return this.player.getPlayerId();
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

}
