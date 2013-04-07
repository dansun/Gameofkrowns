package nu.danielsundberg.gameofkrowns.access.domain.game.counties;

import nu.danielsundberg.gameofkrowns.access.domain.game.CountyEntity;
import nu.danielsundberg.gameofkrowns.domain.game.CountyName;
import nu.danielsundberg.gameofkrowns.domain.game.counties.Vasternorrland;

import javax.persistence.Entity;

@Entity
public class VasternorrlandEntity extends CountyEntity implements Vasternorrland {

	private static final long serialVersionUID = 1L;

	public VasternorrlandEntity() {
		this.countyname = CountyName.VASTERNORRLAND;
	}

}
