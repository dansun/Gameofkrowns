package org.hackermongo.gameofkrowns.access.domain.game.counties;

import javax.persistence.Entity;

import org.hackermongo.gameofkrowns.access.domain.game.County;

@Entity
public class Sodermanland extends County {

	public Sodermanland() {
		this.countyname = CountyName.SODERMANLAND;
	}
	
}
