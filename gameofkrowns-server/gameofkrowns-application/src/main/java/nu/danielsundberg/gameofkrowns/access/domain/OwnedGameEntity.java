package nu.danielsundberg.gameofkrowns.access.domain;


import javax.persistence.*;

@Entity
@Table(name = "OWNED_GAMES")
public class OwnedGameEntity {

    @Id
    @GeneratedValue(generator = "OWNER_SEQUENCE_GENERATOR")
    @SequenceGenerator(
            name = "OWNER_SEQUENCE_GENERATOR",
            sequenceName = "OWNER_SEQUENCE")
    @Column(name="OWNERID")
    private long ownerId;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "OWNING_PLAYER_ID", referencedColumnName = "PLAYERID")
    private PlayerEntity player;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "OWNING_GAME_ID", referencedColumnName = "GAMEID")
    private GameEntity game;

    public GameEntity getGame() {
        return game;
    }

    public PlayerEntity getPlayer() {
        return player;
    }

    public void setPlayer(PlayerEntity player) {
        this.player = player;
    }

    public void setGame(GameEntity game) {
        this.game = game;
    }
}
