package nu.danielsundberg.gameofkrowns.access.domain.game.counties;

import nu.danielsundberg.gameofkrowns.access.domain.game.CountyEntity;
import nu.danielsundberg.gameofkrowns.domain.game.CountyName;
import nu.danielsundberg.gameofkrowns.domain.game.counties.Varmland;

import javax.persistence.Entity;

@Entity
public class VarmlandEntity extends CountyEntity implements Varmland {

	private static final long serialVersionUID = 1L;

	public VarmlandEntity() {
		this.countyname = CountyName.VARMLAND;
	}

}
