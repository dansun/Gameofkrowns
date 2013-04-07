package nu.danielsundberg.gameofkrowns.business.domain.json;

import nu.danielsundberg.gameofkrowns.access.domain.PlayerEntity;
import nu.danielsundberg.gameofkrowns.domain.Player;
import org.codehaus.jackson.annotate.JsonWriteNullProperties;

import java.util.Set;

@JsonWriteNullProperties(true)
public class PlayerJSON implements Player {

    private PlayerEntity playerEntity;

    public PlayerJSON(PlayerEntity playerEntity) {
        this.playerEntity = playerEntity;
    }

    @Override
    public long getPlayerId() {
        return playerEntity.getPlayerId();
    }

    @Override
    public String getPlayerName() {
        return playerEntity.getPlayerName();
    }

    @Override
    public Set<Long> getInvitedGameIds() {
        return playerEntity.getInvitedGameIds();
    }

    @Override
    public Set<Long> getOwnedGameIds() {
        return playerEntity.getOwnedGameIds();
    }

    @Override
    public Set<Long> getPlayingGameIds() {
        return playerEntity.getPlayingGameIds();
    }

}
