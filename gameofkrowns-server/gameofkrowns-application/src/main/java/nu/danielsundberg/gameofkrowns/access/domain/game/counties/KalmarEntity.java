package nu.danielsundberg.gameofkrowns.access.domain.game.counties;

import nu.danielsundberg.gameofkrowns.access.domain.game.CountyEntity;
import nu.danielsundberg.gameofkrowns.domain.game.CountyName;
import nu.danielsundberg.gameofkrowns.domain.game.counties.Kalmar;

import javax.persistence.Entity;

@Entity
public class KalmarEntity extends CountyEntity implements Kalmar {

	private static final long serialVersionUID = 1L;

	public KalmarEntity() {
		this.countyname = CountyName.KALMAR;
	}

}
