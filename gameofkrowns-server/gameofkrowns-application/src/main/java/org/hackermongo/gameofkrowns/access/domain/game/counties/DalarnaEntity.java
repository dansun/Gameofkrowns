package org.hackermongo.gameofkrowns.access.domain.game.counties;

import javax.persistence.Entity;

import org.hackermongo.gameofkrowns.access.domain.GameEntity;
import org.hackermongo.gameofkrowns.access.domain.game.CountyEntity;
import org.hackermongo.gameofkrowns.access.domain.game.CountyName;
import org.hackermongo.gameofkrowns.access.domain.game.InfluenceEntity;

@Entity
public class DalarnaEntity extends CountyEntity implements Dalarna<GameEntity, InfluenceEntity> {
	
	private static final long serialVersionUID = 1L;

	public DalarnaEntity() {
		this.countyname = CountyName.DALARNA;
	}

	public CountyName getCountyname() {
		return this.countyname;
	}
	
}
