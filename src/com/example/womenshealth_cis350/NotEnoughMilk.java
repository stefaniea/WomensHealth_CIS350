package com.example.womenshealth_cis350;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class NotEnoughMilk extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.not_enough_milk);
	}
	
	public boolean onPeePoopClick(View v) {
		Intent start = new Intent(this, IsPeePoop.class);
		startActivity(start);

		return true;
	}
	
	public boolean onHungryClick(View v) {
		Intent start = new Intent(this, BabyHungry.class);
		startActivity(start);

		return true;
	}
	
	public boolean onGainingWeightClick(View v) {
		Intent start = new Intent(this, BabyGainingWeight.class);
		startActivity(start);

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
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
