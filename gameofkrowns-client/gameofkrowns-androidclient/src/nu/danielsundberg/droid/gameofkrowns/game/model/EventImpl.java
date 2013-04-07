package nu.danielsundberg.droid.gameofkrowns.game.model;

import nu.danielsundberg.gameofkrowns.domain.Event;
import nu.danielsundberg.gameofkrowns.domain.EventType;
import org.joda.time.DateTime;

import java.util.Date;

public abstract class EventImpl implements Event {

	private static final long serialVersionUID = 1L;
	
    private Long eventId;
	
	private GameImpl game;
	
	private Date registrationTime;
	
	protected EventType eventType;
	
	
	public int compareTo(EventImpl o) {
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
	
	public Date getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(DateTime registrationTime) {
		this.registrationTime = registrationTime.toDate();
	}

	public GameImpl getGame() {
		return game;
	}

	public void setGame(GameImpl game) {
		this.game = game;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	
	public EventType getEventType() {
		return eventType;
	}

}
