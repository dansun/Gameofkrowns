package nu.danielsundberg.gameofkrowns.access.domain;

import javax.persistence.*;

@Entity
@Table(name = "GAME_EVENTS")
public class GameEventEntity {

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

    public EventEntity getEvent() {
        return event;
    }

    public GameEntity getGame() {
        return game;
    }

}
