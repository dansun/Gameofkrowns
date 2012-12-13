package nu.danielsundberg.gameofkrowns.access.domain.game.counties;

import javax.persistence.Entity;

import nu.danielsundberg.gameofkrowns.access.domain.GameEntity;
import nu.danielsundberg.gameofkrowns.access.domain.game.CountyEntity;
import nu.danielsundberg.gameofkrowns.access.domain.game.InfluenceEntity;
import nu.danielsundberg.gameofkrowns.domain.game.CountyName;
import nu.danielsundberg.gameofkrowns.domain.game.counties.Norrbotten;

@Entity
public class NorrbottenEntity extends CountyEntity implements Norrbotten<GameEntity, InfluenceEntity> {

	private static final long serialVersionUID = 1L;

	public NorrbottenEntity() {
		this.countyname = CountyName.NORRBOTTEN;
	}

	public CountyName getCountyname() {
		return this.countyname;
	}

}
