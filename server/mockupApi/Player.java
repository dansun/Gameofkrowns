public class Player {
	private Friend user;
	private Clan clan;
	private Character character;
	private int finishedTurn; // starts as -1
	
	public Player(Friend f,int cl, int ch) {
		user = f;
		clan = cl;
		character = ch;
		finishedTurn = -1;
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