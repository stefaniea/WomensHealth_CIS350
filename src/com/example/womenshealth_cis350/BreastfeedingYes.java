package com.example.womenshealth_cis350;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;

public class BreastfeedingYes extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.breastfeedingyes);
	}
	
	public boolean onBenefitsClick(View v) {
		Intent start = new Intent(this, BenefitsOfBreastfeeding.class);
		startActivity(start);

		return true;
	}
	
	public boolean onGoalsClick(View v) {
		Intent start = new Intent(this, GoalSetting.class);
		startActivity(start);

		return true;
	}
}

