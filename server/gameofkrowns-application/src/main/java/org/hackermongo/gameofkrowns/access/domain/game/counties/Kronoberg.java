package org.hackermongo.gameofkrowns.access.domain.game.counties;

import javax.persistence.Entity;

import org.hackermongo.gameofkrowns.access.domain.game.County;

@Entity
public class Kronoberg extends County {

	public Kronoberg() {
		this.countyname = CountyName.KRONOBERG;
	}

}
