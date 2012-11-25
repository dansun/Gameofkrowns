package org.hackermongo.gameofkrowns.access.domain.events;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hackermongo.gameofkrowns.access.domain.Event;
import org.hackermongo.gameofkrowns.access.domain.Player;

/**
 * Event representing end of a game
 */
@Entity
@Table(name = "GAME_FINISHED_EVENT")
@Inheritance(strategy=InheritanceType.JOINED)
@XmlRootElement(name="finished")
public class GameEnded extends Event {

	private static final long serialVersionUID = 1L;

	@OneToOne
	private Player winningPlayer;

	public GameEnded() {
		this.eventType = EventType.GAME_FINISH;
	}
	
	public Player getWinningPlayer() {
		return winningPlayer;
	}

	public void setWinningPlayer(Player winningPlayer) {
		this.winningPlayer = winningPlayer;
	}
	
}
