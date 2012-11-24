package org.hackermongo.gok.views;

import java.util.List;

import org.hackermongo.gok.model.Game;
import org.hackermongo.gok.model.Region;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Callback {

	private Game mGame;
	private Paint mTextPaint = new Paint();
	{
		mTextPaint.setColor(Color.BLACK);
	}

	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		final SurfaceHolder holder = getHolder();
		holder.addCallback(this);

		mGame = new Game();
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		Log.d(getClass().getSimpleName(), "GameView.surfaceCreated()");
		final Canvas c = holder.lockCanvas();
		drawGame(c);

		holder.unlockCanvasAndPost(c);
	}

	private void drawGame(Canvas c) {
		c.drawARGB(255, 255, 0, 0);

		final List<Region> regions = mGame.getRegions();
		if (null != regions) {
			drawRegions(c, regions);
		}
	}

	private void drawRegions(Canvas c, List<Region> regions) {
		final float rowPixels = c.getHeight() * 0.10f;
		Log.d(getClass().getSimpleName(), "GameView.drawRegions() pixels: "
				+ rowPixels);
		c.save();
		for (Region r : regions) {
			c.translate(0, rowPixels);
			c.drawText(r.getName(), 0, 0, mTextPaint);
		}
		c.restore();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		Log.d(getClass().getSimpleName(), "GameView.surfaceDestroyed()");
	}
}
