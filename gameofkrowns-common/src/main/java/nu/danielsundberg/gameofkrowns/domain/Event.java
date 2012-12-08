package nu.danielsundberg.gameofkrowns.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.joda.time.DateTime;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="event")
public abstract interface Event<GAME> extends Comparable<Event<GAME>>, Serializable {

	@XmlAttribute(name="registrationTime", required=true) 
	public DateTime getRegistrationTime();

	public void setRegistrationTime(DateTime registrationTime);

	@XmlAttribute(name="game", required=true) 
	public GAME getGame();

	public void setGame(GAME game);

	@XmlAttribute(name="eventId", required=true) 
	public Long getEventId();

	public void setEventId(Long eventId);
	
	@XmlAttribute(name="eventType", required=true) 
	public EventType getEventType();

	public int compareTo(Event<GAME> o);
	
}
