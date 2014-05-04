
package com.example.womenshealth_cis350;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.Toast;
import android.widget.ExpandableListView.OnChildClickListener;

public class ExpectRoomingIn extends Activity{
	List<String> groupList;
	List<String> childList;
	Map<String, List<String>> itemCollection;
	ExpandableListView expListView;
	String customString;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.expect_rooming_in);	

		createGroupList();

		createCollection();

		expListView = (ExpandableListView) findViewById(R.id.expectRoomingInList);
		final ExpandableListAdapter expListAdapter = new ExpandableListAdapter(
				this, groupList, itemCollection);
		expListView.setAdapter(expListAdapter);
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
		groupList.add("Why should I room in with my baby?");
		groupList.add("Won't I lose sleep if I have my baby with me 24 hours a day?");
		groupList.add("Doesn't my baby have to go to the nursery for tests and procedures?");
	}

	private void createCollection() {
		// preparing benefits collection(child)
		String[] roomBaby = { 
				"Mothers who room-in with their babies \n \to Make more milk \n \to Make more milk sooner \n \to Breastfeed longer", 
				"Babies who room-in with their mothers \n \to Are more likely to exclusively breastfeed \n \to Cry less \n \to Soothe more easily \n \to Spend more time quietly sleeping \n \to Take in more breast milk \n \to Are less likely to develop jaundice",
		};
		String[] loseSleep = { "Studies show that mothers and babies who room in get the same amount of sleep as those whose babies are cared for in the nursery",
				"Some moms may even sleep more peacefully knowing their babies are with them"};

		
		itemCollection = new LinkedHashMap<String, List<String>>();

		for (String item : groupList) {
			if (item.equals("Why should I room in with my baby?")) {
				loadChild(roomBaby);
			}
			else if (item.equals("Won't I lose sleep if I have my baby with me 24 hours a day?")){
				loadChild(loseSleep);
			}

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
	
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.changeavatarname :
	        Intent start = new Intent(this, SetUp.class);
			startActivity(start);
	           return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
}


