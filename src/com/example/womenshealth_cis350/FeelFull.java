package com.example.womenshealth_cis350;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

public class FeelFull extends Activity{
	List<String> groupList;
    List<String> childList;
    Map<String, List<String>> itemCollection;
    ExpandableListView expListView;
    TextView bubble;
    ScrollView bubble_scroll;
    Button help;
    Button normal;
    Button callprovider;
    Button engorgement;
    Button back;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.feel_full);
		bubble = (TextView) findViewById(R.id.bubble_feel_full);
		bubble.setVisibility(bubble.GONE);
		help = (Button) findViewById(R.id.helpwithengorgement_btn);
		normal = (Button) findViewById(R.id.normal);
		callprovider = (Button) findViewById(R.id.callprovider_btn);
		engorgement = (Button) findViewById(R.id.engorgement_btn);
		back = (Button) findViewById(R.id.back_btn);
		back.setVisibility(back.GONE);
		bubble_scroll = (ScrollView) findViewById(R.id.bubble_scrollview);
		bubble_scroll.setVisibility(bubble_scroll.GONE);
		makeStrings();
		createChildren();
		//createGroupList(); 
        //createCollection();
 
       // expListView = (ExpandableListView) findViewById(R.id.feel_full_list);
        //final ExpandableListAdapter expListAdapter = new ExpandableListAdapter(
          //      this, groupList, itemCollection);
        //expListView.setAdapter(expListAdapter);
        
 
        //setGroupIndicatorToRight();
		
		
		//set correct avatar:
		ImageView avatar = (ImageView) findViewById(R.id.imageView1);
		SharedPreferences settings = getSharedPreferences(MainActivity.USER_PREFERENCES, 0);
		int img = settings.getInt("avatar", R.drawable.avatar1);
		avatar.setImageResource(img);
	
	}
	
	
	public boolean onNormalClick(View v) {
		//expand the button
		bubble.setVisibility(bubble.VISIBLE);
		bubble_scroll.setVisibility(bubble_scroll.VISIBLE);
		bubble.setText("Your breasts may become larger and heavier, " +
        		"and even a little tender when you start making more milk.");
		
		//make other buttons invisible
		help.setVisibility(help.GONE);
		callprovider.setVisibility(callprovider.GONE);
		engorgement.setVisibility(engorgement.GONE);
		
		back.setVisibility(back.VISIBLE);
		
	
		return true;
	}
	
	public boolean onEngorgementClick(View v) {
		//expand the button
		bubble.setVisibility(bubble.VISIBLE);
		bubble_scroll.setVisibility(bubble_scroll.VISIBLE);
		bubble.setText("When your milk builds up in your breasts, " +
        		"they may feel very hard and painful, swollen, feel warm to the touch, may " +
        		"feel like they are throbbing");
		
		//make other buttons invisible
		help.setVisibility(help.GONE);
		callprovider.setVisibility(callprovider.GONE);
		normal.setVisibility(normal.GONE);
		
		back.setVisibility(back.VISIBLE);
		
	
		return true;
	}
	
	public boolean onHelpClick(View v) {
		//expand the button
		bubble_scroll.setVisibility(bubble_scroll.VISIBLE);
		bubble.setVisibility(bubble.VISIBLE);
		bubble.setText("(i) Breastfeed often for as long as the baby wants\n"+
		"(ii) Make sure that the baby is positioned well and latched on correctly\n"+
		"(iii) Hand express or pump a little milk to soften the breast\n " +
		"so baby can have a better latch\n"+
		"(iv) Massage the breast\n" + "(v) You may use cold compress (ice pack) \n" +
				"in between feedings to help make the pain better\n"+
		"(vi) Drink adequate amount of fluids\n"+ "(vii) Res\nt"+ "(viii) Eat well\n"+
		"(ix) Avoid wearing bras or clothing that are too tight");
        
        
		//make other buttons invisible
		engorgement.setVisibility(engorgement.GONE);
		callprovider.setVisibility(callprovider.GONE);
		normal.setVisibility(normal.GONE);
		
		back.setVisibility(back.VISIBLE);
		
		return true;
	}
	
	public boolean onCallProviderClick(View v) {
		//expand the button
		bubble.setVisibility(bubble.VISIBLE);
		bubble_scroll.setVisibility(bubble_scroll.VISIBLE);
		bubble.setText("(i) You develop a fever\n"+
        		"(ii) The engorgement does lasts for two days or more\n"+
        		"(iii) Your symptoms worsen\n"+"(iv) You are concerned \n" +
        				"that your baby is not able to feed appropriately");
        
        
		//make other buttons invisible
		engorgement.setVisibility(engorgement.GONE);
		help.setVisibility(callprovider.GONE);
		normal.setVisibility(normal.GONE);
	
		back.setVisibility(back.VISIBLE);
		return true;
	}
	
	public boolean onBackClick(View v) {
		//invisible bubble (and avatar? idk)
		bubble.setVisibility(bubble.GONE);
		bubble_scroll.setVisibility(bubble_scroll.GONE);
		
		//make other buttons visible again
		help.setVisibility(help.VISIBLE);
		callprovider.setVisibility(callprovider.VISIBLE);
		engorgement.setVisibility(engorgement.VISIBLE);
		normal.setVisibility(normal.VISIBLE);
		back.setVisibility(back.GONE);
		
	
		return true;
	}
	
	private void makeStrings() {
        groupList = new ArrayList<String>();
        groupList.add("Is it normal for my breasts to feel full?");
        groupList.add("What is engorgement?");
        groupList.add("What you can do to help with engorgement");
        groupList.add("Call your health care provider if:");
    }
 
    private void createChildren() {
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
 
 /*   // Convert pixel to dip
    public int getDipsFromPixel(float pixels) {
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale + 0.5f);
    }*/
 
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
