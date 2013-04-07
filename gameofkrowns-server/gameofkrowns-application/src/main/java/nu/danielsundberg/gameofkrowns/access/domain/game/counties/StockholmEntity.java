package nu.danielsundberg.gameofkrowns.access.domain.game.counties;

import nu.danielsundberg.gameofkrowns.access.domain.game.CountyEntity;
import nu.danielsundberg.gameofkrowns.domain.game.CountyName;
import nu.danielsundberg.gameofkrowns.domain.game.counties.Stockholm;

import javax.persistence.Entity;

@Entity
public class StockholmEntity extends CountyEntity implements Stockholm {

	private static final long serialVersionUID = 1L;

	public StockholmEntity() {
		this.countyname = CountyName.STOCKHOLM;
	}

}
