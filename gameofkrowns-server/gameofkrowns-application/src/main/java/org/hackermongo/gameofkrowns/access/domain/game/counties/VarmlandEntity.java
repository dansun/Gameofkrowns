package org.hackermongo.gameofkrowns.access.domain.game.counties;

import javax.persistence.Entity;

import org.hackermongo.gameofkrowns.access.domain.GameEntity;
import org.hackermongo.gameofkrowns.access.domain.game.CountyEntity;
import org.hackermongo.gameofkrowns.access.domain.game.CountyName;
import org.hackermongo.gameofkrowns.access.domain.game.InfluenceEntity;

@Entity
public class VarmlandEntity extends CountyEntity implements Varmland<GameEntity, InfluenceEntity> {

	private static final long serialVersionUID = 1L;

	public VarmlandEntity() {
		this.countyname = CountyName.VARMLAND;
	}

	public CountyName getCountyname() {
		return this.countyname;
	}
	
}
