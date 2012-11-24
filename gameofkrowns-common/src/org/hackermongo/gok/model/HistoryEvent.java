package org.hackermongo.gok.model;

public class HistoryEvent {
	
	private Friend subject;
	private HistoryAction move;
	private Region region;
	boolean won;
	
	public HistoryEvent(Friend f, HistoryAction ga, Region r, boolean w) {
		subject = f;
		move = ga;
		region = r;
		won = w;
	}
	
	public Friend getSubject() {
		return subject;
	}
	
	public HistoryAction getMove() {
		return move;
	}
	
	public Region getRegion() {
		return region;
	}
	
	public boolean canHasWin() {
		return won;
	}
}