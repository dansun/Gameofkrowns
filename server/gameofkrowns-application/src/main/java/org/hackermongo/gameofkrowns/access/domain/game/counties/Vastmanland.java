package org.hackermongo.gameofkrowns.access.domain.game.counties;

import javax.persistence.Entity;

import org.hackermongo.gameofkrowns.access.domain.game.County;

@Entity
public class Vastmanland extends County {

	public Vastmanland() {
		this.countyname = CountyName.VASTMANLAND;
	}
	
}
