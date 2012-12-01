package org.hackermongo.gameofkrowns.access.domain.game.counties;

import javax.persistence.Entity;

import org.hackermongo.gameofkrowns.access.domain.GameEntity;
import org.hackermongo.gameofkrowns.access.domain.game.CountyEntity;
import org.hackermongo.gameofkrowns.access.domain.game.CountyName;
import org.hackermongo.gameofkrowns.access.domain.game.InfluenceEntity;

@Entity
public class NorrbottenEntity extends CountyEntity implements Norrbotten<GameEntity, InfluenceEntity> {

	private static final long serialVersionUID = 1L;

	public NorrbottenEntity() {
		this.countyname = CountyName.NORRBOTTEN;
	}

	public CountyName getCountyname() {
		return this.countyname;
	}

}
