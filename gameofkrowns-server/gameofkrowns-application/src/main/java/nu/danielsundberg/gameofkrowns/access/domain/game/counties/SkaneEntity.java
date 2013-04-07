package nu.danielsundberg.gameofkrowns.access.domain.game.counties;

import nu.danielsundberg.gameofkrowns.access.domain.game.CountyEntity;
import nu.danielsundberg.gameofkrowns.domain.game.CountyName;
import nu.danielsundberg.gameofkrowns.domain.game.counties.Skane;

import javax.persistence.Entity;

@Entity
public class SkaneEntity extends CountyEntity implements Skane {

	private static final long serialVersionUID = 1L;

	public SkaneEntity() {
		this.countyname = CountyName.SKANE;
	}

}
