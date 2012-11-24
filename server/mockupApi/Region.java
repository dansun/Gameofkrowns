public class Region {
	private Friend owner;
	private int opinion;
	
	public Region(Friend f, int o) {
		owner = f;
		opinion = o;
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