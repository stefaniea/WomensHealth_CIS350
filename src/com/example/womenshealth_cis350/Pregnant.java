package com.example.womenshealth_cis350;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Pregnant extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pregnant);
		TextView bubble = (TextView) findViewById(R.id.breastfeedyesno_bubble);
		
		//replace your baby with name of baby if there is one
		String c = (String) bubble.getText();
		SharedPreferences settings = getSharedPreferences(MainActivity.USER_PREFERENCES, 0);
		String babyname = settings.getString("babyName", "");
		if(!babyname.equals("")) {
		c = c.replace("your baby", "<b>"+babyname+"</b>");
		bubble.setText(Html.fromHtml(c));
		}
		
		//set correct avatar:
		ImageView avatar = (ImageView) findViewById(R.id.imageView1);
		int img = settings.getInt("avatar", R.drawable.avatar1);
		avatar.setImageResource(img);
		
	}

	public boolean onYesClick(View v) {
		Intent start = new Intent(this, BreastfeedingYes.class);
		startActivity(start);

		return true;
	}

	public boolean onNoClick(View v) {
			Intent start = new Intent(this, BreastfeedingNo.class);
			startActivity(start);
	
		


		return true;
	}
}
