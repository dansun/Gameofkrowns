package nu.danielsundberg.gameofkrowns.domain.game;

import java.io.Serializable;
import java.math.BigDecimal;

public interface Influence<PLAYER, COUNTY> extends Serializable {
	
	public Long getInfluenceid();

	public void setInfluenceid(Long influenceid);

	public COUNTY getCounty();

	public void setCounty(COUNTY county);
	
	public BigDecimal getAmount();

	public void setAmount(BigDecimal amount);

	public PLAYER getPlayer();

	public void setPlayer(PLAYER player);

}
