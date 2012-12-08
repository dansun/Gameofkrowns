package nu.danielsundberg.droid.gameofkrowns.game.engine;

import nu.danielsundberg.droid.gameofkrowns.game.engine.loaders.ObjMeshLoader;
import nu.danielsundberg.droid.gameofkrowns.game.engine.screens.GameofkrownsEndScreen;
import nu.danielsundberg.droid.gameofkrowns.game.engine.screens.GameofkrownsGameScreen;
import nu.danielsundberg.droid.gameofkrowns.game.engine.screens.GameofkrownsLoadingScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Texture;

public class GameofkrownsGame extends Game {

	//
	// Asset constants
	//
	public static final String END_TURN_SOUND_ASSET = "sounds/end_turn.ogg";
	public static final String START_TURN_SOUND_ASSET = "sounds/start_turn.ogg";
	public static final String END_GAME_SOUND_ASSET = "sounds/end_game.ogg";
	public static final String LOGO_MODEL_ASSET = "models/gameofkrowns_logo.obj";
	public static final String SWEDEN_MODEL_ASSET = "models/gameofkrowns_counties.obj";
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
	
	public void create() {
		//
		// Instanciate screens
		//
		loadscreen = new GameofkrownsLoadingScreen(this);
		gamescreen = new GameofkrownsGameScreen(this);
		endscreen = new GameofkrownsEndScreen(this);

		//
		// Init, configure and queue assetloading for assetmanager
		//
		assetmanager = new AssetManager();
		assetmanager.setLoader(Mesh.class, new ObjMeshLoader(new InternalFileHandleResolver()));
		assetmanager.load(LOADING_SPRITE_ASSET, Texture.class);
		assetmanager.load(LOGO_MODEL_ASSET, Mesh.class);
		assetmanager.finishLoading();
		assetmanager.load(SWEDEN_MODEL_ASSET, Mesh.class);
		assetmanager.load(END_GAME_SOUND_ASSET, Sound.class);
		assetmanager.load(END_TURN_SOUND_ASSET, Sound.class);
		assetmanager.load(START_TURN_SOUND_ASSET, Sound.class);
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
		setScreen(gamescreen);
	}

	public void showEndScreen() {
		setScreen(endscreen);
	}

}
