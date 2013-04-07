package nu.danielsundberg.gameofkrowns.access.domain.game.counties;

import nu.danielsundberg.gameofkrowns.access.domain.game.CountyEntity;
import nu.danielsundberg.gameofkrowns.domain.game.CountyName;
import nu.danielsundberg.gameofkrowns.domain.game.counties.Halland;

import javax.persistence.Entity;

@Entity
public class HallandEntity extends CountyEntity implements Halland {

	private static final long serialVersionUID = 1L;

	public HallandEntity() {
		this.countyname = CountyName.HALLAND;
	}

}
