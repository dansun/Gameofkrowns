package nu.danielsundberg.droid.gameofkrowns.game.model.game;

import java.math.BigDecimal;

import nu.danielsundberg.droid.gameofkrowns.game.model.PlayerImpl;
import nu.danielsundberg.gameofkrowns.domain.game.Influence;

public class InfluenceImpl implements Influence<PlayerImpl, CountyImpl>{
	
	private static final long serialVersionUID = 1L;

    private Long influenceid;
	
	private CountyImpl county;
		
	private PlayerImpl player;
		
	private BigDecimal amount;

	public Long getInfluenceid() {
		return influenceid;
	}

	public void setInfluenceid(Long influenceid) {
		this.influenceid = influenceid;
	}

	public CountyImpl getCounty() {
		return county;
	}

	public void setCounty(CountyImpl county) {
		this.county = county;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public PlayerImpl getPlayer() {
		return player;
	}

	public void setPlayer(PlayerImpl player) {
		this.player = player;
	}

}
