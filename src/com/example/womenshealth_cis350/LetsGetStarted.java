package com.example.womenshealth_cis350;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.example.womanshealth_cis350.R;

public class LetsGetStarted extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.get_started);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onStartedClick(View v) {
		
	}

}
