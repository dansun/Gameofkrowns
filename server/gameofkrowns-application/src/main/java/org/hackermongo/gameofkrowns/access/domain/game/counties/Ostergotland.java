package org.hackermongo.gameofkrowns.access.domain.game.counties;

import javax.persistence.Entity;

import org.hackermongo.gameofkrowns.access.domain.game.County;

@Entity
public class Ostergotland extends County {

	public Ostergotland() {
		this.countyname = CountyName.OSTERGOTLAND;
	}
	
}