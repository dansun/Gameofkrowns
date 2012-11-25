package org.hackermongo.gameofkrowns.access.domain.game.counties;

import javax.persistence.Entity;

import org.hackermongo.gameofkrowns.access.domain.game.County;

@Entity
public class Norrbotten extends County {

	public Norrbotten() {
		this.countyname = CountyName.NORRBOTTEN;
	}

}
