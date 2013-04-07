package nu.danielsundberg.gameofkrowns.business.domain.json;

import nu.danielsundberg.gameofkrowns.access.domain.moves.PropagandaEntity;
import nu.danielsundberg.gameofkrowns.domain.Event;
import nu.danielsundberg.gameofkrowns.domain.EventType;
import nu.danielsundberg.gameofkrowns.domain.MoveType;
import nu.danielsundberg.gameofkrowns.domain.Player;
import nu.danielsundberg.gameofkrowns.domain.events.GameTurn;
import nu.danielsundberg.gameofkrowns.domain.moves.Propaganda;

import java.math.BigDecimal;
import java.util.Date;

public class PropagandaJSON implements Propaganda {

    private PropagandaEntity propagandaEntity;

    public PropagandaJSON(PropagandaEntity propagandaEntity) {
        this.propagandaEntity = propagandaEntity;
    }

    @Override
    public BigDecimal getAmount() {
        return propagandaEntity.getAmount();
    }

    @Override
    public Player getPlayer() {
        return new PlayerJSON(propagandaEntity.getPlayer());
    }

    @Override
    public MoveType getMoveType() {
        return propagandaEntity.getMoveType();
    }

    @Override
    public GameTurn getGameTurn() {
        return new GameTurnJSON(propagandaEntity.getGameTurn());
    }

    @Override
    public Date getRegistrationTime() {
        return propagandaEntity.getRegistrationTime();
    }

    @Override
    public Long getGameId() {
        return propagandaEntity.getGameId();
    }

    @Override
    public Long getEventId() {
        return propagandaEntity.getEventId();
    }

    @Override
    public EventType getEventType() {
        return propagandaEntity.getEventType();
    }

    @Override
    public int compareTo(Event o) {
        return propagandaEntity.compareTo(o);
    }
}
