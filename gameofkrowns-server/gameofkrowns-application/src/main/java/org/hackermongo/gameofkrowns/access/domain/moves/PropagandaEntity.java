package org.hackermongo.gameofkrowns.access.domain.moves;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hackermongo.gameofkrowns.access.domain.Event;
import org.hackermongo.gameofkrowns.access.domain.GameEntity;
import org.hackermongo.gameofkrowns.access.domain.MoveEntity;
import org.hackermongo.gameofkrowns.access.domain.PlayerEntity;

@Entity
@Table(name="PROPAGANDA")
public class PropagandaEntity extends MoveEntity implements Propaganda<PlayerEntity, GameEntity>{

	private static final long serialVersionUID = 1L;

	@Override
	public int compareTo(Event<GameEntity> o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
