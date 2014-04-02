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

public class FeelFull extends Activity{
	List<String> groupList;
    List<String> childList;
    Map<String, List<String>> itemCollection;
    ExpandableListView expListView;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.feel_full);
		createGroupList(); 
        createCollection();
 
        expListView = (ExpandableListView) findViewById(R.id.feel_full_list);
        final ExpandableListAdapter expListAdapter = new ExpandableListAdapter(
                this, groupList, itemCollection);
        expListView.setAdapter(expListAdapter);
 
        //setGroupIndicatorToRight();
	
	}
	
	private void createGroupList() {
        groupList = new ArrayList<String>();
        groupList.add("Is it normal for my breasts to feel full?");
        groupList.add("What is engorgement?");
        groupList.add("What you can do to help with engorgement");
        groupList.add("Call your health care provider if:");
    }
 
    private void createCollection() {
        String[] normal = { "Your breasts may become larger and heavier, " +
        		"and even a little tender when you start making more milk"};
        
        String[] what_is_engorgement = { "When your milk builds up in your breasts, " +
        		"they may feel very hard and painful, swollen, feel warm to the touch, may " +
        		"feel like they are throbbing"};
        
        String[] help_with_engorgement = { "(i) Breastfeed often for as long as the baby wants",
		
		"(ii) Make sure that the baby is positioned well and latched on correctly",
		"(iii) Hand express or pump a little milk to soften the breast, " +
		"so baby can have a better latch", 
		
		"(iv) Massage the breast", "(v) You may use cold compress (ice pack) " +
				"in between feedings to help make the pain better",
		
		"(vi) Drink adequate amount of fluids", "(vii) Rest", "(viii) Eat well",
		"(ix) Avoid wearing bras or clothing that are too tight"};
        
        
        String[] health_provider = { "(i) You develop a fever",
        		"(ii) The engorgement does lasts for two days or more",
        		"(iii) Your symptoms worsen","(iv) You are concerned " +
        				"that your baby is not able to feed appropriately"
        		};
      
 
        itemCollection = new LinkedHashMap<String, List<String>>();
 
        for (String item : groupList) {
            if (item.equals("Is it normal for my breasts to feel full?")) {
                loadChild(normal);
            } else if (item.equals("What is engorgement?")) {
                loadChild(what_is_engorgement);
            } else if (item.equals("What you can do to help with engorgement")) {
                loadChild(help_with_engorgement);
            } else {
                loadChild(health_provider);
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
