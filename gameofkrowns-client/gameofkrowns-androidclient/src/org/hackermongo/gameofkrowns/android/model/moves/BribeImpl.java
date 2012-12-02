package org.hackermongo.gameofkrowns.android.model.moves;

import org.hackermongo.gameofkrowns.access.domain.Event;
import org.hackermongo.gameofkrowns.access.domain.moves.Bribe;
import org.hackermongo.gameofkrowns.android.model.GameImpl;
import org.hackermongo.gameofkrowns.android.model.MoveImpl;
import org.hackermongo.gameofkrowns.android.model.PlayerImpl;

public class BribeImpl extends MoveImpl implements Bribe<PlayerImpl, GameImpl>{

	private static final long serialVersionUID = 1L;

	@Override
	public int compareTo(Event<GameImpl> o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
