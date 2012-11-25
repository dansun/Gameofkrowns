package org.hackermongo.gameofkrowns.model;

public class Invitee extends Friend {
	private boolean accepted;
	
	public Invitee() {
		
	}
	
	public boolean isAccepted() {
		return accepted;
	}
	
	public void setAccepted() {
		accepted = true;
	}
	
}