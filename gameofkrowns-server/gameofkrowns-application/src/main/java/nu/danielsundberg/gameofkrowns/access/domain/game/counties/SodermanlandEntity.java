package nu.danielsundberg.gameofkrowns.access.domain.game.counties;

import nu.danielsundberg.gameofkrowns.access.domain.game.CountyEntity;
import nu.danielsundberg.gameofkrowns.domain.game.CountyName;
import nu.danielsundberg.gameofkrowns.domain.game.counties.Sodermanland;

import javax.persistence.Entity;

@Entity
public class SodermanlandEntity extends CountyEntity implements Sodermanland {

	private static final long serialVersionUID = 1L;

	public SodermanlandEntity() {
		this.countyname = CountyName.SODERMANLAND;
	}

}
