package com.example.womenshealth_cis350;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Postpartum extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.postpartum);
		
		
	}
	
	public boolean onWhatToExpectClick(View v) {
		Intent start = new Intent(this, WhatToExpect.class);
		startActivity(start);

		return true;
	}
	
	public boolean onPositioningLatchClick(View v) {
		Intent start = new Intent(this, PositioningLatch.class);
		startActivity(start);

		return true;
	}
	public boolean onTroubleShootingClick(View v) {
		Intent start = new Intent(this, TroubleShooting.class);
		startActivity(start);

		return true;
	}
	
	public boolean referencesButtonClick(View v) {
		Intent start = new Intent(this, References.class);
		startActivity(start);

		return true;
	}
}
