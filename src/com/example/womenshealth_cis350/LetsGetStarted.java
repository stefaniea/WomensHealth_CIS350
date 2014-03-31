package com.example.womenshealth_cis350;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;


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
	
	public boolean onStartedClick(View v) {
	//after clicking "let's get started" change the page	
		Intent start = new Intent(this, PregnantPostpartum.class);
		startActivity(start);
	
		return true;
	}
	
	//testing the WhatToExpect page
	public boolean onTestDropDownClick(View v) {
		Intent start = new Intent(this, WhatToExpect.class);
		startActivity(start);
	
		return true;
	}
	
}
