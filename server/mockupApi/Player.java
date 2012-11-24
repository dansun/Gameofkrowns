public class Player {
	private Friend user;
	private Clan clan;
	private Character character;
	
	public Player(Friend f,int cl, int ch) {
		user = f;
		clan = cl;
		character = ch;
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
}