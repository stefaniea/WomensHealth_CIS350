package com.example.womenshealth_cis350;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class TroubleShooting extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.troubleshooting);
	}
	
	/*public boolean on(View v) {
		Intent start = new Intent(this, Pregnant.class);
		startActivity(start);

		return true;
	}
	*/
	public boolean onFeelFullClick(View v) {
		Intent start = new Intent(this, FeelFull.class);
		startActivity(start);

		return true;
	}
	
	public boolean onNoMilkClick(View v) {
		Intent start = new Intent(this, NotEnoughMilk.class);
		startActivity(start);

		return true;
	}
	
	public boolean onCrackedClick(View v) {
		Intent start = new Intent(this, NippleHurts.class);
		startActivity(start);

		return true;
	}
	
	public boolean onProviderClick(View v) {
		Intent start = new Intent(this, CallProvider.class);
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
