package nu.danielsundberg.gameofkrowns.access.domain.game.counties;

import nu.danielsundberg.gameofkrowns.access.domain.game.CountyEntity;
import nu.danielsundberg.gameofkrowns.domain.game.CountyName;
import nu.danielsundberg.gameofkrowns.domain.game.counties.Blekinge;

import javax.persistence.Entity;

@Entity
public class BlekingeEntity extends CountyEntity implements Blekinge {

	private static final long serialVersionUID = 1L;

	public BlekingeEntity() {
		this.countyname = CountyName.BLEKINGE;
	}

}
