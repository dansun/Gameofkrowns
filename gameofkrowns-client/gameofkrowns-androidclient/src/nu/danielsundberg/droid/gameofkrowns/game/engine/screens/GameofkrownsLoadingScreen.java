package nu.danielsundberg.droid.gameofkrowns.game.engine.screens;

import nu.danielsundberg.droid.gameofkrowns.game.engine.GameofkrownsGame;

import android.util.Log;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameofkrownsLoadingScreen implements Screen {

	private NinePatch loadingImage;
	private Mesh logoMesh;
	private PerspectiveCamera camera3D;
	private SpriteBatch batch;
	private OrthographicCamera camera2D;
	private float cubeAngle = 0;

	private GameofkrownsGame game;

	public GameofkrownsLoadingScreen(GameofkrownsGame game) {
		this.game = game;
	}

	public void show() {
		Log.i(this.getClass().getSimpleName(), "Shows loading.");
		//
		// Init 3d camera.
		//
		float aspectRatio = Gdx.graphics.getWidth() / Gdx.graphics.getHeight();
		camera3D = new PerspectiveCamera(67, 2f * aspectRatio, 2f);	
		camera3D.position.set(0, 0, 5);
		camera3D.update();

		//
		// Init 2d camera.
		//
		camera2D = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera2D.update();

		//
		// Get assets from assetmanager, init spritebatch
		//
		loadingImage = new NinePatch(game.getAssetManager().get(GameofkrownsGame.LOADING_SPRITE_ASSET, Texture.class));
		logoMesh = (Mesh) game.getAssetManager().get(GameofkrownsGame.LOGO_MODEL_ASSET, Mesh.class);
		batch = new SpriteBatch(1);
	}

	public void hide() {
		Log.i(this.getClass().getSimpleName(), "Hides loading.");
	}

	public void dispose() {}
	public void resume() {}
	public void pause() {}

	@Override
	public void render(float delta) {
		// Update assetmanager
		if(game.getAssetManager().update()) {
			if(Gdx.input.isTouched()) {
				game.showGameScreen();	
			}
		}
		//
		// Handle GL stuff
		//
		Gdx.gl.glEnable(GL10.GL_DEPTH_TEST);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		Gdx.gl.glClearDepthf(1.0f);           
		Gdx.gl.glEnable(GL10.GL_DEPTH_TEST);  
		Gdx.gl.glDepthFunc(GL10.GL_LEQUAL);   
		Gdx.gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);  
		Gdx.gl.glDisable(GL10.GL_DITHER);     
		Gdx.gl10.glShadeModel(GL10.GL_SMOOTH);

		//
		// Draw mesh
		//
		cubeAngle += Math.sin(delta);
		camera3D.update();
		camera3D.apply(Gdx.gl10);
		Gdx.gl10.glRotatef(cubeAngle, 0, 1, 0);
		Gdx.gl10.glColor4f(1f, 0f, 0f, 1f);
		logoMesh.render(GL10.GL_TRIANGLES);
		

		//
		// Draw sprites
		//
		camera2D.apply(Gdx.gl10);
		batch.setProjectionMatrix(camera2D.combined);
		batch.begin();
		loadingImage.draw(batch, 
				-100, 
				-25, 
				200*game.getAssetManager().getProgress(), 
				50);
		batch.end();
	}

	public void resize(int width, int height) {
		float aspectRatio = width / height;
		camera3D = new PerspectiveCamera(67, 2f * aspectRatio, 2f);	
		camera3D.position.set(0, -10, 5);
	}

}
