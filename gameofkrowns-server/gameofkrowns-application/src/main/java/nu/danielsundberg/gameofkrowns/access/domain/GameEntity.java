package nu.danielsundberg.gameofkrowns.access.domain;

import nu.danielsundberg.gameofkrowns.access.domain.events.GameTurnEntity;
import nu.danielsundberg.gameofkrowns.domain.Event;
import nu.danielsundberg.gameofkrowns.domain.Game;
import nu.danielsundberg.gameofkrowns.domain.GameState;
import nu.danielsundberg.gameofkrowns.domain.Player;
import nu.danielsundberg.gameofkrowns.domain.events.GameTurn;
import nu.danielsundberg.gameofkrowns.domain.game.County;
import org.hibernate.annotations.Sort;
import org.hibernate.annotations.SortType;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * A Game of Krowns
 *

 *
 */
@Entity
@Table(name = "GAMES")
@NamedQueries({
    @NamedQuery(
            name = "game.findByGameName",
            query = "SELECT game " +
                    "FROM GameEntity AS game " +
                    "WHERE game.gameName = :gameName")
})
public class GameEntity implements Game, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "GAME_SEQUENCE")
    @SequenceGenerator(name = "GAME_SEQUENCE", sequenceName = "GAME_SEQUENCE")
	@Column(name="GAMEID")
    private Long gameId;
	
	@Column(unique=true)
	private String gameName;
		
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="REGISTRATION_TIME")
	private Date registrationTime;
			
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = true)
	private OwnedGameEntity owner;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "game")
	private Set<GameInvitationEntity> gameInvitations = new HashSet<GameInvitationEntity>();
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "game")
	private Set<GamePlayerEntity> players = new HashSet<GamePlayerEntity>();

	@Sort(type=SortType.NATURAL)
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "game")
	private Set<GameEventEntity> events = new TreeSet<GameEventEntity>();
	
	@OneToMany(mappedBy="game", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<GameCountyEntity> counties = new LinkedHashSet<GameCountyEntity>();
	
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

	public GameState getGameState() {
		//
		// Find start and finish events
		//
		EventEntity gameStartedEvent = null;
		EventEntity gameFinishedEvent = null;
        SortedSet<EventEntity> gameEvents = new TreeSet<EventEntity>();
        for(GameEventEntity gameEventEntity : events) {
            gameEvents.add(gameEventEntity.getEvent());
        }
		for(EventEntity event : gameEvents) {
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

	public Date getRegistrationTime() {
		return registrationTime;
	}

	@PrePersist
	@SuppressWarnings("unused")
	private void onCreate() {
		this.registrationTime = new DateTime().toDate();
	}

	public Player getOwningPlayer() {
		return owner.getPlayer();
	}

	public void setOwner(OwnedGameEntity owner) {
		this.owner = owner;
	}

    public Long getOwningPlayerId() {
        return this.getOwningPlayer().getPlayerId();
    }

    public void addInvitedPlayer(GameInvitationEntity gameInvitationEntity) {
        this.gameInvitations.add(gameInvitationEntity);
    }

	public Set<Player> getInvitedPlayers() {
        Set<Player> invitedPlayers = new LinkedHashSet<Player>();
        for(GameInvitationEntity invitationEntity : this.gameInvitations) {
            invitedPlayers.add(invitationEntity.getPlayer());
        }
		return invitedPlayers;
	}

    public Set<Long> getInvitedPlayerIds() {
        Set<Long> invitedPlayerIds = new HashSet<Long>();
        for(Player playerEntity : this.getInvitedPlayers()) {
            invitedPlayerIds.add(playerEntity.getPlayerId());
        }
        return invitedPlayerIds;
    }

    public void addGamePlayer(GamePlayerEntity gamePlayer) {
        this.players.add(gamePlayer);
    }

	public Set<Player> getPlayers() {
        Set<Player> gamePlayers = new LinkedHashSet<Player>();
        for(GamePlayerEntity gamePlayerEntity : players) {
            gamePlayers.add(gamePlayerEntity.getPlayer());
        }
		return gamePlayers;
	}

    public Set<Long> getPlayerIds() {
        Set<Long> playerIds = new HashSet<Long>();
        for(Player playerEntity : this.getPlayers()) {
            playerIds.add(playerEntity.getPlayerId());
        }
        return playerIds;
    }

    public void addEvent(GameEventEntity gameEventEntity) {
        this.events.add(gameEventEntity);
    }

	public SortedSet<Event> getEvents() {
        SortedSet<Event> gameEvents = new TreeSet<Event>();
        for(GameEventEntity gameEventEntity : events) {
            gameEvents.add(gameEventEntity.getEvent());
        }
		return gameEvents;
	}

    public SortedSet<Long> getEventIds() {
        SortedSet<Long> eventIds = new TreeSet<Long>();
        for(Event eventEntity : this.getEvents()) {
            eventIds.add(eventEntity.getEventId());
        }
        return eventIds;
    }

    public void addGameCounty(GameCountyEntity gameCountyEntity) {
        this.counties.add(gameCountyEntity);
    }

	public Set<County> getCounties() {
        Set<County> gameCounties = new LinkedHashSet<County>();
        for(GameCountyEntity gameCountyEntity : counties) {
            gameCounties.add(gameCountyEntity.getCounty());
        }
		return gameCounties;
	}

    public Set<Long> getCountyIds() {
        Set<Long> countyIds = new HashSet<Long>();
        for(County countyEntity : this.getCounties()) {
            countyIds.add(countyEntity.getCountyId());
        }
        return countyIds;
    }

    public GameTurn getCurrentGameTurn() {
        GameTurnEntity gameTurnEntity = null;
        for(Event event : getEvents()) {
            if(event instanceof GameTurnEntity) {
                if(gameTurnEntity == null ||
                        new DateTime(gameTurnEntity.getRegistrationTime())
                                .isBefore(new DateTime(event.getRegistrationTime()))) {
                    gameTurnEntity = (GameTurnEntity) event;
                }
            }
        }
        return gameTurnEntity;
    }

    public Long getCurrentGameTurnId() {
        return this.getCurrentGameTurn()!=null?
                this.getCurrentGameTurn().getEventId():
                null;
    }

}
