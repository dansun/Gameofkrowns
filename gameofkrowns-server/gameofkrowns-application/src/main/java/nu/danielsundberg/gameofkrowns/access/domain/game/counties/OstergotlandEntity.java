package nu.danielsundberg.gameofkrowns.access.domain.game.counties;

import nu.danielsundberg.gameofkrowns.access.domain.game.CountyEntity;
import nu.danielsundberg.gameofkrowns.domain.game.CountyName;
import nu.danielsundberg.gameofkrowns.domain.game.counties.Ostergotland;

import javax.persistence.Entity;

@Entity
public class OstergotlandEntity extends CountyEntity implements Ostergotland {

	private static final long serialVersionUID = 1L;

	public OstergotlandEntity() {
		this.countyname = CountyName.OSTERGOTLAND;
	}

}