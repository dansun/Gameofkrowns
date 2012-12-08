package nu.danielsundberg.gameofkrowns.access.domain.game.counties;

import javax.persistence.Entity;

import nu.danielsundberg.gameofkrowns.access.domain.GameEntity;
import nu.danielsundberg.gameofkrowns.access.domain.game.CountyEntity;
import nu.danielsundberg.gameofkrowns.access.domain.game.InfluenceEntity;
import nu.danielsundberg.gameofkrowns.domain.game.CountyName;
import nu.danielsundberg.gameofkrowns.domain.game.counties.Kalmar;

@Entity
public class KalmarEntity extends CountyEntity implements Kalmar<GameEntity, InfluenceEntity> {

	private static final long serialVersionUID = 1L;

	public KalmarEntity() {
		this.countyname = CountyName.KALMAR;
	}

	public CountyName getCountyname() {
		return this.countyname;
	}

}
