public class Invitation {
	
	private long id;
	private String initiator; // mapped against userId. Problem here!!! When lobbies are merged, problems with displaying names
	private Date date;
	private ArrayList<String> invitees;
	private ArrayList<String> randomInvitees;
	private ArrayList<boolean> rsvp; // This assumes that invitees and randomInvitees can be considered sequential. The indexes are handled that way.
	private boolean allowRandoms;
	
	public Invitation(String i,Date d,ArrayList<String> inv,boolean a) {
		id = 1; // This should be unique and generated
		initiator = i;
		date = d; // Martin har en date
		invitees = inv;
		allowRandoms = a;
		randomInvitees = new ArrayList<String>(); // This will be generated and controlled by backend
		rsvp = new ArrayList<boolean>(); // This will be generated and controlled by backend (true = accepted, false = not answered)
	}
	
	public long getId() {
		return id;
	}
	
	public String getInitiator() {
		return initiator;
	}
	
	public Date getDate() {
		return date;
	}
	
	public ArrayList<String> getInvitees() {
		return invitees;
	}
	
	public ArrayList<boolean> getRsvp() {
		return rsvp;
	}
	
	public boolean getAllowRandoms() {
		return allowRandoms();
	}
}