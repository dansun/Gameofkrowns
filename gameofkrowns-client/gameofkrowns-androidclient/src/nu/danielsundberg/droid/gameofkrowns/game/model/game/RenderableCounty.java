package nu.danielsundberg.droid.gameofkrowns.game.model.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.math.Vector3;

public abstract class RenderableCounty {
		
	protected Mesh countyMesh;
	protected float scaleY = 1f;
	
	public abstract void setCameraSelectedDirection(Vector3 cameraSelectedDirection);
	
	public abstract Vector3 getCameraSelectedDirection();
	
	public abstract void setCameraSelectedPosition(Vector3 cameraSelectedPosition);
	
	public abstract Vector3 getCameraSelectedPosition();
	
	public abstract Color getInfluencedColor();
	
	public abstract void disposeMesh();
	
	public final void setCountyMesh(Mesh countyMesh) {
		this.countyMesh = countyMesh;
	}
	
	public final Mesh getCountyMesh() {
		return countyMesh;
	}
	
	public final void setScaleY(float scaleY) {
		this.scaleY = scaleY;
	}
	
	public final float getScaleY() {
		return scaleY;
	}
	
	public boolean isRenderable() {
		if(this.countyMesh!=null) {
			return true;
		} else {
			return false;
		}
	}

}
