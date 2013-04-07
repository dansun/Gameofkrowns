package nu.danielsundberg.gameofkrowns.domain.game;

import nu.danielsundberg.gameofkrowns.domain.Player;

import java.io.Serializable;
import java.math.BigDecimal;

public interface Influence extends Serializable {

	public Long getInfluenceId();

	public County getCounty();

	public BigDecimal getAmount();

	public Player getPlayer();

}
