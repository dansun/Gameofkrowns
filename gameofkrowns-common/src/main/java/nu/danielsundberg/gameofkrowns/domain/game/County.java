package nu.danielsundberg.gameofkrowns.domain.game;

import java.io.Serializable;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="county")
public abstract interface County<GAME, INFLUENCE> extends Serializable {
	
	@XmlAttribute(name="countyid", required=true)
	public Long getCountyid();
	
	public void setCountyid(Long countyid);
	
	public abstract CountyName getCountyname();
	
	public Set<INFLUENCE> getInfluences();

	public void setInfluences(Set<INFLUENCE> influences);

	public GAME getGame();

	public void setGame(GAME game);
	
}
