package nu.danielsundberg.gameofkrowns.domain.game;

import java.io.Serializable;
import java.util.Set;

public abstract interface County extends Serializable {
	
	public Long getCountyId();

	public abstract CountyName getCountyname();
	
	public Set<Influence> getInfluences();

	public Long getGameId();

}
