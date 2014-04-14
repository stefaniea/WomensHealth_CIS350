package com.example.womenshealth_cis350;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class LatchingCorrectly extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.latching_correctly);
		Intent browserIntent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.google.com"));
		startActivity(browserIntent);
	
		String c = (String) ((TextView)findViewById(R.id.textView1)).getText();
		SharedPreferences settings = getSharedPreferences(MainActivity.USER_PREFERENCES, 0);
		String babyname = settings.getString("babyName", "your baby");
		if(babyname.equals("")) babyname = "your baby";
		c = c.replace("my baby", babyname);
		c = c.replace("Baby", babyname);
		((TextView)findViewById(R.id.textView1)).setText(c);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
