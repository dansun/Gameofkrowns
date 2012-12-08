package nu.danielsundberg.droid.gameofkrowns.game.activity;

import nu.danielsundberg.droid.gameofkrowns.game.engine.GameofkrownsGame;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;

public class GameofkrownsGameActivity extends AndroidApplication {

	private GameofkrownsGame game;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		game = new GameofkrownsGame();		
		initialize(game, false);
	}

}
