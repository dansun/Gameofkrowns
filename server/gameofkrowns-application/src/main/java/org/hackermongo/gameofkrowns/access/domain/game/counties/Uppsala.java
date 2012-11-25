package org.hackermongo.gameofkrowns.access.domain.game.counties;

import javax.persistence.Entity;

import org.hackermongo.gameofkrowns.access.domain.game.County;

@Entity
public class Uppsala extends County {

	public Uppsala() {
		this.countyname = CountyName.UPPSALA;
	}
	
}
