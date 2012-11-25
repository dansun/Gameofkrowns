package org.hackermongo.gameofkrowns.access.domain.game.counties;

import javax.persistence.Entity;

import org.hackermongo.gameofkrowns.access.domain.game.County;

@Entity
public class Varmland extends County {

	public Varmland() {
		this.countyname = CountyName.VARMLAND;
	}
	
}
