package nu.danielsundberg.gameofkrowns.access.domain.game.counties;

import nu.danielsundberg.gameofkrowns.access.domain.game.CountyEntity;
import nu.danielsundberg.gameofkrowns.domain.game.CountyName;
import nu.danielsundberg.gameofkrowns.domain.game.counties.Uppsala;

import javax.persistence.Entity;

@Entity
public class UppsalaEntity extends CountyEntity implements Uppsala {

	private static final long serialVersionUID = 1L;

	public UppsalaEntity() {
		this.countyname = CountyName.UPPSALA;
	}

}
