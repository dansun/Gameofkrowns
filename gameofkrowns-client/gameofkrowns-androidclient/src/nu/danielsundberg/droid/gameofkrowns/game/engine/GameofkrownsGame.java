package nu.danielsundberg.droid.gameofkrowns.game.engine;

import java.util.HashSet;
import java.util.Set;

import nu.danielsundberg.droid.gameofkrowns.game.engine.loaders.ObjMeshLoader;
import nu.danielsundberg.droid.gameofkrowns.game.engine.renderers.Renderer;
import nu.danielsundberg.droid.gameofkrowns.game.engine.renderers.RendererGL10;
import nu.danielsundberg.droid.gameofkrowns.game.engine.screens.GameofkrownsEndScreen;
import nu.danielsundberg.droid.gameofkrowns.game.engine.screens.GameofkrownsGameScreen;
import nu.danielsundberg.droid.gameofkrowns.game.engine.screens.GameofkrownsLoadingScreen;
import nu.danielsundberg.droid.gameofkrowns.game.model.GameImpl;
import nu.danielsundberg.droid.gameofkrowns.game.model.game.CountyImpl;
import nu.danielsundberg.droid.gameofkrowns.game.model.game.counties.BlekingeImpl;
import nu.danielsundberg.droid.gameofkrowns.game.model.game.counties.DalarnaImpl;
import nu.danielsundberg.droid.gameofkrowns.game.model.game.counties.GavleborgImpl;
import nu.danielsundberg.droid.gameofkrowns.game.model.game.counties.GotlandImpl;
import nu.danielsundberg.droid.gameofkrowns.game.model.game.counties.HallandImpl;
import nu.danielsundberg.droid.gameofkrowns.game.model.game.counties.JamtlandImpl;
import nu.danielsundberg.droid.gameofkrowns.game.model.game.counties.JonkopingImpl;
import nu.danielsundberg.droid.gameofkrowns.game.model.game.counties.KalmarImpl;
import nu.danielsundberg.droid.gameofkrowns.game.model.game.counties.KronobergImpl;
import nu.danielsundberg.droid.gameofkrowns.game.model.game.counties.NorrbottenImpl;
import nu.danielsundberg.droid.gameofkrowns.game.model.game.counties.OrebroImpl;
import nu.danielsundberg.droid.gameofkrowns.game.model.game.counties.OstergotlandImpl;
import nu.danielsundberg.droid.gameofkrowns.game.model.game.counties.SkaneImpl;
import nu.danielsundberg.droid.gameofkrowns.game.model.game.counties.SodermanlandImpl;
import nu.danielsundberg.droid.gameofkrowns.game.model.game.counties.StockholmImpl;
import nu.danielsundberg.droid.gameofkrowns.game.model.game.counties.UppsalaImpl;
import nu.danielsundberg.droid.gameofkrowns.game.model.game.counties.VarmlandImpl;
import nu.danielsundberg.droid.gameofkrowns.game.model.game.counties.VasterbottenImpl;
import nu.danielsundberg.droid.gameofkrowns.game.model.game.counties.VasternorrlandImpl;
import nu.danielsundberg.droid.gameofkrowns.game.model.game.counties.VastmanlandImpl;
import nu.danielsundberg.droid.gameofkrowns.game.model.game.counties.VastraGotalandImpl;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Mesh;

public class GameofkrownsGame extends Game {

	
	
	//
	// Asset constants
	//
	public static final String END_TURN_SOUND_ASSET = "sounds/end_turn.ogg";
	public static final String START_TURN_SOUND_ASSET = "sounds/start_turn.ogg";
	public static final String END_GAME_SOUND_ASSET = "sounds/end_game.ogg";
	
	public static final String LOGO_RING1_MODEL_ASSET = "models/gameofkrown_logo_ring1.obj";
	public static final String LOGO_RING2_MODEL_ASSET = "models/gameofkrown_logo_ring2.obj";
	public static final String LOGO_CROWN1_MODEL_ASSET = "models/gameofkrown_logo_crown1.obj";
	public static final String LOGO_CROWN2_MODEL_ASSET = "models/gameofkrown_logo_crown2.obj";
	public static final String LOGO_CROWN3_MODEL_ASSET = "models/gameofkrown_logo_crown3.obj";
	 
	public static final String BLEKINGE_MODEL_ASSET = "models/gameofkrowns_counties_blekinge.obj";
	public static final String DALARNA_MODEL_ASSET = "models/gameofkrowns_counties_dalarna.obj";
	public static final String GAVLEBORG_MODEL_ASSET = "models/gameofkrowns_counties_gavleborg.obj";
	public static final String GOTLAND_MODEL_ASSET = "models/gameofkrowns_counties_gotland.obj";
	public static final String HALLAND_MODEL_ASSET = "models/gameofkrowns_counties_halland.obj";
	public static final String JAMTLAND_MODEL_ASSET = "models/gameofkrowns_counties_jamtland.obj";
	public static final String JONKOPING_MODEL_ASSET = "models/gameofkrowns_counties_jonkoping.obj";
	public static final String KALMAR_MODEL_ASSET = "models/gameofkrowns_counties_kalmar.obj";
	public static final String KRONOBERG_MODEL_ASSET = "models/gameofkrowns_counties_kronoberg.obj";
	public static final String NORRBOTTEN_MODEL_ASSET = "models/gameofkrowns_counties_norrbotten.obj";
	public static final String OREBRO_MODEL_ASSET = "models/gameofkrowns_counties_orebro.obj";
	public static final String OSTERGOTLAND_MODEL_ASSET = "models/gameofkrowns_counties_ostergotland.obj";
	public static final String SKANE_MODEL_ASSET = "models/gameofkrowns_counties_skane.obj";
	public static final String SODERMANLAND_MODEL_ASSET = "models/gameofkrowns_counties_sodermanland.obj";
	public static final String STOCKHOLM_MODEL_ASSET = "models/gameofkrowns_counties_stockholm.obj";
	public static final String UPPSALA_MODEL_ASSET = "models/gameofkrowns_counties_uppsala.obj";
	public static final String VARMLAND_MODEL_ASSET = "models/gameofkrowns_counties_varmland.obj";
	public static final String VASTERBOTTEN_MODEL_ASSET = "models/gameofkrowns_counties_vasterbotten.obj";
	public static final String VASTERNORRLAND_MODEL_ASSET = "models/gameofkrowns_counties_vasternorrland.obj";
	public static final String VASTMANLAND_MODEL_ASSET = "models/gameofkrowns_counties_vastmanland.obj";
	public static final String VASTRAGOTALAND_MODEL_ASSET = "models/gameofkrowns_counties_vastragotaland.obj";
	
	public static final String LOADING_SPRITE_ASSET = "sprites/loading.png";

	//
	// Screens of game
	//
	private GameofkrownsLoadingScreen loadscreen;
	private GameofkrownsGameScreen gamescreen;
	private GameofkrownsEndScreen endscreen;

	//
	// Managers
	//
	private AssetManager assetmanager;
	private Renderer renderer;
	
	//
	// Current game from server
	//
	private GameImpl serverGame;
	
	public void create() {
		//
		// Init assetmanager
		//
		assetmanager = new AssetManager();
		assetmanager.setLoader(Mesh.class, new ObjMeshLoader(new InternalFileHandleResolver()));
		
		//
		// Select renderer implemenetation.
		//
//		renderer = (Renderer) (Gdx.graphics.isGL20Available()?
//				new RendererGL20(assetmanager):
//					new RendererGL10(assetmanager));

		renderer = new RendererGL10(assetmanager);
		
		//
		// Instansiate screens
		//
		loadscreen = new GameofkrownsLoadingScreen(this, renderer);
		gamescreen = new GameofkrownsGameScreen(this, renderer);
		endscreen = new GameofkrownsEndScreen(this, renderer);
		
		//
		// Show loadingscreen for starters
		//
		showLoadingScreen();
		
	}

	public void dispose() {}

	public void pause() {}

	public void resize(int width, int height) {}

	public void resume() {}

	public AssetManager getAssetManager() {
		return assetmanager;
	}

	public void showLoadingScreen() {
		setScreen(loadscreen);
	}

	public void showGameScreen() {
		//
		// TODO make client update and send stuff to server
		// for now mock a game
		//
		this.serverGame = new GameImpl();
		Set<CountyImpl> counties = new HashSet<CountyImpl>();
		counties.add(new BlekingeImpl(assetmanager));
		counties.add(new DalarnaImpl(assetmanager));
		counties.add(new GavleborgImpl(assetmanager));
		counties.add(new GotlandImpl(assetmanager));
		counties.add(new HallandImpl(assetmanager));
		counties.add(new JamtlandImpl(assetmanager));
		counties.add(new JonkopingImpl(assetmanager));
		counties.add(new KalmarImpl(assetmanager));
		counties.add(new KronobergImpl(assetmanager));
		counties.add(new NorrbottenImpl(assetmanager));
		counties.add(new OrebroImpl(assetmanager));
		counties.add(new OstergotlandImpl(assetmanager));
		counties.add(new SkaneImpl(assetmanager));
		counties.add(new SodermanlandImpl(assetmanager));
		counties.add(new StockholmImpl(assetmanager));
		counties.add(new UppsalaImpl(assetmanager));
		counties.add(new VarmlandImpl(assetmanager));
		counties.add(new VasterbottenImpl(assetmanager));
		counties.add(new VasternorrlandImpl(assetmanager));
		counties.add(new VastmanlandImpl(assetmanager));
		counties.add(new VastraGotalandImpl(assetmanager));
		serverGame.setCounties(counties);
		
		setScreen(gamescreen);
	}

	public void showEndScreen() {
		setScreen(endscreen);
	}
	
	public GameImpl getCurrentServerGame(float delta) {
		return this.serverGame;
	}

}
