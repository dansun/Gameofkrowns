package nu.danielsundberg.gameofkrowns.access.domain.game.counties;

import nu.danielsundberg.gameofkrowns.access.domain.game.CountyEntity;
import nu.danielsundberg.gameofkrowns.domain.game.CountyName;
import nu.danielsundberg.gameofkrowns.domain.game.counties.Orebro;

import javax.persistence.Entity;

@Entity
public class OrebroEntity extends CountyEntity implements Orebro {

	private static final long serialVersionUID = 1L;

	public OrebroEntity() {
		this.countyname = CountyName.OREBRO;
	}

}
