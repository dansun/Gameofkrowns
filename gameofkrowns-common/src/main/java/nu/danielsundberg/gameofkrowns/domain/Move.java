package nu.danielsundberg.gameofkrowns.domain;


import nu.danielsundberg.gameofkrowns.domain.events.GameTurn;

/**
 * A Game of Krowns move
 */
public abstract interface Move extends Event {
	
	public Player getPlayer();

	public MoveType getMoveType();

    public GameTurn getGameTurn();

}
