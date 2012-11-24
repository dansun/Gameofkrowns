package org.hackermongo.gok.model;

public class Friend {
	private String userId;
	private long avatarId;
	private long titleId;
	
	
	public Friend() {
		
	}
	
	public Friend(String userId)
	{
		this.userId = userId;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public long avatarId() {
		return avatarId;
	}
	
	public long titleId() {
		return titleId;
	}
}