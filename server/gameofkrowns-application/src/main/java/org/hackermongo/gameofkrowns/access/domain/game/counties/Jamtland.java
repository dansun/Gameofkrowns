package org.hackermongo.gameofkrowns.access.domain.game.counties;

import javax.persistence.Entity;

import org.hackermongo.gameofkrowns.access.domain.game.County;

@Entity
public class Jamtland extends County {

	public Jamtland() {
		this.countyname = CountyName.JAMTLAND;
	}

}
