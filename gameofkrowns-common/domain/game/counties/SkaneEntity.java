package nu.danielsundberg.gameofkrowns.access.domain.game.counties;

import javax.persistence.Entity;

import nu.danielsundberg.gameofkrowns.access.domain.GameEntity;
import nu.danielsundberg.gameofkrowns.access.domain.game.CountyEntity;
import nu.danielsundberg.gameofkrowns.access.domain.game.InfluenceEntity;
import nu.danielsundberg.gameofkrowns.domain.game.CountyName;
import nu.danielsundberg.gameofkrowns.domain.game.counties.Skane;

@Entity
public class SkaneEntity extends CountyEntity implements Skane<GameEntity, InfluenceEntity> {

	private static final long serialVersionUID = 1L;

	public SkaneEntity() {
		this.countyname = CountyName.SKANE;
	}
	public CountyName getCountyname() {
		return this.countyname;
	}
	
}
