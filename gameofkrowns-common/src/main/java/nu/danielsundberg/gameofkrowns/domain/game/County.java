package nu.danielsundberg.gameofkrowns.domain.game;

import java.io.Serializable;
import java.util.Set;

public abstract interface County<GAME, INFLUENCE> extends Serializable {
	
	public Long getCountyid();
	
	public void setCountyid(Long countyid);
	
	public abstract CountyName getCountyname();
	
	public Set<INFLUENCE> getInfluences();

	public void setInfluences(Set<INFLUENCE> influences);

	public GAME getGame();

}
