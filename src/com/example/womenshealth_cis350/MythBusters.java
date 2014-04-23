package com.example.womenshealth_cis350;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.Toast;

public class MythBusters extends Activity {

	List<String> groupList;
	List<String> childList;
    Map<String, List<String>> itemCollection;
    ExpandableListView expListView;
    TextView bubble;
    ScrollView bubble_scroll;
    Button saggy;
    Button hurts;
    Button spoiled;
    Button milk;
    Button back;
    Button work;
    Button sleep;
    Button attached;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mythbusters);
	    bubble = (TextView) findViewById(R.id.bubble_mythbusters);
		bubble.setVisibility(bubble.GONE);
		hurts = (Button) findViewById(R.id.hurts_btn);
		saggy = (Button) findViewById(R.id.saggy_btn);
		spoiled = (Button) findViewById(R.id.spoiled_btn);
		milk = (Button) findViewById(R.id.milk_btn);
		work = (Button) findViewById(R.id.work_btn);	
		sleep = (Button) findViewById(R.id.sleep_btn);
		attached = (Button) findViewById(R.id.attached_btn);
		
		back = (Button) findViewById(R.id.back_btn_mythbusters);
		back.setVisibility(back.GONE);
		bubble_scroll = (ScrollView) findViewById(R.id.bubble_scrollview_mythbusters);
		bubble_scroll.setVisibility(bubble_scroll.GONE);
		
		SharedPreferences settings = getSharedPreferences(MainActivity.USER_PREFERENCES, 0);
		//set correct avatar:
		ImageView avatar = (ImageView) findViewById(R.id.imageView1);
		int img = settings.getInt("avatar", R.drawable.avatar1);
		avatar.setImageResource(img);
	}
	
	
	
	
	
	public boolean onHurtClick(View v) {
		//expand the button
		bubble.setVisibility(bubble.VISIBLE);
		bubble_scroll.setVisibility(bubble_scroll.VISIBLE);
		bubble.setText("When done properly, breastfeeding should NOT hurt! While you may " +
				"experience some mild soreness in your nipples during the first few weeks, this should" +
				" resolve as your nipples toughen up.\n" + "Often times, there is a problem that can be fixed by" +
			    " help from a person who is skilled in assisting women with breastfeeding.\n"+ 
		        "Click here for troubleshooting tips");
		
		//make other buttons invisible
		spoiled.setVisibility(spoiled.GONE);
		saggy.setVisibility(saggy.GONE);
		work.setVisibility(work.GONE);
		milk.setVisibility(milk.GONE);
		attached.setVisibility(attached.GONE);
		sleep.setVisibility(sleep.GONE);
		
		back.setVisibility(back.VISIBLE);
		
	
		return true;
	}
	
	public boolean onMilkClick(View v) {
		//expand the button
		bubble_scroll.setVisibility(bubble_scroll.VISIBLE);
		bubble.setVisibility(bubble.VISIBLE);
		bubble.setText("Almost all breastfeeding mothers have this fear, so it is completely normal if you feel this way.\n"+ 
				 "Rest assured, over 95% of women have the anatomy to make enough milk for their baby.\n"+ 
					"The key to making enough milk is following certain recommendations after the baby is born\n" +
					" to ensure your baby is getting enough and that your milk supply comes in.\n"+
					"	[link to Steps to successful breastfeeding in the early postpartum period] \n");
        
        
		//make other buttons invisible
		spoiled.setVisibility(spoiled.GONE);
		saggy.setVisibility(saggy.GONE);
		work.setVisibility(work.GONE);
		hurts.setVisibility(hurts.GONE);
		attached.setVisibility(attached.GONE);
		sleep.setVisibility(sleep.GONE);
		
		back.setVisibility(back.VISIBLE);
		
		return true;
	}
	
	public boolean onSagClick(View v) {
		//expand the button
		bubble.setVisibility(bubble.VISIBLE);
		bubble_scroll.setVisibility(bubble_scroll.VISIBLE);
		bubble.setText("In reality, pregnancy has changed your body forever and this is a beautiful thing!\n"+ 
				 "Your body has made changes, including changes in your breasts, " +
						 "that have made it possible for you to grow this tiny human inside of you.\n"+
						"Breastfeeding itself will not significantly change your breasts/nipples.");
        
        
		//make other buttons invisible
		spoiled.setVisibility(spoiled.GONE);
		hurts.setVisibility(hurts.GONE);
		work.setVisibility(work.GONE);
		milk.setVisibility(milk.GONE);
		attached.setVisibility(attached.GONE);
		sleep.setVisibility(sleep.GONE);

		back.setVisibility(back.VISIBLE);
		return true;
	}
	
	public boolean onSpoiledClick(View v) {
		//expand the button
		bubble.setVisibility(bubble.VISIBLE);
		bubble_scroll.setVisibility(bubble_scroll.VISIBLE);
		bubble.setText("There is no such thing as a spoiled baby!\n"+  
				"Babies were meant to be close to their mothers and seek them out for nourishment as well as comfort.\n"+ 
				"Enjoy this special time and the closeness that breastfeeding can create.");
		
		//make other buttons invisible
		saggy.setVisibility(saggy.GONE);
		hurts.setVisibility(hurts.GONE);
		work.setVisibility(work.GONE);
		milk.setVisibility(milk.GONE);
		attached.setVisibility(attached.GONE);
		sleep.setVisibility(sleep.GONE);

		back.setVisibility(back.VISIBLE);
		
	
		return true;
	}
	
	public boolean onWorkClick(View v) {
		//expand the button
		bubble.setVisibility(bubble.VISIBLE);
		bubble_scroll.setVisibility(bubble_scroll.VISIBLE);
		bubble.setText("Providing breast milk is equally important for your baby, even if you are not breastfeeding your baby.\n"+ 
				"Many women successfully return to school or work while still providing their babies with their breast milk.\n"+
				"[link to Pumping]\n"+
				"[link to Returning to work]\n");
		
		//make other buttons invisible
		spoiled.setVisibility(spoiled.GONE);
		hurts.setVisibility(hurts.GONE);
		saggy.setVisibility(saggy.GONE);
		milk.setVisibility(milk.GONE);
		attached.setVisibility(attached.GONE);
		sleep.setVisibility(sleep.GONE);

		back.setVisibility(back.VISIBLE);
	
		return true;
	}
	
	
	public boolean onSleepClick(View v) {
		//expand the button
		bubble.setVisibility(bubble.VISIBLE);
		bubble_scroll.setVisibility(bubble_scroll.VISIBLE);
		bubble.setText("Studies have shown that women who breastfeed " +
				"their babies not only get more sleep than women who " +
				"formula feed their babies, but they report feeling more " +
				"rested overall throughout the day.\n"+
		"Breastfeeding can save you time on safely preparing formula, " +
		"washing bottles, and going to the pediatricians office because your baby is sick.");
		
		//make other buttons invisible
		spoiled.setVisibility(spoiled.GONE);
		hurts.setVisibility(hurts.GONE);
		saggy.setVisibility(saggy.GONE);
		milk.setVisibility(milk.GONE);
		attached.setVisibility(attached.GONE);
		work.setVisibility(work.GONE);

		back.setVisibility(back.VISIBLE);
	
		return true;
	}
	
	public boolean onAttachedClick(View v) {
		//expand the button
		bubble.setVisibility(bubble.VISIBLE);
		bubble_scroll.setVisibility(bubble_scroll.VISIBLE);
		bubble.setText("Many women have this feeling and are worried that " +
				"the baby's father will not be as involved.\n" +
				"Fathers play a very crucial role in breastfeeding by being the main support person for you when you're having a difficult time.\n"+ 
"There are many other ways for fathers to be involved and " +
"feel attached to their baby including:\n"+
			"\tBurping the baby\n"+
			"\tChanging the baby's diaper\n"+
			"\tSoothing the baby to sleep\n");
		
		//make other buttons invisible
		spoiled.setVisibility(spoiled.GONE);
		hurts.setVisibility(hurts.GONE);
		saggy.setVisibility(saggy.GONE);
		milk.setVisibility(milk.GONE);
		sleep.setVisibility(sleep.GONE);
		work.setVisibility(work.GONE);

		back.setVisibility(back.VISIBLE);
	
		return true;
	}
	
	
	public boolean onBackClick(View v) {
		//invisible bubble (and avatar? idk)
		bubble.setVisibility(bubble.GONE);
		bubble_scroll.setVisibility(bubble_scroll.GONE);
		
		//make other buttons visible again
		spoiled.setVisibility(spoiled.VISIBLE);
		hurts.setVisibility(hurts.VISIBLE);
		work.setVisibility(work.VISIBLE);
		milk.setVisibility(milk.VISIBLE);
		saggy.setVisibility(saggy.VISIBLE);
		attached.setVisibility(attached.VISIBLE);
		sleep.setVisibility(sleep.VISIBLE);
		

		back.setVisibility(back.GONE);
		
		return true;
	}
	
	
	

	private void createGroupList() {
		groupList = new ArrayList<String>();
		groupList.add("Breastfeeding hurts");
		groupList.add("I won't make enough milk");
		groupList.add("My breasts will be saggy");
		groupList.add("My baby will be spoiled");
		groupList.add("I have to go back to school or work");
		groupList.add("I'll never get any sleep");
		groupList.add("My baby's father won't be attached to the baby");
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
			"	[link to Steps to successful breastfeeding in the early postpartum period] "};


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
		"[link to Pumping]",
		"[link to Returning to work]"};


		String[] noSleep = {
		"Studies have shown that women who breastfeed their babies not only get more" +
		" sleep than women who formula feed their babies, but they report feeling more " +
		"rested overall throughout the day", 
		"Breastfeeding can save you time on safely preparing formula, washing bottles," +
		" and going to the pediatricians office because your baby is sick"}; 
		
		String[] attachedFather = {
		"Many women have this feeling and are worried that the baby's father will not be as involved.\n", 
		"Fathers play a very crucial role in breastfeeding by being the main support person for you when you're having a difficult time.\n", 
		"There are many other ways for fathers to be involved and feel attached to their baby including: \n 	Burping " +
		"the baby \n 	Changing the baby's diaper \n	Soothing the baby to sleep"}; 



		itemCollection = new LinkedHashMap<String, List<String>>();

		for (String item : groupList) {
			if (item.equals("Breastfeeding hurts")) {
				loadChild(breastFeedingHurts);
			}
			if (item.equals("I won't make enough milk")) {
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
			if (item.equals("I'll never get any sleep")) {
				loadChild(noSleep);
			}

			if (item.equals("My baby's father won't be attached to the baby")) {
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