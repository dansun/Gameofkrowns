package org.hackermongo.gok.views;

import java.util.HashMap;
import java.util.Map;

import org.hackermongo.gok.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.widget.Toast;

public class GameView extends SurfaceView implements Callback {
	final int[] REGION_COLORS = new int[] { 0xff000000, 0xff00ff00, 0xffff0000,
			0xffffff00, 0xffff00ff, 0xff00ffff };
	final String[] REGION_NAMES = new String[] { "BLACK", "GREEN", "RED",
			"YELLOW", "PURPLE", "CYAN" };
	private final Bitmap mMapBitmap;
	private final Paint mPaint = new Paint();
	private float mWidthRatio;
	private float mHeightRatio;

	final Map<Integer, String> mHitMap = new HashMap<Integer, String>();

	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		final SurfaceHolder holder = getHolder();
		holder.addCallback(this);

		mMapBitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.hitmap);

		for (int i = 0; i < REGION_COLORS.length; i++) {
			Log.d(getClass().getSimpleName(), "GameView.GameView() COLOR: "
					+ REGION_COLORS[i]);
			mHitMap.put(REGION_COLORS[i], REGION_NAMES[i]);
		}
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		Log.d(getClass().getSimpleName(), "GameView.surfaceCreated()");
		final Canvas c = holder.lockCanvas();
		mWidthRatio = mMapBitmap.getWidth() / (float) c.getWidth();
		mHeightRatio = mMapBitmap.getHeight() / (float) c.getHeight();
		Log.d(getClass().getSimpleName(),
				"GameView.surfaceCreated() ratio width: " + mWidthRatio
						+ " height: " + mHeightRatio);

		drawGame(c);

		holder.unlockCanvasAndPost(c);
	}

	private void drawGame(Canvas c) {
		c.drawARGB(255, 255, 0, 0);

		final Rect src = new Rect(0, 0, mMapBitmap.getWidth(),
				mMapBitmap.getHeight());
		Log.d(getClass().getSimpleName(),
				"GameView.drawGame(): " + src.toShortString());
		final RectF dst = new RectF(0, 0, c.getWidth(), c.getHeight());
		c.drawBitmap(mMapBitmap, src, dst, mPaint);
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		Log.d(getClass().getSimpleName(), "GameView.surfaceDestroyed()");
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (MotionEvent.ACTION_UP == event.getAction()) {
			final float screenX = event.getX();
			final float screenY = event.getY();
			Log.d(getClass().getSimpleName(),
					"GameView.onTouchEvent() screenX: " + screenX
							+ " screenY: " + screenY);

			final int bmpX = (int) (screenX * mWidthRatio);
			final int bmpY = (int) (screenY * mHeightRatio);
			Log.d(getClass().getSimpleName(), "GameView.onTouchEvent() x: "
					+ bmpX + " y: " + bmpY);

			final int pixel = mMapBitmap.getPixel(bmpX, bmpY);
			Log.d(getClass().getSimpleName(),
					"GameView.onTouchEvent() PIXEL VALUE: " + pixel);
			final String hit = mHitMap.get(pixel);
			Log.d(getClass().getSimpleName(), "GameView.onTouchEvent() FOUND: "
					+ hit);

			if (null != hit) {
				Toast.makeText(getContext(), hit, Toast.LENGTH_SHORT).show();
			}
		}

		return true;
	}
}
