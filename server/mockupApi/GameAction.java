public class GameAction {
	
	private unsigned short actionType;
	private String actionMessage;
	private signed short opinionChange;
	private unsigned contentId;
	
	public GameAction(unsigned short actionType, String actionMessage, signed short opinionChange, unsigned contentId) {
		this.actionType = actionType;
		this.actionMessage = actionMessage;
		this.opinionChange = opinionChange;
		this.contentId = contentId;
	}
	
	public getActionType() {
		return actionType;
	}
	
	public getActionMessage() {
		return actionMessage;
	}

	public getOpinionChange() {
		return opinionChange;
	}

	public getOpinionChange() {
		return opinionChange;
	}
}