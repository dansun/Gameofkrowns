package nu.danielsundberg.gameofkrowns.access.domain.game.counties;

import javax.persistence.Entity;

import nu.danielsundberg.gameofkrowns.access.domain.GameEntity;
import nu.danielsundberg.gameofkrowns.access.domain.game.CountyEntity;
import nu.danielsundberg.gameofkrowns.access.domain.game.InfluenceEntity;
import nu.danielsundberg.gameofkrowns.domain.game.CountyName;
import nu.danielsundberg.gameofkrowns.domain.game.counties.Jamtland;

@Entity
public class JamtlandEntity extends CountyEntity implements Jamtland<GameEntity, InfluenceEntity> {

	private static final long serialVersionUID = 1L;

	public JamtlandEntity() {
		this.countyname = CountyName.JAMTLAND;
	}

	public CountyName getCountyname() {
		return this.countyname;
	}

}
