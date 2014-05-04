package com.example.womenshealth_cis350;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class WhatToExpect extends Activity implements OnItemSelectedListener {
	
	private String babyname;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.what_to_expect);
		Spinner spinner = (Spinner) findViewById(R.id.age_spinner);
		
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		 R.array.ages_array, R.layout.dropdown_blue);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(R.layout.spinner_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);
		
		/*CharSequence title =  adapter.getItem(0);
		SharedPreferences settings = getSharedPreferences(MainActivity.USER_PREFERENCES, 0);
		String babyname = settings.getString("babyName", "your baby");
		String custom = title.toString().replace("your baby", babyname);*/
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		TextView content = (TextView) findViewById(R.id.age_content);
		//position = at birth
		if (arg3 == 0) {
			content.setText(R.string.wte);
		}
		if(arg3 == 1) {
			content.setText(R.string.atbirth_wte);
		}
		if(arg3 == 2) {
			content.setText(R.string.twentyfourhours_wte);
		}
		if(arg3 == 3) {
			content.setText(R.string.twodays_wte);
		}
		if(arg3 == 4) {
			content.setText(R.string.threedays_wte);
		}
		if(arg3 == 5) {
			content.setText(R.string.fourdays_wte);
		}
		if(arg3 == 6) {
			content.setText(R.string.oneweek_wte);
		}
		if(arg3 == 7) {
			content.setText(R.string.twothreeweeks_wte);
		}
		if(arg3 == 8) {
			content.setText(R.string.onemonth_wte);
		}
		if(arg3 == 9) {
			content.setText(R.string.twomonths_wte);
		}
		if(arg3 == 10) {
			content.setText(R.string.threemonths_wte);
		}
		if(arg3 == 11) {
			content.setText(R.string.fourmonths_wte);
		}
		if(arg3 == 12) {
			content.setText(R.string.sixmonths_wte);
		}
		if(arg3 == 13) {
			content.setText(R.string.aftersixmonths_wte);
		}
		
		//replace your baby with name of baby if there is one
		String c = (String) content.getText();
		SharedPreferences settings = getSharedPreferences(MainActivity.USER_PREFERENCES, 0);
		String babyname = settings.getString("babyName", "your baby");
		if(babyname.equals("")) babyname = "your baby";
		c = c.replace("your baby", babyname);
		c = c.replace("Your baby", babyname);
		c = c.replace("Your Baby", babyname);
		c = c.replace("the baby", babyname);
		content.setText(c);
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
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
