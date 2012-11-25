package org.hackermongo.gameofkrowns.access.domain.game.counties;

import javax.persistence.Entity;

import org.hackermongo.gameofkrowns.access.domain.game.County;

@Entity
public class Halland extends County {

	public Halland() {
		this.countyname = CountyName.GOTLAND;
	}

}
