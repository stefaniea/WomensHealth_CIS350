package com.example.womenshealth_cis350;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;

public class BreastfeedingNo extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.breastfeedingno);
	}
	
	public boolean onDidYouKnowClick(View v) {
		Intent start = new Intent(this, BenefitsOfBreastfeeding.class);
		startActivity(start);

		return true;
	}
	
	public boolean mythBustersClick(View v) {
		Intent start = new Intent(this, MythBusters.class);
		startActivity(start);

		return true;
	}
}

