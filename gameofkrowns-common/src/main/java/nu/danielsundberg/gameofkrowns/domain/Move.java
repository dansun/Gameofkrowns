package nu.danielsundberg.gameofkrowns.domain;




/**
 * A game of krowns move
 * 
 * @author dansun
 * @param <GAME>
 *
 */
public abstract interface Move<PLAYER, GAME> extends Event<GAME> {
	
	public PLAYER getPlayer();

	public void setPlayer(PLAYER player);
	
	public MoveType getMoveType();
	
	public EventType getEventType();
	

}
