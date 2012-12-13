package nu.danielsundberg.droid.gameofkrowns.game.engine.screens;

import nu.danielsundberg.droid.gameofkrowns.game.engine.GameofkrownsGame;
import nu.danielsundberg.droid.gameofkrowns.game.engine.renderers.Renderer;
import android.util.Log;

import com.badlogic.gdx.Screen;

public class GameofkrownsGameScreen implements Screen {

	private GameofkrownsGame game;
	
	private Renderer renderer;
	
	public GameofkrownsGameScreen(GameofkrownsGame game, Renderer renderer) {
		//
		// Set variables
		//
		this.game = game;
		this.renderer = renderer;
		
	
	}
	
	public void show() {
		Log.i(this.getClass().getSimpleName(), "Shows game.");
		renderer.initGamescreen();
	}
	
	public void dispose() {}

	public void hide() {
		Log.i(this.getClass().getSimpleName(), "Hides game.");
		renderer.disposeGamescreen(game.getCurrentServerGame(0f));
	}

	public void pause() {}

	public void render(float delta) {
		renderer.renderGamescreen(game.getCurrentServerGame(delta), delta);
	}

	public void resize(int width, int height) {
		renderer.resize(width, height);
	}

	public void resume() {}

}
