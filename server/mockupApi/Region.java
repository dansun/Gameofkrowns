public class Region {
	private int id;
	private String name;
	private Friend owner;
	private int opinion;
	
	public Region(int i,String n,Friend f, int o) {
		id = i; //Serverside keeps track of these ids
		name = n; //Serverside keeps track of these names
		owner = f;
		opinion = o;
	}
	
	public String getName() {
		return name;
	}
	
	public Friend getOwner() {
		return owner;
	}
	
	public int getOpinion() {
		return opinion;
	}
	
	public void setOwner(Friend f) {
		owner = f;
	}
	
	public void setOpinion(int o) {
		opinion = o;
	}
}