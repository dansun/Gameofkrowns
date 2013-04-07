package nu.danielsundberg.gameofkrowns.access.domain;

import nu.danielsundberg.gameofkrowns.domain.Player;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Player
 */
@Entity
@Table(name = "PLAYERS")
@NamedQueries({
        @NamedQuery(
                name = "player.findByPlayerName",
                query = "SELECT player " +
                        "FROM PlayerEntity AS player " +
                        "WHERE player.playerName = :playerName")
})
public class PlayerEntity implements Player, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "PLAYER_SEQUENCE")
    @SequenceGenerator(name = "PLAYER_SEQUENCE", sequenceName = "PLAYER_SEQUENCE")
	@Column(name="PLAYERID")
	private long playerId;
	
	@Column(name="PLAYERNAME", unique=true)
	private String playerName;
	
	@Column(name="PASSWORD")
    private String password;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "INVITATION_PLAYER_ID", referencedColumnName = "PLAYERID")
    private Set<GameInvitationEntity> invitedGames = new LinkedHashSet<GameInvitationEntity>();
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "OWNING_PLAYER_ID", referencedColumnName = "PLAYERID")
    private Set<OwnedGameEntity> ownedGames = new LinkedHashSet<OwnedGameEntity>();
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name ="PLAYING_PLAYER_ID", referencedColumnName = "PLAYERID")
	private Set<GamePlayerEntity> playingGames = new LinkedHashSet<GamePlayerEntity>();
	
	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerName() {
		return playerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    public void addInvitationToGame(GameInvitationEntity gameInvitationEntity) {
        this.invitedGames.add(gameInvitationEntity);
    }

	public Set<GameEntity> getInvitedGames() {
		Set<GameEntity> gamesInvitedTo = new LinkedHashSet<GameEntity>();
        for(GameInvitationEntity invitationEntity : this.invitedGames) {
            gamesInvitedTo.add(invitationEntity.getGame());
        }
        return gamesInvitedTo;
	}

    @Override
    public Set<Long> getInvitedGameIds() {
        Set<Long> invitedGameIds = new HashSet<Long>();
        for(GameEntity gameEntity : this.getInvitedGames()) {
            invitedGameIds.add(gameEntity.getGameId());
        }
        return invitedGameIds;
    }

    public void addOwnedGame(OwnedGameEntity ownedGameEntity) {
        this.ownedGames.add(ownedGameEntity);
    }

	public Set<GameEntity> getOwnedGames() {
        Set<GameEntity> ownedGames = new LinkedHashSet<GameEntity>();
        for(OwnedGameEntity ownedGameEntity : this.ownedGames) {
            ownedGames.add(ownedGameEntity.getGame());
        }
		return ownedGames;
	}

    @Override
    public Set<Long> getOwnedGameIds() {
        Set<Long> ownedGameIds = new HashSet<Long>();
        for(GameEntity gameEntity : this.getOwnedGames()) {
            ownedGameIds.add(gameEntity.getGameId());
        }
        return ownedGameIds;
    }

    public void addGamePlayer(GamePlayerEntity playingGame) {
        this.playingGames.add(playingGame);
    }

	public Set<GameEntity> getPlayingGames() {
        Set<GameEntity> playerGames = new LinkedHashSet<GameEntity>();
        for(GamePlayerEntity gamePlayerEntity : playingGames) {
            playerGames.add(gamePlayerEntity.getGame());
        }
		return playerGames;
	}

    @Override
    public Set<Long> getPlayingGameIds() {
        Set<Long> playingGameIds = new HashSet<Long>();
        for(GameEntity gameEntity : this.getPlayingGames()) {
            playingGameIds.add(gameEntity.getGameId());
        }
        return playingGameIds;
    }

}
