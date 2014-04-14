package com.example.womenshealth_cis350;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.Toast;

public class CostFormula extends Activity {

	List<String> groupList;
	List<String> childList;
	Map<String, List<String>> itemCollection;
	ExpandableListView expListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.benefits_main);
		
		//set correct avatar:
		ImageView avatar = (ImageView) findViewById(R.id.imageView1);
		SharedPreferences settings = getSharedPreferences(MainActivity.USER_PREFERENCES, 0);
		int img = settings.getInt("avatar", R.drawable.avatar1);
		avatar.setImageResource(img);

		createGroupList();

		createCollection();

		expListView = (ExpandableListView) findViewById(R.id.benefit_list);
		final ExpandableListAdapter expListAdapter = new ExpandableListAdapter(
				this, groupList, itemCollection);
		expListView.setAdapter(expListAdapter);

		//setGroupIndicatorToRight();

		expListView.setOnChildClickListener(new OnChildClickListener() {

			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				final String selected = (String) expListAdapter.getChild(
						groupPosition, childPosition);
				Toast.makeText(getBaseContext(), selected, Toast.LENGTH_LONG)
				.show();

				return true;
			}
		});
	}

	private void createGroupList() {
		groupList = new ArrayList<String>();
		groupList.add("Costs of formula");
	}

	private void createCollection() {
		// preparing benefits collection(child)
		String[] costFormula = { "Formula itself is very expensive and costs most families over $1000 per year, just"+ 
				"this does not include the cost of bottles, nipples, hot water for running the dishwasher, etc.", 
				"There are also significant costs indirectly related to formula feeding that one needs to consider. " +
				"Mothers of formula fed babies: \n -	Miss more days of work than their breastfeeding counterparts"+ 
				"\n-	Have more emergency room visits with associated costs" + 
				"\n-	Have sicker babies who require more visits to the pediatrician's office",
				"Change your mind?  [takes user to YES screens]"}; 


		


		itemCollection = new LinkedHashMap<String, List<String>>();

		for (String item : groupList) {
			//if (item.equals("Costs of formula")) {
				loadChild(costFormula);
			//}
			
			itemCollection.put(item, childList);
		}
	}

	private void loadChild(String[] items) {
		childList = new ArrayList<String>();
		for (String item : items)
			childList.add(item);
	}

	private void setGroupIndicatorToRight() {
		/* Get the screen width */
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int width = dm.widthPixels;

		expListView.setIndicatorBounds(width - getDipsFromPixel(35), width
				- getDipsFromPixel(5));
	}

	// Convert pixel to dip
	public int getDipsFromPixel(float pixels) {
		// Get the screen's density scale
		final float scale = getResources().getDisplayMetrics().density;
		// Convert the dps to pixels, based on density scale
		return (int) (pixels * scale + 0.5f);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}