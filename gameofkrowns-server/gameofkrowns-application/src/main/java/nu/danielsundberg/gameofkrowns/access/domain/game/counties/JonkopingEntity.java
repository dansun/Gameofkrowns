package nu.danielsundberg.gameofkrowns.access.domain.game.counties;

import nu.danielsundberg.gameofkrowns.access.domain.game.CountyEntity;
import nu.danielsundberg.gameofkrowns.domain.game.CountyName;
import nu.danielsundberg.gameofkrowns.domain.game.counties.Jonkoping;

import javax.persistence.Entity;

@Entity
public class JonkopingEntity extends CountyEntity implements Jonkoping {

	private static final long serialVersionUID = 1L;

	public JonkopingEntity() {
		this.countyname = CountyName.JONKOPING;
	}

}
