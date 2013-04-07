package nu.danielsundberg.gameofkrowns.access.domain.game.counties;

import nu.danielsundberg.gameofkrowns.access.domain.game.CountyEntity;
import nu.danielsundberg.gameofkrowns.domain.game.CountyName;
import nu.danielsundberg.gameofkrowns.domain.game.counties.Gotland;

import javax.persistence.Entity;

@Entity
public class GavleborgEntity extends CountyEntity implements Gotland {

	private static final long serialVersionUID = 1L;

	public GavleborgEntity() {
		this.countyname = CountyName.GAVLEBORG;
	}

}
