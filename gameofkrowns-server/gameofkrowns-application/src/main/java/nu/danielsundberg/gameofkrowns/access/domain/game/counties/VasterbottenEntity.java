package nu.danielsundberg.gameofkrowns.access.domain.game.counties;

import nu.danielsundberg.gameofkrowns.access.domain.game.CountyEntity;
import nu.danielsundberg.gameofkrowns.domain.game.CountyName;
import nu.danielsundberg.gameofkrowns.domain.game.counties.Vasterbotten;

import javax.persistence.Entity;

@Entity
public class VasterbottenEntity extends CountyEntity implements Vasterbotten {

	private static final long serialVersionUID = 1L;

	public VasterbottenEntity() {
		this.countyname = CountyName.VASTERBOTTEN;
	}

}