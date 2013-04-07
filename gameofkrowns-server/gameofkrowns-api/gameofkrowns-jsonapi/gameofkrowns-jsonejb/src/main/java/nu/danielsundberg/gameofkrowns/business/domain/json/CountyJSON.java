package nu.danielsundberg.gameofkrowns.business.domain.json;

import nu.danielsundberg.gameofkrowns.access.domain.game.CountyEntity;
import nu.danielsundberg.gameofkrowns.access.domain.game.InfluenceEntity;
import nu.danielsundberg.gameofkrowns.domain.game.County;
import nu.danielsundberg.gameofkrowns.domain.game.CountyName;
import nu.danielsundberg.gameofkrowns.domain.game.Influence;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class CountyJSON implements County {

    private CountyEntity countyEntity;

    public CountyJSON(CountyEntity countyEntity) {
        this.countyEntity = countyEntity;
    }

    @Override
    @JsonIgnore
    public Long getCountyId() {
        return countyEntity.getCountyId();
    }

    @Override
    public CountyName getCountyname() {
        return countyEntity.getCountyname();
    }

    @Override
    public Set<Influence> getInfluences() {
        Set<Influence> influenceJSONs = new HashSet<Influence>();
        for(Influence influence : countyEntity.getInfluences()) {
            influenceJSONs.add(new InfluenceJSON((InfluenceEntity)influence));
        }
        return influenceJSONs;
    }

    @Override
    @JsonIgnore
    public Long getGameId() {
        return countyEntity.getGameId();
    }

}
