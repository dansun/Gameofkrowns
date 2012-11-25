package org.hackermongo.gameofkrowns.access.domain.game.counties;

import javax.persistence.Entity;

import org.hackermongo.gameofkrowns.access.domain.game.County;

@Entity
public class Blekinge extends County {

	public Blekinge() {
		this.countyname = CountyName.BELKINGE;
	}

}
