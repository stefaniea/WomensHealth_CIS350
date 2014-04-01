package com.example.womenshealth_cis350;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ExpandableListView;

public class NippleHurts extends Activity {
	List<String> groupList;
    List<String> childList;
    Map<String, List<String>> itemCollection;
    ExpandableListView expListView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nipple_hurts);
		createGroupList(); 
        createCollection();
 
        expListView = (ExpandableListView) findViewById(R.id.nipplehurts_list);
        final ExpandableListAdapter expListAdapter = new ExpandableListAdapter(
                this, groupList, itemCollection);
        expListView.setAdapter(expListAdapter);
 
        //setGroupIndicatorToRight();
	}
	
	private void createGroupList() {
        groupList = new ArrayList<String>();
        groupList.add("Other Tips");
    }
 
    private void createCollection() {
        String[] tips = { "After breastfeeding, massage a few drops of milk on your clean " +
        		"fingers and rub it on your nipples to help heal and soothe this area.", 
        		"Let your nipples air-dry after feeding.", "Avoid bras or clothes that are too tight",
        		"Avoid using soaps with harsh chemicals or astringents on your nipples. " +
        		"Clean water is all you need to keep your nipples and breasts clean.", 
        		"Ask your health care provider if they recommend using creams, hydrogel pads " +
        		"or a nipple shield", "If the pain came on suddenly, or the pain does not go away, and/" +
        				"or worsens, call your health care provider."};
 
        itemCollection = new LinkedHashMap<String, List<String>>();
 
        for (String item : groupList) {
            if (item.equals("Other Tips")) {
                loadChild(tips);
            }
 
            itemCollection.put(item, childList);
        }
    }
 
    private void loadChild(String[] items) {
        childList = new ArrayList<String>();
        for (String item : items)
            childList.add(item);
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
	
	public boolean onAssessLatchedClick(View v) {
		Intent start = new Intent(this, LatchingCorrectly.class);
		startActivity(start);

		return true;
	}
	
	public boolean onChangePositionClick(View v) {
		Intent start = new Intent(this, DifferentPositions.class);
		startActivity(start);

		return true;
	}

}
