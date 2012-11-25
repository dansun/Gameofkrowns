package org.hackermongo.gameofkrowns.access.domain.game.counties;

import javax.persistence.Entity;

import org.hackermongo.gameofkrowns.access.domain.game.County;

@Entity
public class Kalmar extends County {

	public Kalmar() {
		this.countyname = CountyName.KALMAR;
	}

}
