package nu.danielsundberg.gameofkrowns.domain;


import nu.danielsundberg.gameofkrowns.domain.events.GameTurn;

/**
 * A Game of Krowns move
 *
 * @param <GAME>
 *
 */
public abstract interface Move<PLAYER, GAME, GAMETURN> extends Event<GAME> {
	
	public PLAYER getPlayer();

	public void setPlayer(PLAYER player);
	
	public MoveType getMoveType();
	
	public EventType getEventType();

    public GameTurn<GAME> getGameTurn();

    public void setGameTurn(GAMETURN gameTurn);

}
