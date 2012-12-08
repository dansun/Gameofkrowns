package nu.danielsundberg.droid.gameofkrowns.game.model.game;

import java.util.HashSet;
import java.util.Set;

import nu.danielsundberg.droid.gameofkrowns.game.model.GameImpl;

import nu.danielsundberg.gameofkrowns.access.domain.game.County;
import nu.danielsundberg.gameofkrowns.access.domain.game.CountyName;


public abstract class CountyImpl implements County<GameImpl, InfluenceImpl> {
	
	private static final long serialVersionUID = 1L;

    private Long countyid;
	
	protected CountyName countyname;
	
	private Set<InfluenceImpl> influences = new HashSet<InfluenceImpl>();
	
	private GameImpl game;

	public Long getCountyid() {
		return countyid;
	}

	public void setCountyid(Long countyid) {
		this.countyid = countyid;
	}
	
	public Set<InfluenceImpl> getInfluences() {
		return influences;
	}

	public void setInfluences(Set<InfluenceImpl> influences) {
		this.influences = influences;
	}

	public GameImpl getGame() {
		return game;
	}

	public void setGame(GameImpl game) {
		this.game = game;
	}

}
