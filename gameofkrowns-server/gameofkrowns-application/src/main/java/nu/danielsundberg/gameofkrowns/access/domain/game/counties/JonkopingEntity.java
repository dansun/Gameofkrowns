package nu.danielsundberg.gameofkrowns.access.domain.game.counties;

import javax.persistence.Entity;

import nu.danielsundberg.gameofkrowns.access.domain.GameEntity;
import nu.danielsundberg.gameofkrowns.access.domain.game.CountyEntity;
import nu.danielsundberg.gameofkrowns.access.domain.game.InfluenceEntity;
import nu.danielsundberg.gameofkrowns.domain.game.CountyName;
import nu.danielsundberg.gameofkrowns.domain.game.counties.Jonkoping;

@Entity
public class JonkopingEntity extends CountyEntity implements Jonkoping<GameEntity, InfluenceEntity> {

	private static final long serialVersionUID = 1L;

	public JonkopingEntity() {
		this.countyname = CountyName.JONKOPING;
	}

	@Override
	public CountyName getCountyname() {
		return this.countyname;
	}

}
