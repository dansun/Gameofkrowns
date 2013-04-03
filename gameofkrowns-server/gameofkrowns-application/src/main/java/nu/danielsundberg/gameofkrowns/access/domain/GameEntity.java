package nu.danielsundberg.gameofkrowns.access.domain;

import nu.danielsundberg.gameofkrowns.access.domain.events.GameTurnEntity;
import nu.danielsundberg.gameofkrowns.access.domain.game.CountyEntity;
import nu.danielsundberg.gameofkrowns.domain.Game;
import nu.danielsundberg.gameofkrowns.domain.GameState;
import nu.danielsundberg.gameofkrowns.domain.events.GameTurn;
import org.hibernate.annotations.Sort;
import org.hibernate.annotations.SortType;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * A Game of Krowns
 *
 * @author dansun
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
public class GameEntity implements Game<PlayerEntity, EventEntity, CountyEntity>, Serializable {

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

	public DateTime getRegistrationTime() {
		return registrationTime!=null?new DateTime(registrationTime):null;
	}

	@PrePersist
	@SuppressWarnings("unused")
	private void onCreate() {
		this.registrationTime = new DateTime().toDate();
	}

	public PlayerEntity getOwner() {
		return owner.getPlayer();
	}

	public void setOwner(OwnedGameEntity owner) {
		this.owner = owner;
	}

    public void addInvitedPlayer(GameInvitationEntity gameInvitationEntity) {
        this.gameInvitations.add(gameInvitationEntity);
    }

	public Set<PlayerEntity> getInvitedPlayers() {
        Set<PlayerEntity> invitedPlayers = new LinkedHashSet<PlayerEntity>();
        for(GameInvitationEntity invitationEntity : this.gameInvitations) {
            invitedPlayers.add(invitationEntity.getPlayer());
        }
		return invitedPlayers;
	}

    public void addGamePlayer(GamePlayerEntity gamePlayer) {
        this.players.add(gamePlayer);
    }

	public Set<PlayerEntity> getPlayers() {
        Set<PlayerEntity> gamePlayers = new LinkedHashSet<PlayerEntity>();
        for(GamePlayerEntity gamePlayerEntity : players) {
            gamePlayers.add(gamePlayerEntity.getPlayer());
        }
		return gamePlayers;
	}

    public void addEvent(GameEventEntity gameEventEntity) {
        this.events.add(gameEventEntity);
    }

	public SortedSet<EventEntity> getEvents() {
        SortedSet<EventEntity> gameEvents = new TreeSet<EventEntity>();
        for(GameEventEntity gameEventEntity : events) {
            gameEvents.add(gameEventEntity.getEvent());
        }
		return gameEvents;
	}

    public void addGameCounty(GameCountyEntity gameCountyEntity) {
        this.counties.add(gameCountyEntity);
    }

	public Set<CountyEntity> getCounties() {
        Set<CountyEntity> gameCounties = new LinkedHashSet<CountyEntity>();
        for(GameCountyEntity gameCountyEntity : counties) {
            gameCounties.add(gameCountyEntity.getCounty());
        }
		return gameCounties;
	}

    public GameTurn getCurrentGameTurn() {
        GameTurnEntity gameTurnEntity = null;
        for(EventEntity event : getEvents()) {
            if(event instanceof GameTurnEntity) {
                if(gameTurnEntity == null ||
                        gameTurnEntity.getRegistrationTime().isBefore(event.getRegistrationTime())) {
                    gameTurnEntity = (GameTurnEntity) event;
                }
            }
        }
        return gameTurnEntity;
    }

}
