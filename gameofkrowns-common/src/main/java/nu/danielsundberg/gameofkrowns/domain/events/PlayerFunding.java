package nu.danielsundberg.gameofkrowns.domain.events;

import nu.danielsundberg.gameofkrowns.domain.Event;

import java.math.BigDecimal;

/**
 * Event registered at end of each turn,
 * representing new funding gained in passed turn.
 */
public interface PlayerFunding extends Event {

    public Long getPlayerId();

    public BigDecimal getAmount();

}
