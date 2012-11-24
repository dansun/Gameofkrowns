package org.hackermongo.gok.model;

public class Player {
	private Friend user;
	private Clan clan;
	private Character character;
	private int finishedTurn; // starts as -1
	
	public Player(Friend f,Clan cl, Character ch) {
		this(f, cl, ch, -1);
	}
	
	public Player(Friend f,Clan cl, Character ch, int turnIndex) {
		user = f;
		clan = cl;
		character = ch;
		finishedTurn = turnIndex;
	}
	
	public Friend getUser() {
		return user;
	}
	
	public Clan getClan() {
		return clan;
	}
	
	public Character getCharacter() {
		return character;
	}
	
	public int getFinishedTurn() {
		return finishedTurn;
	}
}