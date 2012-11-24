public class HistoryEvent {
	
	private Friend subject;
	private GameAction move;
	private Region region;
	boolean won;
	
	public HistoryEvent(Friend f, GameAction ga, Region r, boolean w) {
		subject = f;
		move = ga;
		region = r;
		won = w;
	}
	
	public Friend getSubject() {
		return subject;
	}
	
	public GameAction getMove() {
		return move;
	}
	
	public Region getRegion() {
		return region;
	}
	
	public boolean canHasWin() {
		return won;
	}
}