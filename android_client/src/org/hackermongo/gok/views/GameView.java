package org.hackermongo.gok.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Callback {

	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		final SurfaceHolder holder = getHolder();
		holder.addCallback(this);
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		Log.d(getClass().getSimpleName(), "GameView.surfaceChanged()");
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		Log.d(getClass().getSimpleName(), "GameView.surfaceCreated()");
		final Canvas c = holder.lockCanvas();
		c.drawARGB(255, 255, 0, 0);
		holder.unlockCanvasAndPost(c);
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		Log.d(getClass().getSimpleName(), "GameView.surfaceDestroyed()");
	}
}
