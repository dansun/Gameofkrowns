package nu.danielsundberg.gameofkrowns.access.domain.moves;

import javax.persistence.Entity;
import javax.persistence.Table;

import nu.danielsundberg.gameofkrowns.access.domain.GameEntity;
import nu.danielsundberg.gameofkrowns.access.domain.MoveEntity;
import nu.danielsundberg.gameofkrowns.access.domain.PlayerEntity;
import nu.danielsundberg.gameofkrowns.domain.Event;
import nu.danielsundberg.gameofkrowns.domain.moves.Bribe;

@Entity
@Table(name="BRIBE")
public class BribeEntity extends MoveEntity implements Bribe<PlayerEntity, GameEntity>{

	private static final long serialVersionUID = 1L;

	@Override
	public int compareTo(Event<GameEntity> o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
