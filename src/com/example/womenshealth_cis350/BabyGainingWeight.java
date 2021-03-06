package com.example.womenshealth_cis350;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BabyGainingWeight extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gaining_weight);
		
		//set correct avatar:
		ImageView avatar = (ImageView) findViewById(R.id.imageView1);
		SharedPreferences settings = getSharedPreferences(MainActivity.USER_PREFERENCES, 0);
		int img = settings.getInt("avatar", R.drawable.avatar1);
		avatar.setImageResource(img);
		
	}
	
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

