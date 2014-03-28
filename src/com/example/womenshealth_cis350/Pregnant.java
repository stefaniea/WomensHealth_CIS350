package com.example.womenshealth_cis350;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;

public class Pregnant extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pregnant);
	}
	
	public boolean onYesClick(View v) {
		Intent start = new Intent(this, BreastfeedingYes.class);
		startActivity(start);

		return true;
	}
	
	/*public boolean onNoClick(View v) {
		Intent start = new Intent(this, BreastfeedingNo.class);
		startActivity(start);

		return true;
	}*/
}
