package org.hackermongo.gameofkrowns.access.domain.game.counties;

import javax.persistence.Entity;

import org.hackermongo.gameofkrowns.access.domain.game.County;

@Entity
public class Gotland extends County {

	public Gotland() {
		this.countyname = CountyName.GOTLAND;
	}

}
