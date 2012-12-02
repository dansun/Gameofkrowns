package org.hackermongo.gameofkrowns.android.model.events;

import org.hackermongo.gameofkrowns.access.domain.Event;
import org.hackermongo.gameofkrowns.access.domain.EventType;
import org.hackermongo.gameofkrowns.access.domain.events.GameEnded;
import org.hackermongo.gameofkrowns.android.model.EventImpl;
import org.hackermongo.gameofkrowns.android.model.GameImpl;
import org.hackermongo.gameofkrowns.android.model.PlayerImpl;

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
