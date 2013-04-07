package nu.danielsundberg.gameofkrowns.domain;

import java.io.Serializable;
import java.util.Date;

public abstract interface Event extends Comparable<Event>, Serializable {

	public Date getRegistrationTime();

	public Long getGameId();

	public Long getEventId();

	public EventType getEventType();

	public int compareTo(Event o);
	
}
