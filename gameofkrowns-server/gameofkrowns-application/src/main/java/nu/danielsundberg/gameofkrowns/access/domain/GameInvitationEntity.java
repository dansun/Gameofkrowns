package nu.danielsundberg.gameofkrowns.access.domain;

import nu.danielsundberg.gameofkrowns.domain.Player;

import javax.persistence.*;

@Entity
@Table(name = "GAME_INVITATIONS")
public class GameInvitationEntity {

    @Id
    @GeneratedValue(generator = "INVITATION_SEQUENCE_GENERATOR")
    @SequenceGenerator(
            name = "INVITATION_SEQUENCE_GENERATOR",
            sequenceName = "INVITATION_SEQUENCE")
    @Column(name="INVITATIONID")
    private long invitationId;

    @ManyToOne
    @JoinColumn(name = "INVITATION_PLAYER_ID", referencedColumnName = "PLAYERID")
    private PlayerEntity invitedPlayer;

    @ManyToOne
    @JoinColumn(name = "INVITATION_GAME_ID", referencedColumnName = "GAMEID")
    private GameEntity game;

    public GameEntity getGame() {
        return game;
    }

    public Player getPlayer() {
        return invitedPlayer;
    }

    public void setPlayer(PlayerEntity invitedPlayer) {
        this.invitedPlayer = invitedPlayer;
    }

    public void setGame(GameEntity game) {
        this.game = game;
    }

}
