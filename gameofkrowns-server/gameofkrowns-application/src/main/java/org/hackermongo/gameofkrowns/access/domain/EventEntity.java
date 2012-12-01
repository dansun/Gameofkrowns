package org.hackermongo.gameofkrowns.access.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.joda.time.DateTime;

@Entity
@Table(name = "EVENTS")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class EventEntity implements Event<GameEntity> {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "EVENT_SEQUENCE")
    @SequenceGenerator(name = "EVENT_SEQUENCE", sequenceName = "EVENT_SEQUENCE")
	@Column(name="EVENTID")
    private Long eventId;
	
	@ManyToOne
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
	public int compareTo(EventEntity o) {
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

	public GameEntity getGame() {
		return game;
	}

	public void setGame(GameEntity game) {
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
