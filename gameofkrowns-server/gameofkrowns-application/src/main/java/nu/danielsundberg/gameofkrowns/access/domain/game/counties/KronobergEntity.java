package nu.danielsundberg.gameofkrowns.access.domain.game.counties;

import nu.danielsundberg.gameofkrowns.access.domain.game.CountyEntity;
import nu.danielsundberg.gameofkrowns.domain.game.CountyName;
import nu.danielsundberg.gameofkrowns.domain.game.counties.Kronoberg;

import javax.persistence.Entity;

@Entity
public class KronobergEntity extends CountyEntity implements Kronoberg {

	private static final long serialVersionUID = 1L;

	public KronobergEntity() {
		this.countyname = CountyName.KRONOBERG;
	}

}
