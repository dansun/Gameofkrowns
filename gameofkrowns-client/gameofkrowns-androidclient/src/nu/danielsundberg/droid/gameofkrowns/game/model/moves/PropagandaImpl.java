package nu.danielsundberg.droid.gameofkrowns.game.model.moves;

import nu.danielsundberg.droid.gameofkrowns.game.model.GameImpl;
import nu.danielsundberg.droid.gameofkrowns.game.model.MoveImpl;
import nu.danielsundberg.droid.gameofkrowns.game.model.PlayerImpl;
import nu.danielsundberg.gameofkrowns.domain.Event;
import nu.danielsundberg.gameofkrowns.domain.moves.Propaganda;

public class PropagandaImpl extends MoveImpl implements Propaganda<PlayerImpl, GameImpl>{

	private static final long serialVersionUID = 1L;

	@Override
	public int compareTo(Event<GameImpl> o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
