package com.example.womenshealth_cis350;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
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
}
