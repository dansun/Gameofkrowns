package org.hackermongo.gok.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Game {
	private long id;
	private Date createdDate;
	private ArrayList<Player> players;
	private ArrayList<Region> regions;
	private int turnIndex; // this is 0 if game is not started, 1 if first turn is active, etc
	
	public Game() {
		players = new ArrayList<Player>();
		Friend f = new Friend();
		Clan c = new Clan("Lannister");
		Character ch = new Character("Tyrion");
		createdDate = Calendar.getInstance().getTime();
		
		players.add(new Player(f,c,ch));
	}
	
	public Game(ArrayList<Player> players)
	{
		this.players = players; 
		createdDate = Calendar.getInstance().getTime(); // TODO: No,no
	}
	
	public long getId() {
		return id;
	}
	
	public Date getDate() {
		return createdDate;
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public ArrayList<Region> getRegions() {
		return regions;
	}
	
	public int getTurnIndex() {
		return turnIndex;
	}
	
}