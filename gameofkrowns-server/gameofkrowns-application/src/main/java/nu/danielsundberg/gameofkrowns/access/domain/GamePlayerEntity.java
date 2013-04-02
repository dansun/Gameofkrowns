package nu.danielsundberg.gameofkrowns.access.domain;

import javax.persistence.*;

@Entity
@Table(name = "GAME_PLAYERS")
public class GamePlayerEntity {

    @Id
    @GeneratedValue(generator = "GAME_PLAYER_SEQUENCE_GENERATOR")
    @SequenceGenerator(
            name = "GAME_PLAYER_SEQUENCE_GENERATOR",
            sequenceName = "GAME_PLAYER_SEQUENCE")
    @Column(name="GAME_PLAYERID")
    private long gamePlayerId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "PLAYING_PLAYER_ID", referencedColumnName = "PLAYERID")
    private PlayerEntity player;

    @ManyToOne(optional = false)
    @JoinColumn(name = "PLAYING_GAME_ID", referencedColumnName = "GAMEID")
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
