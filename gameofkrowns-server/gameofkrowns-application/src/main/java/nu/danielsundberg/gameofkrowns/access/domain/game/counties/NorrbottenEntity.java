package nu.danielsundberg.gameofkrowns.access.domain.game.counties;

import nu.danielsundberg.gameofkrowns.access.domain.game.CountyEntity;
import nu.danielsundberg.gameofkrowns.domain.game.CountyName;
import nu.danielsundberg.gameofkrowns.domain.game.counties.Norrbotten;

import javax.persistence.Entity;

@Entity
public class NorrbottenEntity extends CountyEntity implements Norrbotten {

	private static final long serialVersionUID = 1L;

	public NorrbottenEntity() {
		this.countyname = CountyName.NORRBOTTEN;
	}

}
