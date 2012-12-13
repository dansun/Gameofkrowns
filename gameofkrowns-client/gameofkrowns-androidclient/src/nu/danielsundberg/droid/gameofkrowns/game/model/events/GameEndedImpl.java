package nu.danielsundberg.droid.gameofkrowns.game.model.events;

import nu.danielsundberg.droid.gameofkrowns.game.model.EventImpl;
import nu.danielsundberg.droid.gameofkrowns.game.model.GameImpl;
import nu.danielsundberg.droid.gameofkrowns.game.model.PlayerImpl;
import nu.danielsundberg.gameofkrowns.domain.Event;
import nu.danielsundberg.gameofkrowns.domain.EventType;
import nu.danielsundberg.gameofkrowns.domain.events.GameEnded;

/**
 * Event representing end of a game
 */
public class GameEndedImpl extends EventImpl implements GameEnded<PlayerImpl, GameImpl> {

	private static final long serialVersionUID = 1L;

	private PlayerImpl winningPlayer;

	public GameEndedImpl() {
		this.eventType = EventType.GAME_FINISH;
	}
	
	public PlayerImpl getWinningPlayer() {
		return winningPlayer;
	}

	public void setWinningPlayer(PlayerImpl winningPlayer) {
		this.winningPlayer = winningPlayer;
	}

	@Override
	public int compareTo(Event<GameImpl> o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
