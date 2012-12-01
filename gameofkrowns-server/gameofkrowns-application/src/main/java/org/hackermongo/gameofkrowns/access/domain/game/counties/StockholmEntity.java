package org.hackermongo.gameofkrowns.access.domain.game.counties;

import javax.persistence.Entity;

import org.hackermongo.gameofkrowns.access.domain.GameEntity;
import org.hackermongo.gameofkrowns.access.domain.game.CountyEntity;
import org.hackermongo.gameofkrowns.access.domain.game.CountyName;
import org.hackermongo.gameofkrowns.access.domain.game.InfluenceEntity;

@Entity
public class StockholmEntity extends CountyEntity implements Stockholm<GameEntity, InfluenceEntity> {

	private static final long serialVersionUID = 1L;

	public StockholmEntity() {
		this.countyname = CountyName.STOCKHOLM;
	}
	public CountyName getCountyname() {
		return this.countyname;
	}
	
}
