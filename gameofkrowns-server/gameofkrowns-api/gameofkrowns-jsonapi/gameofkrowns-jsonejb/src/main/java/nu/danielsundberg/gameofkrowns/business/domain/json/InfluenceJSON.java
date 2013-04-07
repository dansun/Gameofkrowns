package nu.danielsundberg.gameofkrowns.business.domain.json;

import nu.danielsundberg.gameofkrowns.access.domain.game.InfluenceEntity;
import nu.danielsundberg.gameofkrowns.domain.Player;
import nu.danielsundberg.gameofkrowns.domain.game.County;
import nu.danielsundberg.gameofkrowns.domain.game.Influence;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.math.BigDecimal;

public class InfluenceJSON implements Influence {

    private InfluenceEntity influenceEntity;

    public InfluenceJSON(InfluenceEntity influenceEntity) {
        this.influenceEntity = influenceEntity;
    }

    @Override
    @JsonIgnore
    public Long getInfluenceId() {
        return influenceEntity.getInfluenceId();
    }

    @Override
    public BigDecimal getAmount() {
        return influenceEntity.getAmount();
    }

    @Override
    public Player getPlayer() {
        return new PlayerJSON(influenceEntity.getPlayer());
    }

    @Override
    @JsonIgnore
    public County getCounty() {
        return influenceEntity.getCounty();
    }

}
