package com.example.womenshealth_cis350;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
  
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView.BufferType;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
 
public class BenefitsOfBreastfeeding extends Activity {
 
    List<String> groupList;
    List<String> childList;
    Map<String, List<String>> itemCollection;
    ExpandableListView expListView;
    
	PopupWindow popUp;
	LinearLayout layout;
	TextView tv;
	LayoutParams params;
	View v;
	boolean dismissPop = false;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String activity = intent.getStringExtra("activity");
        if (activity.equals("first")){
             setContentView(R.layout.benefits_main);
        } else {
        	 setContentView(R.layout.benefits_main_changemind);
        }
        	
		//set correct avatar:
		ImageView avatar = (ImageView) findViewById(R.id.imageView1);
		SharedPreferences settings = getSharedPreferences(MainActivity.USER_PREFERENCES, 0);
		int img = settings.getInt("avatar", R.drawable.avatar1);
		avatar.setImageResource(img);
 
        createGroupList();
 
        createCollection();
 
        expListView = (ExpandableListView) findViewById(R.id.benefit_list);
        final ExpandableListAdapter expListAdapter = new ExpandableListAdapter(
                this, groupList, itemCollection);
        expListView.setAdapter(expListAdapter);
        
        TextView bubble = (TextView) findViewById(R.id.subtitle);
        bubble.setText("Breastfeeding has many benefits for both the mother and the baby");
        bubble.setBackgroundResource(R.drawable.bubble_blue);
        //bubble.setPadding(50, 50, 50, 50);
        bubble.setTextColor(getResources().getColor(R.color.colorred));
 
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

        // for definition pop-up
        layout = new LinearLayout(this);
        layout.setBackgroundColor(this.getResources().getColor(R.color.coloryellow));

        layout.setPadding(20,20, 20, 20);

        popUp = new PopupWindow(this);
        tv = new TextView(this);
        params = new LayoutParams(LayoutParams.MATCH_PARENT,
        		LayoutParams.MATCH_PARENT);
        layout.setOrientation(LinearLayout.VERTICAL);
        popUp.setHeight(90);
        popUp.setWidth(90);

        tv.setText("The number of infant deaths occurring after 28 days of life and before 12 months of life.");

        tv.setTextSize(10);
        tv.setTextColor(this.getResources().getColor(R.color.colorred));
        layout.addView(tv, params);


        popUp.setContentView(layout);

        popUp.setBackgroundDrawable(new BitmapDrawable()); //gets rid of border
        v = this.findViewById(android.R.id.content);
    }
    
	//touch anywhere and popup goes away
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		popUp.dismiss();
		dismissPop = true;
		return true;
	}

    private void createGroupList() {
        groupList = new ArrayList<String>();
        groupList.add("Benefits for the baby");
        groupList.add("Benefits for the mother");
    }
 
    private void createCollection() {
        // preparing benefits collection(child)
        String[] babyBenefits = { "A decrease in the number and severity of infections such as ear infections, urinary tract infections, and meningitis", 
        		"A decrease in the postneonatal infant mortality rate by over 20%",
                "A decrease in the incidence of type I diabetes, type II diabetes, childhood cancers, obesity and asthma",
                "A decrease in pain experienced by infants during a procedure such as a blood draw or vaccination",
                "A decrease in sudden infant death syndrome (SIDS)",
                "Increased bonding and positive emotional attachment behaviors",
                "Increased performance on cognitive development tests"};
        String[] momBenefits = { "A decrease in blood loss after delivery due to increased contractions of the uterus, allowing it to return to its pre-pregnant size ",
        		"A decrease in the development of breast and ovarian cancers",
        		"A decrease in the incidence of type II diabetes and osteoporosis",
        		"A quicker return to pre-pregnancy weight",
        		"Increased feelings of bonding and attachment to the baby",
        		"Cost savings compared to formula feeding"};
 
        itemCollection = new LinkedHashMap<String, List<String>>();
 
        for (String item : groupList) {
            if (item.equals("Benefits for the baby")) {
                loadChild(babyBenefits);
            }
            else {
                loadChild(momBenefits);
            }
 
            itemCollection.put(item, childList);
        }
        
        //init();
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
    
    public boolean onChangeMind(View v) {
		Intent start = new Intent(this, ChangeMind.class);
		startActivity(start);

		return true;
	}
    
 
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    

	/*private void init() {
		TextView definitionView = (TextView) findViewById(R.id.benefit_list);
		String definition = definitionView.getText().toString();

		definitionView.setMovementMethod(LinkMovementMethod.getInstance());
		definitionView.setText(definition, BufferType.SPANNABLE);
		Spannable spans = (Spannable) definitionView.getText();
		BreakIterator iterator = BreakIterator.getWordInstance(Locale.US);
		iterator.setText(definition);

		int start = iterator.first();
		for (int end = iterator.next(); end != BreakIterator.DONE; start = end, end = iterator
				.next()) {
			String possibleWord = definition.substring(start, end);
			if (possibleWord.equalsIgnoreCase("postneonatal infant mortality rate")) {
				if (Character.isLetterOrDigit(possibleWord.charAt(0))) {
					ClickableSpan clickSpan = getClickableSpan(possibleWord);
					spans.setSpan(clickSpan, start, end,
							Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
				}
			}
		}
	}

	private ClickableSpan getClickableSpan(final String word) {
		return new ClickableSpan() {
			//final String mWord = "Rooting is a type of reflex that your baby may do in response to his/her cheek being stroked.  " +
			//		"Your baby may turn his/her head and make sucking movements towards your chest/nipple.";

			@Override
			public void onClick(View widget) {
				//Log.d("tapped on:", mWord);
				//Toast.makeText(widget.getContext(), mWord, Toast.LENGTH_LONG).show();
				if (!dismissPop) {
					popUp.showAtLocation(v, Gravity.CENTER, 10, 10);
					popUp.update((int) v.getWidth()/2, 200);

				} else {
					popUp.dismiss();
				}
				dismissPop = !dismissPop;
			}

			public void updateDrawState(TextPaint ds) {
				super.updateDrawState(ds);
			}
		};
	}*/
}