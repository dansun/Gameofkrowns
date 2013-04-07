package nu.danielsundberg.gameofkrowns.business.domain.json;

import nu.danielsundberg.gameofkrowns.access.domain.events.GameEndedEntity;
import nu.danielsundberg.gameofkrowns.domain.Event;
import nu.danielsundberg.gameofkrowns.domain.EventType;
import nu.danielsundberg.gameofkrowns.domain.events.GameEnded;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.Date;

public class GameEndedJSON implements GameEnded {

    private GameEndedEntity gameEndedEntity;

    public GameEndedJSON(GameEndedEntity gameEndedEntity) {
        this.gameEndedEntity = gameEndedEntity;
    }

    @Override
    public Long getWinningPlayerId() {
        return gameEndedEntity.getWinningPlayerId();
    }

    @Override
    public Date getRegistrationTime() {
        return gameEndedEntity.getRegistrationTime();
    }

    @Override
    @JsonIgnore
    public Long getGameId() {
        return gameEndedEntity.getGameId();
    }

    @Override
    @JsonIgnore
    public Long getEventId() {
        return gameEndedEntity.getEventId();
    }

    @Override
    public EventType getEventType() {
        return gameEndedEntity.getEventType();
    }

    @Override
    public int compareTo(Event o) {
        return gameEndedEntity.compareTo(o);
    }

}
