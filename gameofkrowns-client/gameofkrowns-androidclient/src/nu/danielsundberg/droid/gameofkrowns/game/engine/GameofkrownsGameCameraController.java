package nu.danielsundberg.droid.gameofkrowns.game.engine;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;

public class GameofkrownsGameCameraController implements GestureListener {
	
	private PerspectiveCamera camera;
	float velX, velY;
	boolean flinging = false;
	float initialScale = 1;

	public GameofkrownsGameCameraController(PerspectiveCamera camera) {
		this.camera = camera;
	}

	public boolean touchDown (float x, float y, int pointer, int button) {
		flinging = false;
		//initialScale = camera.;
		return false;
	}

	public boolean tap (float x, float y, int count, int button) {
		Gdx.app.log("GestureDetectorTest", "tap at " + x + ", " + y + ", count: " + count);
		return false;
	}

	public boolean longPress (float x, float y) {
		Gdx.app.log("GestureDetectorTest", "long press at " + x + ", " + y);
		return false;
	}

	public boolean fling (float velocityX, float velocityY, int button) {
		flinging = true;
		//velX = camera.zoom * velocityX * 0.5f;
		//velY = camera.zoom * velocityY * 0.5f;
		return false;
	}

	public boolean pan (float x, float y, float deltaX, float deltaY) {
		camera.position.add(-deltaX, deltaY, 0);
		return false;
	}

	public boolean zoom (float originalDistance, float currentDistance) {
		//float ratio = originalDistance / currentDistance;
		//camera.zoom = initialScale * ratio;
		return false;
	}

	public boolean pinch (Vector2 initialFirstPointer, Vector2 initialSecondPointer, Vector2 firstPointer, Vector2 secondPointer) {
		return false;
	}

	public void update () {
		if (flinging) {
			velX *= 0.98f;
			velY *= 0.98f;
			camera.position.add(-velX * Gdx.graphics.getDeltaTime(), velY * Gdx.graphics.getDeltaTime(), 0);
			if (Math.abs(velX) < 0.01f) velX = 0;
			if (Math.abs(velY) < 0.01f) velY = 0;
		}
	}
	
}
