package nu.danielsundberg.droid.gameofkrowns.game.engine.screens;

import nu.danielsundberg.droid.gameofkrowns.game.engine.GameofkrownsGame;

import android.util.Log;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;

public class GameofkrownsGameScreen implements Screen {

	private GameofkrownsGame game;
	
	private Mesh swedenObject;	
//	private GestureDetector gestureDetector;
//	private GameofkrownsGameCameraController controller;
//	private PerspectiveCamera camera;
//	
//	private final Matrix4 matrix = new Matrix4();
	
	public GameofkrownsGameScreen(GameofkrownsGame game) {
		this.game = game;
	}
	
	public void show() {
		
		Log.i(this.getClass().getSimpleName(), "Shows game.");
		
		//
		// Get mesh from assetmanager
		//
		if (swedenObject == null) {
			if(game.getAssetManager().isLoaded(GameofkrownsGame.SWEDEN_MODEL_ASSET)) {
				swedenObject = game.getAssetManager().get(GameofkrownsGame.SWEDEN_MODEL_ASSET, Mesh.class);
			} else {
				game.getAssetManager().finishLoading();
				swedenObject = game.getAssetManager().get(GameofkrownsGame.SWEDEN_MODEL_ASSET, Mesh.class);
			}
		}
		//
		// Calculate aspectratio and initialize camera and camcontroll
		//
//		float aspectRatio = Gdx.graphics.getWidth() / Gdx.graphics.getHeight();
//		camera = new PerspectiveCamera(67, 2f * aspectRatio, 2f);			
//		camera.position.set(5, 5, 10);
//		camera.direction.set(-1, -1, -1);
//		camera.near = 1;
//		camera.far = 100;		
//		matrix.setToRotation(new Vector3(1, 0, 0), 90);
//		controller = new GameofkrownsGameCameraController(camera);
//		gestureDetector = new GestureDetector(20, 0.5f, 2, 0.15f, controller);
//		Gdx.input.setInputProcessor(gestureDetector);
	}
	
	public void dispose() {}

	public void hide() {
		
		Log.i(this.getClass().getSimpleName(), "Hides game.");
	
	}

	public void pause() {}

	public void render(float delta) {
		//
		// Handle GL stuff
		//
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		//
		// Update camera
		//
//		controller.update();
//		camera.update();
//		camera.apply(Gdx.gl10);
		//
		// Render meshes
		//
		swedenObject.render(GL10.GL_TRIANGLES);		
	}

	public void resize(int width, int height) {
		//
		// Recalculate aspectratio for camera and make new cam
		//
//		float aspectRatio = (float) width / (float) height;
//		camera = new PerspectiveCamera(67, 2f * aspectRatio, 2f);
	}

	public void resume() {}

}
