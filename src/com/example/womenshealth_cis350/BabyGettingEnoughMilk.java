package com.example.womenshealth_cis350;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ExpandableListView;

public class BabyGettingEnoughMilk extends Activity{
	List<String> groupList;
    List<String> childList;
    Map<String, List<String>> itemCollection;
    ExpandableListView expListView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.baby_getting_enough_milk);	
		
		createGroupList();
		 
        createCollection();
 
        expListView = (ExpandableListView) findViewById(R.id.baby_enough_list);
        final ExpandableListAdapter expListAdapter = new ExpandableListAdapter(
                this, groupList, itemCollection);
        expListView.setAdapter(expListAdapter);
 
        //setGroupIndicatorToRight();
	}
	
	private void createGroupList() {
        groupList = new ArrayList<String>();
        groupList.add("Is the baby peeing and pooping?");
    }
 
    private void createCollection() {
        String[] peepoop = { "Day 1 (first 24 hours of birth) = 1 wet diaper & " +
        		"1 poopy diaper that is thick, tarry and black", "Day 2 = 2 wet " +
        				"diapers & 3 poopy diapers that are thick, tarry and black",
"Day 3 = 5-6 wet diapers & 3 poopy diapers that are looser, greenish to yellow", 
"Day 4 = 6 wet diapers & 3 yellow, soft and watery", "Day 5- 6 = 6 wet diapers & 3 loose and seedy, yellow",
"Day 7 = 6 wet diapers & 3 larger amounts of loose and seedy, yellow"};
 
        itemCollection = new LinkedHashMap<String, List<String>>();
 
        for (String item : groupList) {
            if (item.equals("Is the baby peeing and pooping?")) {
                loadChild(peepoop);
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
