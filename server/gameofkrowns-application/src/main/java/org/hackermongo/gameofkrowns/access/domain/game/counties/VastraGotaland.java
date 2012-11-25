package org.hackermongo.gameofkrowns.access.domain.game.counties;

import javax.persistence.Entity;

import org.hackermongo.gameofkrowns.access.domain.game.County;

@Entity
public class VastraGotaland extends County {

	public VastraGotaland() {
		this.countyname = CountyName.VASTRA_GOTALAND;
	}
	
}
