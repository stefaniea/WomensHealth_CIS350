package com.example.womenshealth_cis350;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;

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
}
