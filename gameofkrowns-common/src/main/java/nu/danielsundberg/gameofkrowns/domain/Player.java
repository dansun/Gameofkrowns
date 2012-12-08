package nu.danielsundberg.gameofkrowns.domain;

import java.io.Serializable;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;


/**
 * Player
 * @author dansun
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public interface Player<GAME> extends Serializable {

	public void setPlayerId(long playerId);
	
	@XmlAttribute(name="playerId", required=true)
	public long getPlayerId();

	public void setPlayerName(String playerName);

	@XmlAttribute(name="playerName", required=true)
	public String getPlayerName();
	
	public String getPassword();

	public void setPassword(String password);

	@XmlAttribute(name="invitedGames", required=true)
	public Set<GAME> getInvitedGames();

	public void setInvitedGames(Set<GAME> invitedGames);

	@XmlAttribute(name="ownedGames", required=true)
	public Set<GAME> getOwnedGames();

	public void setOwnedGames(Set<GAME> ownedGames);

	@XmlAttribute(name="playingGames", required=true)
	public Set<GAME> getPlayingGames();

	public void setPlayingGames(Set<GAME> playingGames);
	
}
