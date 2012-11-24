package org.hackermongo.gok;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d("LOG_TAG", "MainActivity.onCreate()");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// AttributeSet attrs;
		// setContentView(new GameView(this, null));

	}

}
