package nu.danielsundberg.gameofkrowns.access.domain.game.counties;

import nu.danielsundberg.gameofkrowns.access.domain.game.CountyEntity;
import nu.danielsundberg.gameofkrowns.domain.game.CountyName;
import nu.danielsundberg.gameofkrowns.domain.game.counties.Jamtland;

import javax.persistence.Entity;

@Entity
public class JamtlandEntity extends CountyEntity implements Jamtland {

	private static final long serialVersionUID = 1L;

	public JamtlandEntity() {
		this.countyname = CountyName.JAMTLAND;
	}

}
