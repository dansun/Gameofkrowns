package org.hackermongo.gameofkrowns.android.model;

import java.util.Date;

import org.hackermongo.gameofkrowns.access.domain.Event;
import org.hackermongo.gameofkrowns.access.domain.EventType;
import org.joda.time.DateTime;

public abstract class EventImpl implements Event<GameImpl> {

	private static final long serialVersionUID = 1L;
	
    private Long eventId;
	
	private GameImpl game;
	
	private Date registrationTime;
	
	protected EventType eventType;
	
	
	public int compareTo(EventImpl o) {
		if(o.getRegistrationTime()!=null && this.getRegistrationTime() !=null) {
			if(o.getRegistrationTime().isEqual(this.getRegistrationTime())) {
				if(o.getEventId()!=null && this.getEventId() !=null) {
					return o.getEventId().compareTo(this.eventId);
				} else {
					return -1;
				}
			} else {
				if(o.getRegistrationTime().isBefore(this.getRegistrationTime())) {
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
	
	public DateTime getRegistrationTime() {
		return registrationTime!=null?new DateTime(registrationTime):null;
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
