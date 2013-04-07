package nu.danielsundberg.gameofkrowns.business.domain.json;

import nu.danielsundberg.gameofkrowns.access.domain.events.GameTurnEntity;
import nu.danielsundberg.gameofkrowns.domain.Event;
import nu.danielsundberg.gameofkrowns.domain.EventType;
import nu.danielsundberg.gameofkrowns.domain.events.GameTurn;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.Date;

public class GameTurnJSON implements GameTurn {

    private GameTurnEntity gameTurnEntity;

    public GameTurnJSON(GameTurnEntity gameTurnEntity) {
        this.gameTurnEntity = gameTurnEntity;
    }

    @Override
    public Date getRegistrationTime() {
        return gameTurnEntity.getRegistrationTime();
    }

    @Override
    @JsonIgnore
    public Long getGameId() {
        return gameTurnEntity.getGameId();
    }

    @Override
    public Long getEventId() {
        return gameTurnEntity.getEventId();
    }

    @Override
    public EventType getEventType() {
        return gameTurnEntity.getEventType();
    }

    @Override
    public Date getTimeout() {
        return gameTurnEntity.getTimeout();
    }

    @Override
    public int compareTo(Event o) {
        return gameTurnEntity.compareTo(o);
    }

}
