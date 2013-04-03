package nu.danielsundberg.gameofkrowns.domain;

import nu.danielsundberg.gameofkrowns.domain.events.GameTurn;
import org.joda.time.DateTime;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Set;
import java.util.SortedSet;

/**
 * A Game of Krowns
 */
@XmlRootElement(name = "game")
@XmlAccessorType(XmlAccessType.NONE)
public interface Game<PLAYER, EVENT, COUNTY> extends Serializable {

	public void setGameId(long gameId);

    @XmlElement
	public Long getGameId();

    @XmlElement
	public String getGameName();

    public void setGameName(String gameName);

    @XmlElement
	public GameState getGameState();

    @XmlElement
	public DateTime getRegistrationTime();

    @XmlElement
	public PLAYER getOwner();

    @XmlElement
	public Set<PLAYER> getInvitedPlayers();

    @XmlElement
	public Set<PLAYER> getPlayers();

    @XmlElement
	public SortedSet<EVENT> getEvents();

    @XmlElement
	public Set<COUNTY> getCounties();

    @XmlElement
    public GameTurn getCurrentGameTurn();

}
