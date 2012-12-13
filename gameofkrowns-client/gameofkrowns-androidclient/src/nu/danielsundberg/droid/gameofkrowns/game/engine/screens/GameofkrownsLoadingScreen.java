package nu.danielsundberg.droid.gameofkrowns.game.engine.screens;

import nu.danielsundberg.droid.gameofkrowns.game.engine.GameofkrownsGame;
import nu.danielsundberg.droid.gameofkrowns.game.engine.renderers.Renderer;
import android.util.Log;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Texture;

public class GameofkrownsLoadingScreen implements Screen {

	
	private Renderer renderer;

	
	//
	// Game variables
	//
	private GameofkrownsGame game;

	public GameofkrownsLoadingScreen(GameofkrownsGame game, Renderer renderer) {
		this.game = game;
		this.renderer = renderer;
		
		game.getAssetManager().load(GameofkrownsGame.LOGO_RING1_MODEL_ASSET, Mesh.class);
		game.getAssetManager().load(GameofkrownsGame.LOGO_RING2_MODEL_ASSET, Mesh.class);
		game.getAssetManager().load(GameofkrownsGame.LOGO_CROWN1_MODEL_ASSET, Mesh.class);
		game.getAssetManager().load(GameofkrownsGame.LOGO_CROWN2_MODEL_ASSET, Mesh.class);
		game.getAssetManager().load(GameofkrownsGame.LOGO_CROWN3_MODEL_ASSET, Mesh.class);
		game.getAssetManager().load(GameofkrownsGame.LOADING_SPRITE_ASSET, Texture.class);
		game.getAssetManager().finishLoading();
		//
		// Queue assets needed for other screens
		//
		game.getAssetManager().load(GameofkrownsGame.BLEKINGE_MODEL_ASSET, Mesh.class);
		game.getAssetManager().load(GameofkrownsGame.DALARNA_MODEL_ASSET, Mesh.class);
		game.getAssetManager().load(GameofkrownsGame.GAVLEBORG_MODEL_ASSET, Mesh.class);
		game.getAssetManager().load(GameofkrownsGame.GOTLAND_MODEL_ASSET, Mesh.class);
		game.getAssetManager().load(GameofkrownsGame.HALLAND_MODEL_ASSET, Mesh.class);
		game.getAssetManager().load(GameofkrownsGame.JAMTLAND_MODEL_ASSET, Mesh.class);
		game.getAssetManager().load(GameofkrownsGame.JONKOPING_MODEL_ASSET, Mesh.class);
		game.getAssetManager().load(GameofkrownsGame.KALMAR_MODEL_ASSET, Mesh.class);
		game.getAssetManager().load(GameofkrownsGame.KRONOBERG_MODEL_ASSET, Mesh.class);
		game.getAssetManager().load(GameofkrownsGame.NORRBOTTEN_MODEL_ASSET, Mesh.class);
		game.getAssetManager().load(GameofkrownsGame.OREBRO_MODEL_ASSET, Mesh.class);
		game.getAssetManager().load(GameofkrownsGame.OSTERGOTLAND_MODEL_ASSET, Mesh.class);
		game.getAssetManager().load(GameofkrownsGame.SKANE_MODEL_ASSET, Mesh.class);
		game.getAssetManager().load(GameofkrownsGame.SODERMANLAND_MODEL_ASSET, Mesh.class);
		game.getAssetManager().load(GameofkrownsGame.STOCKHOLM_MODEL_ASSET, Mesh.class);
		game.getAssetManager().load(GameofkrownsGame.UPPSALA_MODEL_ASSET, Mesh.class);
		game.getAssetManager().load(GameofkrownsGame.VARMLAND_MODEL_ASSET, Mesh.class);
		game.getAssetManager().load(GameofkrownsGame.VASTERBOTTEN_MODEL_ASSET, Mesh.class);
		game.getAssetManager().load(GameofkrownsGame.VASTERNORRLAND_MODEL_ASSET, Mesh.class);
		game.getAssetManager().load(GameofkrownsGame.VASTMANLAND_MODEL_ASSET, Mesh.class);
		game.getAssetManager().load(GameofkrownsGame.VASTRAGOTALAND_MODEL_ASSET, Mesh.class);
		game.getAssetManager().load(GameofkrownsGame.END_GAME_SOUND_ASSET, Sound.class);
		game.getAssetManager().load(GameofkrownsGame.END_TURN_SOUND_ASSET, Sound.class);
		game.getAssetManager().load(GameofkrownsGame.START_TURN_SOUND_ASSET, Sound.class);
	}

	public void show() {
		Log.i(this.getClass().getSimpleName(), "Shows loading.");
		renderer.initLoadingscreen();
	}

	public void hide() {
		Log.i(this.getClass().getSimpleName(), "Hides loading.");
		renderer.disposeLoadingscreen();
	}
	
	public void dispose() {}
	public void resume() {}
	public void pause() {}

	@Override
	public void render(float delta) {
		//
		// Update assetmanager
		//
		if(game.getAssetManager().update()
				&& Gdx.input.isTouched()) {
			game.showGameScreen();	
		}
		renderer.renderLoadingscreen(delta);
		
	}

	public void resize(int width, int height) {
		renderer.resize(width, height);
	}

}
