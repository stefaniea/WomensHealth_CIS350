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
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ExpandableListView.OnChildClickListener;

public class Pacifier extends Activity {
	

    List<String> groupList;
    List<String> childList;
    Map<String, List<String>> itemCollection;
    ExpandableListView expListView;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pacifier);
        
		//set correct avatar:
		ImageView avatar = (ImageView) findViewById(R.id.imageView1);
		SharedPreferences settings = getSharedPreferences(MainActivity.USER_PREFERENCES, 0);
		int img = settings.getInt("avatar", R.drawable.avatar1);
		avatar.setImageResource(img);
 
        createGroupList();
 
        createCollection();
 
        expListView = (ExpandableListView) findViewById(R.id.pacifier_list);
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
        groupList.add("Pros of using a pacifier");
        groupList.add("Cons of using a pacifier");
    }
 
    private void createCollection() {
        String[] pros = { "May soothe baby", "May help settle a baby to sleep",
                "May provide comfort during airplane rides",
                "May help reduce the risk of sudden infant death syndrome (SIDS)"};
        String[] cons = { "Early use of a pacifier may disrupt breastfeeding",
        		"Baby may become dependent on pacifier",
        		"Using pacifiers past the first few years of life may lead to dental problems"};
 
        itemCollection = new LinkedHashMap<String, List<String>>();
 
        for (String item : groupList) {
            if (item.equals("Pros of using a pacifier")) {
                loadChild(pros);
            }
            else {
                loadChild(cons);
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
