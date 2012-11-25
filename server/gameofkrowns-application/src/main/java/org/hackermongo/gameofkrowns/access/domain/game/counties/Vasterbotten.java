package org.hackermongo.gameofkrowns.access.domain.game.counties;

import javax.persistence.Entity;

import org.hackermongo.gameofkrowns.access.domain.game.County;

@Entity
public class Vasterbotten extends County {

	public Vasterbotten() {
		this.countyname = CountyName.VASTERBOTTEN;
	}
	
}