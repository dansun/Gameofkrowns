package nu.danielsundberg.gameofkrowns.business.domain.json;

import nu.danielsundberg.gameofkrowns.access.domain.moves.BribeEntity;
import nu.danielsundberg.gameofkrowns.domain.Event;
import nu.danielsundberg.gameofkrowns.domain.EventType;
import nu.danielsundberg.gameofkrowns.domain.MoveType;
import nu.danielsundberg.gameofkrowns.domain.Player;
import nu.danielsundberg.gameofkrowns.domain.events.GameTurn;
import nu.danielsundberg.gameofkrowns.domain.moves.Bribe;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.math.BigDecimal;
import java.util.Date;

public class BribeJSON implements Bribe {

    private BribeEntity bribeEntity;

    public BribeJSON(BribeEntity bribeEntity) {
        this.bribeEntity = bribeEntity;
    }

    @Override
    public BigDecimal getAmount() {
        return bribeEntity.getAmount();
    }

    @Override
    public Player getPlayer() {
        return new PlayerJSON(bribeEntity.getPlayer());
    }

    @Override
    public MoveType getMoveType() {
        return bribeEntity.getMoveType();
    }

    @Override
    public GameTurn getGameTurn() {
        return new GameTurnJSON(bribeEntity.getGameTurn());
    }

    @Override
    public Date getRegistrationTime() {
        return bribeEntity.getRegistrationTime();
    }

    @Override
    @JsonIgnore
    public Long getGameId() {
        return bribeEntity.getGameId();
    }

    @Override
    @JsonIgnore
    public Long getEventId() {
        return bribeEntity.getEventId();
    }

    @Override
    public EventType getEventType() {
        return bribeEntity.getEventType();
    }

    @Override
    public int compareTo(Event o) {
        return bribeEntity.compareTo(o);
    }

}
