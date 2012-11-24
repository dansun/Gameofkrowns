package org.hackermongo.gok.model;

import java.util.ArrayList;
import java.util.Date;

public class Invitation {
	
	private long id;
	private Date date;
	private ArrayList<Invitee> players;
	private boolean allowRandoms;
	
	public Invitation(Date d,ArrayList<Invitee> inv,boolean a) {
		id = 1; // This should be unique and generated
		date = d; // Martin har en date
		players = inv;
		allowRandoms = a;
	}
	
	public long getId() {
		return id;
	}
	
	public Date getDate() {
		return date;
	}
	
	public ArrayList<Invitee> getPlayers() {
		return players;
	}
	
	public boolean getAllowRandoms() {
		return allowRandoms;
	}
}