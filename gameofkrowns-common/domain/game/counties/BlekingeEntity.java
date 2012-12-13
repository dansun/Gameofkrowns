package nu.danielsundberg.gameofkrowns.access.domain.game.counties;

import javax.persistence.Entity;

import nu.danielsundberg.gameofkrowns.access.domain.GameEntity;
import nu.danielsundberg.gameofkrowns.access.domain.game.CountyEntity;
import nu.danielsundberg.gameofkrowns.access.domain.game.InfluenceEntity;
import nu.danielsundberg.gameofkrowns.domain.game.CountyName;
import nu.danielsundberg.gameofkrowns.domain.game.counties.Blekinge;

@Entity
public class BlekingeEntity extends CountyEntity implements Blekinge<GameEntity, InfluenceEntity> {

	private static final long serialVersionUID = 1L;

	public BlekingeEntity() {
		this.countyname = CountyName.BLEKINGE;
	}

	public CountyName getCountyname() {
		return this.countyname;
	}

}
