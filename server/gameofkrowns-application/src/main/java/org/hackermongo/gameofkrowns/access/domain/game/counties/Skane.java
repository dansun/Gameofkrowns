package org.hackermongo.gameofkrowns.access.domain.game.counties;

import javax.persistence.Entity;

import org.hackermongo.gameofkrowns.access.domain.game.County;

@Entity
public class Skane extends County {

	public Skane() {
		this.countyname = CountyName.SKANE;
	}
	
}
