public class Game {
	private long id;
	private Date createdDate;
	private ArrayList<Player> players;
	private ArrayList<Region> regions;
	private int turnIndex; // this is 0 if game is not started, 1 if first turn is active, etc
	
	public Game() {
		
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