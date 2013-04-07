package nu.danielsundberg.gameofkrowns.access.domain.game.counties;

import nu.danielsundberg.gameofkrowns.access.domain.game.CountyEntity;
import nu.danielsundberg.gameofkrowns.domain.game.CountyName;
import nu.danielsundberg.gameofkrowns.domain.game.counties.Vastmanland;

import javax.persistence.Entity;

@Entity
public class VastmanlandEntity extends CountyEntity implements Vastmanland {

	private static final long serialVersionUID = 1L;

	public VastmanlandEntity() {
		this.countyname = CountyName.VASTMANLAND;
	}

}
