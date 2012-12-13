package nu.danielsundberg.droid.gameofkrowns.game.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import nu.danielsundberg.droid.gameofkrowns.game.model.game.CountyImpl;
import nu.danielsundberg.gameofkrowns.domain.Game;
import nu.danielsundberg.gameofkrowns.domain.GameState;

import org.joda.time.DateTime;

/**
 * A Game of Krowns
 *
 * @author dansun
 *
 */
public class GameImpl implements Game<PlayerImpl, EventImpl, CountyImpl>, Serializable {

	private static final long serialVersionUID = 1L;

    private Long gameId;
	
	private String gameName;
		
	private Date registrationTime;
			
	private PlayerImpl owner;
	
	private Set<PlayerImpl> invitedPlayers = new HashSet<PlayerImpl>();
	
	private Set<PlayerImpl> players = new HashSet<PlayerImpl>();

	private SortedSet<EventImpl> events = new TreeSet<EventImpl>();
	
	private Set<CountyImpl> counties = new HashSet<CountyImpl>(); 
	
	public void setGameId(long gameId) {
		this.gameId = gameId;
	}

	public Long getGameId() {
		return gameId;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getGameName() {
		return gameName;
	}
	
	/**
	 * Calculates the games current state
	 * @return
	 */
	public GameState getGameState() {
		//
		// Find start and finish events
		//
		EventImpl gameStartedEvent = null;
		EventImpl gameFinishedEvent = null;
		for(EventImpl event : events) {
			switch(event.getEventType()) {
			case GAME_START:
				gameStartedEvent = event;
				break;
			case GAME_FINISH:
				gameFinishedEvent = event;
				break;
			}
		}
		//
		// Parse gamestate
		//
		if(gameStartedEvent!=null && gameFinishedEvent!=null) {
			return GameState.FINISHED;
		} else if (gameStartedEvent != null && gameFinishedEvent == null) {
			return GameState.RUNNING;
		} else {
			return GameState.CREATED;
		}
	}

	public DateTime getRegistrationTime() {
		return registrationTime!=null?new DateTime(registrationTime):null;
	}

	public PlayerImpl getOwner() {
		return owner;
	}

	public void setOwner(PlayerImpl owner) {
		this.owner = owner;
	}

	public Set<PlayerImpl> getInvitedPlayers() {
		return invitedPlayers;
	}

	public void setInvitedPlayers(Set<PlayerImpl> invitedPlayers) {
		this.invitedPlayers = invitedPlayers;
	}

	public Set<PlayerImpl> getPlayers() {
		return players;
	}

	public void setPlayers(Set<PlayerImpl> players) {
		this.players = players;
	}

	public SortedSet<EventImpl> getEvents() {
		return events;
	}

	public void setEvents(SortedSet<EventImpl> events) {
		this.events = events;
	}

	public Set<CountyImpl> getCounties() {
		return counties;
	}

	public void setCounties(Set<CountyImpl> counties) {
		this.counties = counties;
	}
	
}
