package org.hackermongo.gameofkrowns.access.domain.game.counties;

import javax.persistence.Entity;

import org.hackermongo.gameofkrowns.access.domain.game.County;

@Entity
public class Gavleborg extends County {

	public Gavleborg() {
		this.countyname = CountyName.GAVLEBORG;
	}

}
