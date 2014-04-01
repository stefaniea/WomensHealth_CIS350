package com.example.womenshealth_cis350;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.widget.ExpandableListView;

public class DifferentPositions extends Activity{
	List<String> groupList;
    List<String> childList;
    Map<String, List<String>> itemCollection;
    ExpandableListView expListView;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.differentpositions);
		createGroupList(); 
        createCollection();
 
        expListView = (ExpandableListView) findViewById(R.id.diffpos_list);
        final ExpandableListAdapter expListAdapter = new ExpandableListAdapter(
                this, groupList, itemCollection);
        expListView.setAdapter(expListAdapter);
 
        //setGroupIndicatorToRight();
	
	}
	
	private void createGroupList() {
        groupList = new ArrayList<String>();
        groupList.add("Cross-cradle hold");
        groupList.add("Cradle hold");
        groupList.add("Football hold");
        groupList.add("Side-lying hold");
    }
 
    private void createCollection() {
        String[] cross = { "picture here", "text here"};
        String[] cradle = { "picture here", "text here"};
        String[] football = { "picture here", "text here"};
        String[] side = { "picture here", "text here"};
 
        itemCollection = new LinkedHashMap<String, List<String>>();
 
        for (String item : groupList) {
            if (item.equals("Cross-cradle hold")) {
                loadChild(cross);
            } else if (item.equals("Cradle hold")) {
                loadChild(cradle);
            } else if (item.equals("Football hold")) {
                loadChild(football);
            } else {
                loadChild(side);
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
}
