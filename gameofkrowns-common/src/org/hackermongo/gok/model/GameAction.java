package org.hackermongo.gok.model;

public class GameAction {
	private long gameId;
	private long regionId;
	private long actionId;
	
	
	public GameAction(long gameId, long regionId, long actionId) {
		setGameId(gameId);
		setRegionId(regionId);
		setActionId(actionId);
	}
	
	public long getGameId() {
		return gameId;
	}
	private void setGameId(long gameId) {
		this.gameId = gameId;
	}
	public long getRegionId() {
		return regionId;
	}
	private void setRegionId(long regionId) {
		this.regionId = regionId;
	}
	public long getActionId() {
		return actionId;
	}
	private void setActionId(long actionId) {
		this.actionId = actionId;
	}

}
