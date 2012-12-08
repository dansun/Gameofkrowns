package nu.danielsundberg.droid.gameofkrowns.list.detail.activity;

import nu.danielsundberg.droid.gameofkrowns.R;
import nu.danielsundberg.droid.gameofkrowns.dummy.DummyContent;
import nu.danielsundberg.droid.gameofkrowns.game.activity.GameofkrownsGameActivity;
import nu.danielsundberg.droid.gameofkrowns.list.activity.GameofkrownsListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A fragment representing a single Game of krowns detail screen. This fragment
 * is either contained in a {@link GameofkrownsListActivity} in two-pane mode
 * (on tablets) or a {@link GameofkrownsDetailActivity} on handsets.
 */
public class GameofkrownsDetailFragment extends Fragment {
	/**
	 * The fragment argument representing the item ID that this fragment
	 * represents.
	 */
	public static final String ARG_ITEM_ID = "item_id";

	/**
	 * The dummy content this fragment is presenting.
	 */
	private DummyContent.DummyItem mItem;

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public GameofkrownsDetailFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (getArguments().containsKey(ARG_ITEM_ID)) {
			// Load the dummy content specified by the fragment
			// arguments. In a real-world scenario, use a Loader
			// to load content from a content provider.
			mItem = DummyContent.ITEM_MAP.get(getArguments().getString(
					ARG_ITEM_ID));
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_gameofkrowns_detail, container, false);
		//
		// Set up intent on click of button to activate gameactivity
		//
		Button button = (Button) rootView.findViewById(R.id.gameofkrowns_detail_entergamebutton);
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View parentView) {
				// In single-pane mode, simply start the detail activity
				// for the selected item ID.
				Intent detailIntent = new Intent(parentView.getContext(), GameofkrownsGameActivity.class);
				startActivity(detailIntent);
			}
		});
		//
		// Show the dummy content as text in a TextView.
		//
		if (mItem != null) {
			((TextView) rootView.findViewById(R.id.gameofkrowns_detail))
					.setText(mItem.content);
		}

		return rootView;
	}
}
