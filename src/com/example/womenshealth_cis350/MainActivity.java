package com.example.womenshealth_cis350;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;

public class MainActivity extends Activity {
	public static final String USER_PREFERENCES = "myUserPrefs";
	
	// Splash screen timer
	private static int SPLASH_TIME_OUT = 2000;

	//Bitmap image; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		new Handler().postDelayed(new Runnable() {
 
            @Override
            public void run() {
        		SharedPreferences settings = getSharedPreferences(MainActivity.USER_PREFERENCES, 0);
                Intent start;
                
            	if(settings.getBoolean("filledOut", false)) {
        			start = new Intent(MainActivity.this, LetsGetStarted.class);
        			startActivity(start);
        		}
        		
        		else {
        		start = new Intent(MainActivity.this, SetUp.class);
        		startActivity(start);
        		}
            	
                startActivity(start);
                
        		//FOR TESTING, USE ABOVE FOR REAL THING
        		//start = new Intent(MainActivity.this, SetUp.class);
        		//startActivity(start);
 
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
 

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/*@Override
	public boolean onTouchEvent(MotionEvent event) {
		SharedPreferences settings = getSharedPreferences(MainActivity.USER_PREFERENCES, 0);
		
		
		/*if(settings.getBoolean("filledOut", false)) {
			Intent start = new Intent(this, LetsGetStarted.class);
			startActivity(start);
		}
		
		else {
		Intent start = new Intent(this, SetUp.class);
		startActivity(start);
		}*/
	
		
		//FOR TESTING, USE ABOVE FOR REAL THING
		//Intent start = new Intent(this, SetUp.class);
		//startActivity(start);
		//return true;
	//}
	
	private void init() {
		/* one-time initialization stuff */
	//	setBackgroundResource(R.drawable.ic_launcher);
	//	image = BitmapFactory.decodeResource(getResources(), R.drawable.unicorn);
		//image = Bitmap.createScaledBitmap(image, 150, 150, false);
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
