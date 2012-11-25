package org.hackermongo.gameofkrowns.access.domain.game.counties;

import javax.persistence.Entity;

import org.hackermongo.gameofkrowns.access.domain.game.County;

@Entity
public class Jonkoping extends County {

	public Jonkoping() {
		this.countyname = CountyName.JONKOPING;
	}

}
