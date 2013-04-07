package nu.danielsundberg.gameofkrowns.access.domain.game.counties;

import nu.danielsundberg.gameofkrowns.access.domain.game.CountyEntity;
import nu.danielsundberg.gameofkrowns.domain.game.CountyName;
import nu.danielsundberg.gameofkrowns.domain.game.counties.Dalarna;

import javax.persistence.Entity;

@Entity
public class DalarnaEntity extends CountyEntity implements Dalarna {
	
	private static final long serialVersionUID = 1L;

	public DalarnaEntity() {
		this.countyname = CountyName.DALARNA;
	}

}
