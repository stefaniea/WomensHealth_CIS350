package com.example.womenshealth_cis350;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ExpandableListView;

public class CallProvider extends Activity {
	List<String> groupList;
    List<String> childList;
    Map<String, List<String>> itemCollection;
    ExpandableListView expListView;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.call_provider);
		createGroupList(); 
        createCollection();
 
        expListView = (ExpandableListView) findViewById(R.id.call_provider_list);
        final ExpandableListAdapter expListAdapter = new ExpandableListAdapter(
                this, groupList, itemCollection);
        expListView.setAdapter(expListAdapter);
 
        //setGroupIndicatorToRight();
	
	}
	
	private void createGroupList() {
        groupList = new ArrayList<String>();
        groupList.add("Breastfeeding issues related to mom");
        groupList.add("Breastfeeding issues related to baby");
    }
 
    private void createCollection() {
        String[] mom = { "(a) Fever and/or flu-like symptoms", "(b) Feeling run down and/or your body is achy",
"(c) Breasts feel warm or hot to touch", "(d) Breasts are pink or red", 
"(e) If you find pus or blood in the milk", "(f) Red streaks in your breasts",
"(g) Pink, flaky, itchy, cracked nipples", "(h) Nipples are blistered, or have a deep pink color",
"(i) If you feel shooting pain in the breasts while breastfeeding"};
        String[] baby = { "(a) If your baby will not latch on and/or refuses to feed",
"(b) If you think that your baby is not getting enough milk, appears to be losing weight, weak, lethargic",
"(c) If your baby is not wetting enough diapers and/or not passing stools",
"(d) If your baby has thick, white patches in the insides of his/her mouth and cheeks"};
 
        itemCollection = new LinkedHashMap<String, List<String>>();
 
        for (String item : groupList) {
            if (item.equals("Breastfeeding issues related to mom")) {
                loadChild(mom);
            } else {
                loadChild(baby);
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
