package nu.danielsundberg.gameofkrowns.access.domain.game.counties;

import javax.persistence.Entity;

import nu.danielsundberg.gameofkrowns.access.domain.GameEntity;
import nu.danielsundberg.gameofkrowns.access.domain.game.CountyEntity;
import nu.danielsundberg.gameofkrowns.access.domain.game.InfluenceEntity;
import nu.danielsundberg.gameofkrowns.domain.game.CountyName;
import nu.danielsundberg.gameofkrowns.domain.game.counties.Gotland;

@Entity
public class GotlandEntity extends CountyEntity implements Gotland<GameEntity, InfluenceEntity> {

	private static final long serialVersionUID = 1L;

	public GotlandEntity() {
		this.countyname = CountyName.GOTLAND;
	}

	public CountyName getCountyname() {
		return this.countyname;
	}

}
