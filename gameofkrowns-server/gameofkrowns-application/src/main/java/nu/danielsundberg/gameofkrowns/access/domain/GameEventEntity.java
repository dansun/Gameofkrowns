package nu.danielsundberg.gameofkrowns.access.domain;

import javax.persistence.*;

@Entity
@Table(name = "GAME_EVENTS")
public class GameEventEntity implements Comparable<GameEventEntity> {

    @Id
    @GeneratedValue(generator = "GAME_EVENT_SEQUENCE_GENERATOR")
    @SequenceGenerator(
            name = "GAME_EVENT_SEQUENCE_GENERATOR",
            sequenceName = "GAME_EVENT_SEQUENCE")
    @Column(name="GAME_EVENTID")
    private long gameEventId;

    @OneToOne
    @JoinColumn(name = "EVENT_ID", referencedColumnName = "EVENTID")
    private EventEntity event;

    @ManyToOne
    @JoinColumn(name = "EVENT_GAME_ID", referencedColumnName = "GAMEID")
    private GameEntity game;

    public void setEvent(EventEntity eventEntity) {
        this.event = eventEntity;
    }

    public EventEntity getEvent() {
        return event;
    }

    public void setGame(GameEntity gameEntity) {
        this.game = gameEntity;
    }

    public GameEntity getGame() {
        return game;
    }

    @Override
    public int compareTo(GameEventEntity gameEventEntity) {
        if(this.game.equals(gameEventEntity.getGame()) &&
                this.event.equals(gameEventEntity.getEvent())) {
            return 0;
        } else {
            return -1;
        }
    }

}
