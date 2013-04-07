package nu.danielsundberg.droid.gameofkrowns.game.model.moves;

import nu.danielsundberg.droid.gameofkrowns.game.model.GameImpl;
import nu.danielsundberg.droid.gameofkrowns.game.model.MoveImpl;
import nu.danielsundberg.droid.gameofkrowns.game.model.PlayerImpl;
import nu.danielsundberg.droid.gameofkrowns.game.model.events.GameTurnImpl;
import nu.danielsundberg.gameofkrowns.domain.Event;
import nu.danielsundberg.gameofkrowns.domain.events.GameTurn;
import nu.danielsundberg.gameofkrowns.domain.moves.Bribe;

public class BribeImpl extends MoveImpl implements Bribe<PlayerImpl, GameImpl, GameTurnImpl>{

	private static final long serialVersionUID = 1L;

	@Override
	public int compareTo(Event<GameImpl> o) {
		// TODO Auto-generated method stub
		return 0;
	}

    @Override
    public GameTurn<GameImpl> getGameTurn() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setGameTurn(GameTurnImpl gameTurn) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
