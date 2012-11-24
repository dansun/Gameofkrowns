package org.hackermongo.gok.model;

import java.util.Date;
import java.util.ArrayList;

public class ActiveGame {
	private Date startedDate;
	private ArrayList<String> players;
	private boolean yourTurn;
	
	
	public ActiveGame(Date d,ArrayList<String> p, boolean t) {
		startedDate = d;
		players = p;
		yourTurn = t;		
	}
	
	public Date getStartedDate() {
		return startedDate;
	}
	
	public ArrayList<String> getPlayers() {
		return players;
	}
	
	public boolean isYourTurn() {
		return yourTurn;
	}
}