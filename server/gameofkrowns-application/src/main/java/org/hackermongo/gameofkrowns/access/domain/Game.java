package org.hackermongo.gameofkrowns.access.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.hackermongo.gameofkrowns.access.domain.game.County;
import org.hibernate.annotations.Sort;
import org.hibernate.annotations.SortType;
import org.joda.time.DateTime;

/**
 * A Game of Krowns
 *
 * @author dansun
 *
 */
@Entity
@Table(name = "GAMES")
@NamedQueries({
    @NamedQuery(name = "game.findByGameName", query = "SELECT g FROM Game AS g WHERE g.gameName = :gameName")
})
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="game")
public class Game implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "GAME_SEQUENCE")
    @SequenceGenerator(name = "GAME_SEQUENCE", sequenceName = "GAME_SEQUENCE")
	@Column(name="GAMEID")
	@XmlAttribute(name="gameId", required=true)
    private Long gameId;
	
	@Column(unique=true)
	@XmlAttribute(name="gameName", required=true)
	private String gameName;
		
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="REGISTRATION_TIME")
	private Date registrationTime;
			
	@ManyToOne
	private Player owner;
	
	@OneToMany(mappedBy="invitedGames", cascade=CascadeType.ALL)
	private Set<Player> invitedPlayers = new HashSet<Player>();
	
	@OneToMany(mappedBy="playingGames", cascade=CascadeType.ALL)
	private Set<Player> players = new HashSet<Player>();

	@Sort(type=SortType.NATURAL)
	@OneToMany(mappedBy="game", cascade=CascadeType.ALL)
	private SortedSet<Event> events = new TreeSet<Event>();
	
	@OneToMany(mappedBy="game")
	private Set<County> counties = new HashSet<County>(); 
	
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
	@XmlAttribute(name="gameState", required=true)
	public GameState getGameState() {
		//
		// Find start and finish events
		//
		Event gameStartedEvent = null;
		Event gameFinishedEvent = null;
		for(Event event : events) {
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

	@PrePersist
	@SuppressWarnings("unused")
	private void onCreate() {
		this.registrationTime = new DateTime().toDate();
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public Set<Player> getInvitedPlayers() {
		return invitedPlayers;
	}

	public void setInvitedPlayers(Set<Player> invitedPlayers) {
		this.invitedPlayers = invitedPlayers;
	}

	public Set<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Set<Player> players) {
		this.players = players;
	}

	public SortedSet<Event> getEvents() {
		return events;
	}

	public void setEvents(SortedSet<Event> events) {
		this.events = events;
	}

	public Set<County> getCounties() {
		return counties;
	}

	public void setCounties(Set<County> counties) {
		this.counties = counties;
	}

	public enum GameState {
		CREATED,
		RUNNING,
		FINISHED
	}
	
}
