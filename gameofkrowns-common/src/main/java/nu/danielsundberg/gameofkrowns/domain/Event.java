package nu.danielsundberg.gameofkrowns.domain;

import java.io.Serializable;

import org.joda.time.DateTime;

public abstract interface Event<GAME> extends Comparable<Event<GAME>>, Serializable {

	public DateTime getRegistrationTime();

	public void setRegistrationTime(DateTime registrationTime);

	public GAME getGame();

	public void setGame(GAME game);

	public Long getEventId();

	public void setEventId(Long eventId);
	
	public EventType getEventType();

	public int compareTo(Event<GAME> o);
	
}
