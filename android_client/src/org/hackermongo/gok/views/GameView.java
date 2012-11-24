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
		Log.d("LOG_TAG", "GameView.GameView()#1");
		final SurfaceHolder holder = getHolder();
		holder.addCallback(this);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		Log.d("LOG_TAG", "GameView.onDraw()");
		canvas.drawARGB(255, 255, 255, 255);
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		Log.d("LOG_TAG", "GameView.surfaceChanged()");
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		Log.d("LOG_TAG", "GameView.surfaceCreated()");
		Canvas c = getHolder().lockCanvas();
		draw(c);
		getHolder().unlockCanvasAndPost(c);
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		Log.d("LOG_TAG", "GameView.surfaceDestroyed()");
	}
}
