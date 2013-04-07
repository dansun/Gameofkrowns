package nu.danielsundberg.gameofkrowns.access.domain;

import nu.danielsundberg.gameofkrowns.domain.Event;
import nu.danielsundberg.gameofkrowns.domain.EventType;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EVENTS")
@DiscriminatorColumn(name = "EVENTTYPE", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class EventEntity implements Event {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "EVENT_SEQUENCE")
    @SequenceGenerator(name = "EVENT_SEQUENCE", sequenceName = "EVENT_SEQUENCE")
	@Column(name="EVENTID")
    private Long eventId;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="GAME_ID", referencedColumnName = "GAMEID")
	private GameEntity game;
	
	@Column(name="REGISTRATIONTIME", nullable=false)
	private Date registrationTime;
	
	@Column(name="EVENTTYPE", nullable=false)
	@Enumerated(EnumType.STRING)
	protected EventType eventType;
	
	@PrePersist
	@SuppressWarnings("unused")
	private void onCreate() {
		this.registrationTime = new DateTime().toDate();
	}

    /**
	 * Compare using registrationtime.
	 */
    @Override
	public int compareTo(Event o) {
		if(o.getRegistrationTime()!=null && this.getRegistrationTime() !=null) {
			if(new DateTime(o.getRegistrationTime()).isEqual(new DateTime(this.getRegistrationTime()))) {
				if(o.getEventId()!=null && this.getEventId() !=null) {
					return o.getEventId().compareTo(this.eventId);
				} else {
					return -1;
				}
			} else {
				if(new DateTime(o.getRegistrationTime()).isBefore(new DateTime(this.getRegistrationTime()))) {
					return 1;
				} else {
					return -1;
				}	
			}			
		} else {
			if(o.getRegistrationTime()==null) {
				if(this.getRegistrationTime()!=null) {
					return -1;
				} else {
					if(o.getEventId()!=null && this.getEventId() !=null) {
						return o.getEventId().compareTo(this.eventId);
					} else {
						return -1;
					}
				}
			} else {
				if(this.getRegistrationTime()!=null) {
					return 1;
				} else {
					if(o.getEventId()!=null && this.getEventId() !=null) {
						return o.getEventId().compareTo(this.eventId);
					} else {
						return -1;
					}
				}
			}
		}
	}

    @Override
	public Date getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(Date registrationTime) {
		this.registrationTime = registrationTime;
	}

	public GameEntity getGame() {
		return game;
	}

	public void setGame(GameEntity game) {
		this.game = game;
	}

    @Override
    public Long getGameId() {
        return this.game.getGameId();
    }

    @Override
    public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

    @Override
	public EventType getEventType() {
		return eventType;
	}

}
