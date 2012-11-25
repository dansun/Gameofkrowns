package org.hackermongo.gameofkrowns.access.domain.game.counties;

import javax.persistence.Entity;

import org.hackermongo.gameofkrowns.access.domain.game.County;

@Entity
public class Dalarna extends County {

	public Dalarna() {
		this.countyname = CountyName.DALARNA;
	}
	
}
