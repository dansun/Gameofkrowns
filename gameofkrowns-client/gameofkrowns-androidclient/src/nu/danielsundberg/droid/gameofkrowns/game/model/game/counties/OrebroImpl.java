package nu.danielsundberg.droid.gameofkrowns.game.model.game.counties;

import java.util.Set;

import nu.danielsundberg.droid.gameofkrowns.game.engine.GameofkrownsGame;
import nu.danielsundberg.droid.gameofkrowns.game.model.GameImpl;
import nu.danielsundberg.droid.gameofkrowns.game.model.game.CountyImpl;
import nu.danielsundberg.droid.gameofkrowns.game.model.game.InfluenceImpl;
import nu.danielsundberg.gameofkrowns.domain.game.CountyName;
import nu.danielsundberg.gameofkrowns.domain.game.counties.Orebro;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Mesh;

public class OrebroImpl extends CountyImpl implements Orebro<GameImpl,InfluenceImpl> {

	private static final long serialVersionUID = 1L;

	private GameImpl game;
	private Long countyId;
	private Set<InfluenceImpl> influences;

	public Long getCountyid() {
		return this.countyId;
	}

	public CountyName getCountyname() {
		return CountyName.OREBRO;
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

	public OrebroImpl(AssetManager assetmanager) {
		this.countyMesh = assetmanager.get(GameofkrownsGame.OREBRO_MODEL_ASSET, Mesh.class);
	}

}
