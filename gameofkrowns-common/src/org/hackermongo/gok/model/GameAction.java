package org.hackermongo.gok.model;

public class GameAction {
	
	private int actionType;
	private String actionMessage;
	private int opinionChange;
	private int contentId;
	
	public GameAction(int actionType, String actionMessage, int opinionChange, int contentId) {
		this.actionType = actionType;
		this.actionMessage = actionMessage;
		this.opinionChange = opinionChange;
		this.contentId = contentId;
	}
	
	public int getActionType() {
		return actionType;
	}
	
	public String getActionMessage() {
		return actionMessage;
	}

	public int getOpinionChange() {
		return opinionChange;
	}

	public int getContentId() {
		return contentId;
	}
}