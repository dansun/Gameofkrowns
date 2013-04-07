package nu.danielsundberg.gameofkrowns.business.domain.json;

import nu.danielsundberg.gameofkrowns.access.domain.events.PlayerFundingEntity;
import nu.danielsundberg.gameofkrowns.domain.Event;
import nu.danielsundberg.gameofkrowns.domain.EventType;
import nu.danielsundberg.gameofkrowns.domain.events.PlayerFunding;

import java.math.BigDecimal;
import java.util.Date;

public class PlayerFundingJSON implements PlayerFunding {

    private PlayerFundingEntity playerFundingEntity;

    public PlayerFundingJSON(PlayerFundingEntity playerFundingEntity) {
        this.playerFundingEntity = playerFundingEntity;
    }

    @Override
    public Long getPlayerId() {
        return playerFundingEntity.getPlayerId();
    }

    @Override
    public BigDecimal getAmount() {
        return playerFundingEntity.getAmount();
    }

    @Override
    public Date getRegistrationTime() {
        return playerFundingEntity.getRegistrationTime();
    }

    @Override
    public Long getGameId() {
        return playerFundingEntity.getGameId();
    }

    @Override
    public Long getEventId() {
        return playerFundingEntity.getEventId();
    }

    @Override
    public EventType getEventType() {
        return playerFundingEntity.getEventType();
    }

    @Override
    public int compareTo(Event o) {
        return playerFundingEntity.compareTo(o);
    }

}
