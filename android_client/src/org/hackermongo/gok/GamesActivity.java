package org.hackermongo.gok;

import java.util.Calendar;

import android.app.Activity;

import android.os.Bundle;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.ListView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.ImageView;
import android.util.Log;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

import org.hackermongo.gok.model.*;

class MyAdapter extends BaseAdapter {
	
	private Game[] games;
	private Context context;
	
	MyAdapter(Context iContext, Game[] iGames) {
		games = iGames;
		context = iContext;
	}
	
	@Override
	public int getCount() {
		return games.length;
	}

	@Override
	public Object getItem(int index) {
		return games[index];
	}

	@Override
	public long getItemId(int index) {
		return index; // ?
	}

	@Override
	public View getView(int index, View view, ViewGroup group) {
		
		Game game = games[index];
		
		LayoutInflater inflater = (LayoutInflater) context
		        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.activity_games_row, group, false);
	    
		TextView playersView = (TextView) rowView.findViewById(R.id.players);	    
	    TextView startDateView = (TextView) rowView.findViewById(R.id.startdate);
	    ImageView starView = (ImageView) rowView.findViewById(R.id.star);
	    
	    ArrayList<Player> players = game.getPlayers();
	    
	    StringBuffer tmp = new StringBuffer();
	    boolean turnComplete = true;
	    
	    for (int i = 0; i < players.size(); i++)
	    {
	    	Player p = players.get(i);
	    	
	    	if (i != 0)
	    	{
	    		tmp.append(',');
	    	}
	    	tmp.append(p.getUser().getUserId());
	    	
	    	if (p.getFinishedTurn() != game.getTurnIndex())
	    	{
	    		turnComplete = false;
	    	}
	    }
	    playersView.setText(tmp.toString());
	    
	    SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm");	    
	    startDateView.setText("Started: " + dateformat.format(game.getDate()));
	    	    
	    if (turnComplete)
	    {
	    	starView.setImageResource(android.R.drawable.btn_star_big_on);
	    }
	    else
	    {
	    	starView.setImageResource(android.R.drawable.btn_star_big_off);
	    }
	    
		return rowView;
	}
	
}

public class GamesActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_games);
	}

	@Override
	protected void onResume() 
	{
		super.onResume();
		ListView listView = (ListView) findViewById(R.id.gameslist);
		
		java.util.ArrayList<Player> players = new java.util.ArrayList<Player>();
		players.add(new Player(new Friend("Ante"), new Clan("Clan"), new org.hackermongo.gok.model.Character("Character"), 0));
		players.add(new Player(new Friend("Dante"), new Clan("Clan"), new org.hackermongo.gok.model.Character("Character"), 0));
		players.add(new Player(new Friend("Donte"), new Clan("Clan"), new org.hackermongo.gok.model.Character("Character"), 0));
		players.add(new Player(new Friend("Do"), new Clan("Clan"), new org.hackermongo.gok.model.Character("Character"), 0));
		
		java.util.ArrayList<Player> players2 = new java.util.ArrayList<Player>();
		players2.add(new Player(new Friend("Hacke"), new Clan("Clan"), new org.hackermongo.gok.model.Character("Character")));
		players2.add(new Player(new Friend("Stacke"), new Clan("Clan"), new org.hackermongo.gok.model.Character("Character")));

		
		Game games[] = new Game[]
				{
					new Game(players),
					new Game(players2)					
				};
		
		// Assign adapter to ListView
		listView.setAdapter(new MyAdapter(this, games)); 
	}	
}
