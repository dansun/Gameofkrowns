package nu.danielsundberg.gameofkrowns.access.domain.game.counties;

import javax.persistence.Entity;

import nu.danielsundberg.gameofkrowns.access.domain.GameEntity;
import nu.danielsundberg.gameofkrowns.access.domain.game.CountyEntity;
import nu.danielsundberg.gameofkrowns.access.domain.game.InfluenceEntity;
import nu.danielsundberg.gameofkrowns.domain.game.CountyName;
import nu.danielsundberg.gameofkrowns.domain.game.counties.Sodermanland;

@Entity
public class SodermanlandEntity extends CountyEntity implements Sodermanland<GameEntity, InfluenceEntity> {

	private static final long serialVersionUID = 1L;

	public SodermanlandEntity() {
		this.countyname = CountyName.SODERMANLAND;
	}

	public CountyName getCountyname() {
		return this.countyname;
	}
	
}
