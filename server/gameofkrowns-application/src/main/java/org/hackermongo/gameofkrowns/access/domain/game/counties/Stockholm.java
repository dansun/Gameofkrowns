package org.hackermongo.gameofkrowns.access.domain.game.counties;

import javax.persistence.Entity;

import org.hackermongo.gameofkrowns.access.domain.game.County;

@Entity
public class Stockholm extends County {

	public Stockholm() {
		this.countyname = CountyName.STOCKHOLM;
	}
	
}
