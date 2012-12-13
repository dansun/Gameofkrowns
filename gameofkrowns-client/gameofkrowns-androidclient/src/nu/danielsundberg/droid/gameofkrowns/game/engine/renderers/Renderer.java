package nu.danielsundberg.droid.gameofkrowns.game.engine.renderers;

import nu.danielsundberg.droid.gameofkrowns.game.model.GameImpl;

public interface Renderer {

	
	public void initLoadingscreen();
	public void renderLoadingscreen(float delta);
	public void disposeLoadingscreen();
	
	public void initGamescreen();
	public void renderGamescreen(GameImpl game, float delta);
	public void disposeGamescreen(GameImpl game);
	
	public void initEndscreen();
	public void renderEndscreen(float delta);
	public void disposeEndscreen();
	
	public void resize(int width, int height);
	
}
