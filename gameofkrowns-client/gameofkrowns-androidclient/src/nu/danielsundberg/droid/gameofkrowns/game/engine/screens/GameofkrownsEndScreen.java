package nu.danielsundberg.droid.gameofkrowns.game.engine.screens;

import nu.danielsundberg.droid.gameofkrowns.game.engine.GameofkrownsGame;
import nu.danielsundberg.droid.gameofkrowns.game.engine.renderers.Renderer;
import android.util.Log;

import com.badlogic.gdx.Screen;

public class GameofkrownsEndScreen implements Screen {

	//private GameofkrownsGame game;
	private Renderer renderer;
	
	public GameofkrownsEndScreen(GameofkrownsGame game, Renderer renderer) {
		this.renderer = renderer;
	}
	
	public void dispose() {}

	public void show() {
		Log.i(this.getClass().getSimpleName(), "Showing endscreen.");
	}
	
	public void hide() {
		Log.i(this.getClass().getSimpleName(), "Hiding endscreen.");
	}

	public void pause() {}

	public void render(float delta) {
		renderer.renderEndscreen(delta);
	}

	public void resize(int arg0, int arg1) {}

	public void resume() {}

	

}
