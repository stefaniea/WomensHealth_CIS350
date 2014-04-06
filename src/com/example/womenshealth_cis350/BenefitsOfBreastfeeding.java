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
import android.widget.TextView;
import android.widget.Toast;
 
public class BenefitsOfBreastfeeding extends Activity {
 
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
        
        TextView bubble = (TextView) findViewById(R.id.subtitle);
        bubble.setText("Breastfeeding has many benefits for both the mother and the baby");
        bubble.setBackgroundResource(R.drawable.bubble_blue);
        bubble.setPadding(30, 30, 30, 35);
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