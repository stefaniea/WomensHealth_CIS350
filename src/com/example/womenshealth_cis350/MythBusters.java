package com.example.womenshealth_cis350;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.Toast;

public class MythBusters extends Activity {

	List<String> groupList;
	List<String> childList;
	Map<String, List<String>> itemCollection;
	ExpandableListView expListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.benefits_main);

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
		groupList.add("Breastfeeding hurts");
		groupList.add("I won’t make enough milk");
		groupList.add("My breasts will be saggy");
		groupList.add("My baby will be spoiled");
		groupList.add("I have to go back to school or work");
		groupList.add("I’ll never get any sleep");
		groupList.add("My baby’s father won’t be attached to the baby");
	}

	private void createCollection() {
		// preparing benefits collection(child)
		String[] breastFeedingHurts = { "When done properly, breastfeeding should NOT hurt! While you may " +
				"experience some mild soreness in your nipples during the first few weeks, this should" +
				" resolve as your nipples toughen up","Often times, there is a problem that can be fixed by" +
			    " help from a person who is skilled in assisting women with breastfeeding", 
		        "Click here for troubleshooting tips"}; 

		String[] notMilkEnough = { "Almost all breastfeeding mothers have this fear, so it is completely normal if you feel this way", 
			 "Rest assured, over 95% of women have the anatomy to make enough milk for their baby", 
			"The key to making enough milk is following certain recommendations after the baby is born" +
			" to ensure your baby is getting enough and that your milk supply comes in", 
			"	[link to “Steps to successful breastfeeding in the early postpartum period] "};


		String[] saggyBreast = { "In reality, pregnancy has changed your body forever and this is a beautiful thing!",  
		 "Your body has made changes, including changes in your breasts, " +
		 "that have made it possible for you to grow this tiny human inside of you", 
		"Breastfeeding itself will not significantly change your breasts/nipples" };
		
		String[] babySpoiled = {"There is no such thing as a spoiled baby!",  
		"Babies were meant to be close to their mothers and seek them out for nourishment as well as comfort", 
		"Enjoy this special time and the closeness that breastfeeding can create"
		};
		
		String[] schoolWork = {
		"Providing breast milk is equally important for your baby, even if you are not breastfeeding your baby", 
		"Many women successfully return to school or work while still providing their babies with their breast milk", 
		"[link to “Pumping”]",
		"[link to “Returning to work”]"};


		String[] noSleep = {
		"Studies have shown that women who breastfeed their babies not only get more" +
		" sleep than women who formula feed their babies, but they report feeling more " +
		"rested overall throughout the day", 
		"Breastfeeding can save you time on safely preparing formula, washing bottles," +
		" and going to the pediatricians office because your baby is sick"}; 
		
		String[] attachedFather = {
		"Many women have this feeling and are worried that the baby’s father will not be as involved", 
		"Fathers play a very crucial role in breastfeeding by being the main support person for you when you’re having a difficult time", 
		"There are many other ways for fathers to be involved and feel attached to their baby including \n •	Burping " +
		"the baby \n •	Changing the baby’s diaper \n•	Soothing the baby to sleep"}; 



		itemCollection = new LinkedHashMap<String, List<String>>();

		for (String item : groupList) {
			if (item.equals("Breastfeeding hurts")) {
				loadChild(breastFeedingHurts);
			}
			if (item.equals("I won’t make enough milk")) {
				loadChild(notMilkEnough);
			}
			if (item.equals("My breasts will be saggy")) {
				loadChild(saggyBreast);
			}
			if (item.equals("My baby will be spoiled")) {
				loadChild(babySpoiled);
			}
			if (item.equals("I have to go back to school or work")) {
				loadChild(schoolWork);
			}
			if (item.equals("I’ll never get any sleep")) {
				loadChild(noSleep);
			}

			if (item.equals("My baby’s father won’t be attached to the baby")) {
				loadChild(attachedFather);
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
}