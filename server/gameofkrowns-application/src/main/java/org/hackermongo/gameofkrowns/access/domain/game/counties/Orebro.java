package org.hackermongo.gameofkrowns.access.domain.game.counties;

import javax.persistence.Entity;

import org.hackermongo.gameofkrowns.access.domain.game.County;

@Entity
public class Orebro extends County {

	public Orebro() {
		this.countyname = CountyName.OREBRO;
	}
	
}