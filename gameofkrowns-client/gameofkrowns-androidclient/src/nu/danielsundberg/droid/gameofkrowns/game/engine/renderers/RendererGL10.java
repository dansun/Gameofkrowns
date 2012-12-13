package nu.danielsundberg.droid.gameofkrowns.game.engine.renderers;

import nu.danielsundberg.droid.gameofkrowns.game.engine.GameofkrownsGame;
import nu.danielsundberg.droid.gameofkrowns.game.model.GameImpl;
import nu.danielsundberg.droid.gameofkrowns.game.model.game.CountyImpl;
import nu.danielsundberg.gameofkrowns.domain.game.CountyName;
import android.util.Log;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.Ray;

public class RendererGL10 implements Renderer {

	private AssetManager assetmanager;

	//
	// Cameras
	//
	private PerspectiveCamera perspectiveCamera;
	private OrthographicCamera orthographicCamera;

	//
	// 2D/3D objects
	//
	private Mesh gameofkrownsLogoRing1;
	private Mesh gameofkrownsLogoRing2;
	private Mesh gameofkrownsLogoCrown1;
	private Mesh gameofkrownsLogoCrown2;
	private Mesh gameofkrownsLogoCrown3;

	private NinePatch loadingImage;
	private SpriteBatch loadingscreenSpriteBatch;

//	private Sound endTurnSound;
//	private Sound startTurnSound;


	// 3D variables
	//
	float[] lightColor = {1, 1, 1, 0};
	float[] lightPosition = {2, 5, 10, 0};
	float[] direction = {1, 0.5f, 0, 0};

	public RendererGL10(AssetManager assetmanager) {
		this.assetmanager = assetmanager;
		
		//
		// Init 3d camera.
		//
		perspectiveCamera =  new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		perspectiveCamera.far = 100;
		perspectiveCamera.near = -0.1f;
		perspectiveCamera.update();

		//
		// Init 2d camera.
		//
		orthographicCamera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		orthographicCamera.update();
	}

	public void initLoadingscreen() {


		//
		// Get assets from assetmanager, init spritebatch
		//
		loadingImage = new NinePatch(assetmanager.get(GameofkrownsGame.LOADING_SPRITE_ASSET, Texture.class));
		gameofkrownsLogoCrown1 = assetmanager.get(GameofkrownsGame.LOGO_CROWN1_MODEL_ASSET, Mesh.class);
		gameofkrownsLogoCrown2 = assetmanager.get(GameofkrownsGame.LOGO_CROWN2_MODEL_ASSET, Mesh.class);
		gameofkrownsLogoCrown3 = assetmanager.get(GameofkrownsGame.LOGO_CROWN3_MODEL_ASSET, Mesh.class);
		gameofkrownsLogoRing1 = assetmanager.get(GameofkrownsGame.LOGO_RING1_MODEL_ASSET, Mesh.class);
		gameofkrownsLogoRing2 = assetmanager.get(GameofkrownsGame.LOGO_RING2_MODEL_ASSET, Mesh.class);
		loadingscreenSpriteBatch = new SpriteBatch(1);
	}

	public void renderLoadingscreen(float delta) {
		GL10 gl = Gdx.graphics.getGL10();

		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		gl.glDisable(GL10.GL_DITHER);
		gl.glEnable(GL10.GL_DEPTH_TEST);
//		gl.glEnable(GL10.GL_CULL_FACE);

		perspectiveCamera.position.set(0, 0, 6);
		perspectiveCamera.update();
		perspectiveCamera.apply(gl);

		gl.glEnable(GL10.GL_LIGHTING);
		gl.glEnable(GL10.GL_LIGHT0);
		gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_POSITION, direction, 0);
		gl.glEnable(GL10.GL_COLOR_MATERIAL);
		gl.glPushMatrix();
		
		gl.glRotatef(assetmanager.getProgress(), 0, 1, 0);
		
		gl.glColor4f(1f, 1f, 0f, 1f);
		gameofkrownsLogoCrown1.render(GL10.GL_TRIANGLES);
		gl.glColor4f(1f, 1f, 0f, 1f);
		gameofkrownsLogoCrown2.render(GL10.GL_TRIANGLES);
		gl.glColor4f(1f, 1f, 0f, 1f);
		gameofkrownsLogoCrown3.render(GL10.GL_TRIANGLES);
		gl.glColor4f(1f, 1f, 0f, 0.7f);
		gameofkrownsLogoRing1.render(GL10.GL_TRIANGLES);
		gl.glColor4f(0f, 0.2f, 1f, 1f);
		gameofkrownsLogoRing2.render(GL10.GL_TRIANGLES);
		gl.glPopMatrix();

		//
		// Draw sprites
		//
		orthographicCamera.update();
		orthographicCamera.apply(gl);
		loadingscreenSpriteBatch.setProjectionMatrix(orthographicCamera.combined);
		loadingscreenSpriteBatch.begin();
		loadingImage.draw(loadingscreenSpriteBatch, 
				-50, 
				-25, 
				100*assetmanager.getProgress(), 
				50);
		loadingscreenSpriteBatch.end();

	}

	public void disposeLoadingscreen() {
//		loadingscreenSpriteBatch.dispose();
//		loadingImage.getTexture().dispose();
//		gameofkrownsLogoCrown1.dispose();
//		gameofkrownsLogoCrown2.dispose();
//		gameofkrownsLogoCrown3.dispose();
//		gameofkrownsLogoRing1.dispose();
//		gameofkrownsLogoRing2.dispose();
	}

	@Override
	public void initGamescreen() {
		//
		// Get assets from manager.
		//
//		this.endTurnSound = assetmanager.get(GameofkrownsGame.END_TURN_SOUND_ASSET, Sound.class);
//		this.startTurnSound = assetmanager.get(GameofkrownsGame.START_TURN_SOUND_ASSET, Sound.class);

	}

	private CountyName selectedCounty = null;
	private Vector3 cameraUnselectedPosition = new Vector3(15f, 20f, 4f);
	private Vector3 cameraUnselectedDirection = new Vector3(0f, -8f, -1f);
	
	private Vector3 cameraCurrentPosition = new Vector3(15f, 20f, 4f);
	private Vector3 cameraCurrentDirection = new Vector3(0f, -8f, -1f);
	
	private Color countySelectedColor = new Color(0f,0f,0f,0.5f);
	private Color countyUnselectedColor = new Color(1f,1f,1f,0.5f);
		
	
	
	public void renderGamescreen(GameImpl game, float delta) {
		//
		// Handle input
		//
		if(Gdx.input.isTouched()) {
			Ray charles = perspectiveCamera.getPickRay(Gdx.input.getX(), Gdx.input.getY());
			for(CountyImpl county : game.getCounties()) {
				if(county.isRenderable() && Intersector.intersectRayBoundsFast(charles, county.getCountyMesh().calculateBoundingBox())) {
					Log.i(this.getClass().getSimpleName(), "Selected county '"+county.getCountyname()+"'.");
					if(county.getCountyname().equals(selectedCounty)) {
						selectedCounty = null;
					} else {
						selectedCounty = county.getCountyname();
					}
				}
			}
		}

		GL10 gl = Gdx.graphics.getGL10();

		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		gl.glDisable(GL10.GL_DITHER);
		gl.glEnable(GL10.GL_DEPTH_TEST);
//		gl.glEnable(GL10.GL_CULL_FACE);

		//
		// Handle camera
		//
		if(selectedCounty!=null) {
			CountyImpl foundCountyImpl = null;
			for(CountyImpl county : game.getCounties()) {
				if(county.getCountyname().equals(selectedCounty)) {
					foundCountyImpl = county;
					continue;
				}
			}
			if(foundCountyImpl!=null) {
				cameraCurrentPosition.x = Interpolation.linear.apply(cameraCurrentPosition.x, foundCountyImpl.getCameraSelectedPosition().x, delta);
				cameraCurrentPosition.y = Interpolation.linear.apply(cameraCurrentPosition.y, foundCountyImpl.getCameraSelectedPosition().y, delta);
				cameraCurrentPosition.z = Interpolation.linear.apply(cameraCurrentPosition.z, foundCountyImpl.getCameraSelectedPosition().z, delta);
				cameraCurrentDirection.x = Interpolation.linear.apply(cameraCurrentDirection.x, foundCountyImpl.getCameraSelectedDirection().x, delta);
				cameraCurrentDirection.y = Interpolation.linear.apply(cameraCurrentDirection.y, foundCountyImpl.getCameraSelectedDirection().y, delta);
				cameraCurrentDirection.z = Interpolation.linear.apply(cameraCurrentDirection.z, foundCountyImpl.getCameraSelectedDirection().z, delta);	
			}
		} else {
			cameraCurrentPosition.x = Interpolation.linear.apply(cameraCurrentPosition.x, cameraUnselectedPosition.x, delta);
			cameraCurrentPosition.y = Interpolation.linear.apply(cameraCurrentPosition.y, cameraUnselectedPosition.y, delta);
			cameraCurrentPosition.z = Interpolation.linear.apply(cameraCurrentPosition.z, cameraUnselectedPosition.z, delta);
			cameraCurrentDirection.x = Interpolation.linear.apply(cameraCurrentDirection.x, cameraUnselectedDirection.x, delta);
			cameraCurrentDirection.y = Interpolation.linear.apply(cameraCurrentDirection.y, cameraUnselectedDirection.y, delta);
			cameraCurrentDirection.z = Interpolation.linear.apply(cameraCurrentDirection.z, cameraUnselectedDirection.z, delta);
		}
		perspectiveCamera.position.set(cameraCurrentPosition);
		perspectiveCamera.direction.set(cameraCurrentDirection);
		perspectiveCamera.update();
		perspectiveCamera.apply(gl);

		//
		// Render counties
		//
		gl.glEnable(GL10.GL_LIGHTING);
		gl.glEnable(GL10.GL_LIGHT0);
		gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_POSITION, direction, 0);
		gl.glEnable(GL10.GL_COLOR_MATERIAL);
		
		for(CountyImpl county : game.getCounties()) {
			if(county.isRenderable()) {
				gl.glPushMatrix();
				Color countyColor = null;
				if(county.getCountyname().equals(selectedCounty)) {
					countyColor = countySelectedColor.add(county.getInfluencedColor());
				} else {
					countyColor = countyUnselectedColor.add(county.getInfluencedColor());
				}
				gl.glColor4f(countyColor.r, 
						countyColor.g, 
						countyColor.b, 
						countyColor.a);
				county.getCountyMesh().render(GL10.GL_TRIANGLES);
				gl.glPopMatrix();
			}
		}

	}

	@Override
	public void disposeGamescreen(GameImpl game) {

		for(CountyImpl county : game.getCounties()) {
			if(county.isRenderable()) {
				county.disposeMesh();	
			}
		}
		
//		endTurnSound.dispose();
//		startTurnSound.dispose();
	}

	@Override
	public void initEndscreen() {
		// TODO Auto-generated method stub

	}

	public void renderEndscreen(float delta) {

	}

	@Override
	public void disposeEndscreen() {
		// TODO Auto-generated method stub

	}

	public void resize(int width, int height) {
		perspectiveCamera = new PerspectiveCamera(67, width, height);	
		orthographicCamera = new OrthographicCamera(width, height);
	}


}
