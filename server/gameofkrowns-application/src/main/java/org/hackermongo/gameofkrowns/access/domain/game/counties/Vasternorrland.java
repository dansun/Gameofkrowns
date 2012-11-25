package org.hackermongo.gameofkrowns.access.domain.game.counties;

import javax.persistence.Entity;

import org.hackermongo.gameofkrowns.access.domain.game.County;

@Entity
public class Vasternorrland extends County {

	public Vasternorrland() {
		this.countyname = CountyName.VASTERNORRLAND;
	}
	
}
