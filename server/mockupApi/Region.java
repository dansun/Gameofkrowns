public class Region {
	private int id;
	private String name;
	private ArrayList<int> opinion;
	private int population;
	
	public Region(int i,int p,String n,Player f, ArrayList<int> o) {
		id = i; //Serverside keeps track of these ids
		name = n; //Serverside keeps track of these names
		owner = f;
		opinion = o;
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<int> getOpinion() {
		return opinion;
	}
	
	public int getPopulation() {
		return population;
	}
	
	public void setOwner(Friend f) {
		owner = f;
	}
	
	public void setOpinion(int o) {
		opinion = o;
	}
}