package nu.danielsundberg.gameofkrowns.business.domain.json;

import nu.danielsundberg.gameofkrowns.access.domain.events.GameStartedEntity;
import nu.danielsundberg.gameofkrowns.domain.Event;
import nu.danielsundberg.gameofkrowns.domain.EventType;
import nu.danielsundberg.gameofkrowns.domain.events.GameStarted;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.Date;

public class GameStartedJSON implements GameStarted {

    private GameStartedEntity gameStartedEntity;

    public GameStartedJSON(GameStartedEntity gameStartedEntity) {
        this.gameStartedEntity = gameStartedEntity;
    }

    @Override
    public Date getRegistrationTime() {
        return gameStartedEntity.getRegistrationTime();
    }

    @Override
    @JsonIgnore
    public Long getGameId() {
        return gameStartedEntity.getGameId();
    }

    @Override
    @JsonIgnore
    public Long getEventId() {
        return gameStartedEntity.getEventId();
    }

    @Override
    public EventType getEventType() {
        return gameStartedEntity.getEventType();
    }

    @Override
    public int compareTo(Event o) {
        return gameStartedEntity.compareTo(o);
    }

}
