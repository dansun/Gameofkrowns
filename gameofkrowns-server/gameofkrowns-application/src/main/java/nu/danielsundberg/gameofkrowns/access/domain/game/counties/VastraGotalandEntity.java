package nu.danielsundberg.gameofkrowns.access.domain.game.counties;

import nu.danielsundberg.gameofkrowns.access.domain.game.CountyEntity;
import nu.danielsundberg.gameofkrowns.domain.game.CountyName;
import nu.danielsundberg.gameofkrowns.domain.game.counties.VastraGotaland;

import javax.persistence.Entity;

@Entity
public class VastraGotalandEntity extends CountyEntity implements VastraGotaland {

	private static final long serialVersionUID = 1L;

	public VastraGotalandEntity() {
		this.countyname = CountyName.VASTRA_GOTALAND;
	}

}
