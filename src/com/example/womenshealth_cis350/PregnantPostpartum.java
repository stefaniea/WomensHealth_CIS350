package com.example.womenshealth_cis350;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;

public class PregnantPostpartum extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pregnant_postpartum);
		
		
	}
	
	public boolean onPregnantClick(View v) {
		Intent start = new Intent(this, Pregnant.class);
		startActivity(start);

		return true;
	}
	
	public boolean onPostpartumClick(View v) {
		Intent start = new Intent(this, Postpartum.class);
		startActivity(start);

		return true;
	}
}
