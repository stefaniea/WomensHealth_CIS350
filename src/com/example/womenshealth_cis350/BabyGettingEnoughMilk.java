package com.example.womenshealth_cis350;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.ExpandableListView;

public class BabyGettingEnoughMilk extends Activity{
	List<String> groupList;
    List<String> childList;
    Map<String, List<String>> itemCollection;
    ExpandableListView expListView;
    String customString;
	
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
      //replace your baby with name of baby if there is one
      		SharedPreferences settings = getSharedPreferences(MainActivity.USER_PREFERENCES, 0);
      		String babyname = settings.getString("babyName", "baby");
       if(babyname != "") {
      //customize with baby name:
        CheckBox c = (CheckBox) findViewById(R.id.checkBox1);
        String custom = c.getText().toString();
        custom = custom.replace("the baby", babyname);
        custom = custom.replace("Baby", babyname);
        c.setText(custom);
        
        c = (CheckBox) findViewById(R.id.checkBox2);
        custom = c.getText().toString();
        custom = custom.replace("the baby", babyname);
        custom = custom.replace("Baby", babyname);
        c.setText(custom);
        
        c = (CheckBox) findViewById(R.id.checkBox3);
        custom = c.getText().toString();
        custom = custom.replace("the baby", babyname);
        custom = custom.replace("Baby", babyname);
        c.setText(custom);
        
        c = (CheckBox) findViewById(R.id.checkBox4);
        custom = c.getText().toString();
        custom = custom.replace("the baby", babyname);
        custom = custom.replace("Baby", babyname);
        c.setText(custom);
        
       
       }
        //setGroupIndicatorToRight();
	}
	
	private void createGroupList() {
		groupList = new ArrayList<String>();
		customString = "Is the baby peeing and pooping?";
    	//replace your baby with name of baby if there is one
		SharedPreferences settings = getSharedPreferences(MainActivity.USER_PREFERENCES, 0);
		String babyname = settings.getString("babyName", "the baby");
		if(babyname.equals("")) babyname = "the baby";
		customString = customString.replace("the baby", babyname);
        groupList.add(customString);        
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
            if (item.equals(customString)) {
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


