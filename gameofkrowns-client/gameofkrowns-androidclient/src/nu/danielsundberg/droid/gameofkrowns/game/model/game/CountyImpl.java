package nu.danielsundberg.droid.gameofkrowns.game.model.game;

import java.util.HashSet;
import java.util.Set;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector3;

import nu.danielsundberg.droid.gameofkrowns.game.model.GameImpl;
import nu.danielsundberg.gameofkrowns.domain.game.County;
import nu.danielsundberg.gameofkrowns.domain.game.CountyName;


public abstract class CountyImpl extends RenderableCounty implements County<GameImpl, InfluenceImpl> {
	
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

	public final Color getInfluencedColor() {
		//
		// TODO Implement color from influences
		//
		return new Color(0f, 1f, 0f, 1f);
	}
	
	public void disposeMesh() {
		this.countyMesh.dispose();
	}
	
	
	protected Vector3 cameraSelectedPosition = new Vector3(10f, 10f, 4f);
	protected Vector3 cameraSelectedDirection = new Vector3(0f, -7f, -1f);
	
	public void setCameraSelectedDirection(Vector3 cameraSelectedDirection) {}
	
	public Vector3 getCameraSelectedDirection() {
		return cameraSelectedDirection;
	}
	
	public void setCameraSelectedPosition(Vector3 cameraSelectedPosition) {}
	
	public Vector3 getCameraSelectedPosition() {
		return cameraSelectedPosition;
	}
	
}
