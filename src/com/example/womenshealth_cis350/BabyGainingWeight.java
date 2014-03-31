package com.example.womenshealth_cis350;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BabyGainingWeight extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gaining_weight);
		TextView content = (TextView) findViewById(R.id.weight_content);
		content.setText(R.string.gain_weight);
	}
	
	
}

