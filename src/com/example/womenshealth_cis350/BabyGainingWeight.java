package com.example.womenshealth_cis350;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BabyGainingWeight extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gaining_weight);
		
		//set correct avatar:
		ImageView avatar = (ImageView) findViewById(R.id.imageView1);
		SharedPreferences settings = getSharedPreferences(MainActivity.USER_PREFERENCES, 0);
		int img = settings.getInt("avatar", R.drawable.avatar1);
		avatar.setImageResource(img);
		
	}
	
	
}

