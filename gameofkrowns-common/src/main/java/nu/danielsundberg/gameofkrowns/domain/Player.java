package nu.danielsundberg.gameofkrowns.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Set;

/**
 * Player
 */
@XmlRootElement(name = "player")
@XmlAccessorType(XmlAccessType.NONE)
public interface Player<GAME> extends Serializable {

	public void setPlayerId(long playerId);

    @XmlElement
	public long getPlayerId();

	public void setPlayerName(String playerName);

    @XmlElement
	public String getPlayerName();
	
	public String getPassword();

	public void setPassword(String password);

	public Set<GAME> getInvitedGames();

	public Set<GAME> getOwnedGames();

	public Set<GAME> getPlayingGames();

}
