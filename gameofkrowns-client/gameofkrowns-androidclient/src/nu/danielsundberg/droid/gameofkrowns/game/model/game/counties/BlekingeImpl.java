package nu.danielsundberg.droid.gameofkrowns.game.model.game.counties;

import java.util.Set;

import nu.danielsundberg.droid.gameofkrowns.game.engine.GameofkrownsGame;
import nu.danielsundberg.droid.gameofkrowns.game.model.GameImpl;
import nu.danielsundberg.droid.gameofkrowns.game.model.game.CountyImpl;
import nu.danielsundberg.droid.gameofkrowns.game.model.game.InfluenceImpl;
import nu.danielsundberg.gameofkrowns.domain.game.CountyName;
import nu.danielsundberg.gameofkrowns.domain.game.counties.Blekinge;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.math.Vector3;

public class BlekingeImpl extends CountyImpl implements Blekinge<GameImpl, InfluenceImpl>{

	private static final long serialVersionUID = 1L;
	
	protected Vector3 cameraSelectedPosition = new Vector3(3f, 5f, 13f);
	protected Vector3 cameraSelectedDirection = new Vector3(0f, -2f, -1f);
	
	private GameImpl game;
	private Long countyId;
	private Set<InfluenceImpl> influences;
	
	public Long getCountyid() {
		return this.countyId;
	}
	
	public CountyName getCountyname() {
		return CountyName.BLEKINGE;
	}
	
	public GameImpl getGame() {
		return this.game;
	}
	
	public Set<InfluenceImpl> getInfluences() {
		return this.influences;
	}
	
	public void setCountyid(Long arg0) {
		this.countyId = arg0;
	}
	
	public void setGame(GameImpl arg0) {
		this.game = arg0;
	}
	
	public void setInfluences(Set<InfluenceImpl> arg0) {
		this.influences = arg0;
	}
	
	public BlekingeImpl(AssetManager assetmanager) {
		this.countyMesh = assetmanager.get(GameofkrownsGame.BLEKINGE_MODEL_ASSET, Mesh.class);
	}

	public Vector3 getCameraSelectedDirection() {
		return cameraSelectedDirection;
	}
	
	public Vector3 getCameraSelectedPosition() {
		return cameraSelectedPosition;
	}	
	
}
