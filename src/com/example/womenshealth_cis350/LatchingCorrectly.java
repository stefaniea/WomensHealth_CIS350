package com.example.womenshealth_cis350;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.TextView;

public class LatchingCorrectly extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.latching_correctly);
		//Intent browserIntent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.google.com"));
	//	startActivity(browserIntent);
	
		String c = (String) ((TextView)findViewById(R.id.textView1)).getText();
		SharedPreferences settings = getSharedPreferences(MainActivity.USER_PREFERENCES, 0);
		String babyname = settings.getString("babyName", "baby");
		if(!babyname.equals(""))  {
		c = c.replace("my baby", babyname);
		c = c.replace("Baby", babyname);
		((TextView)findViewById(R.id.textView1)).setText(c);
		
		
		  CheckBox check = (CheckBox) findViewById(R.id.checkBox4);
	        String custom = check.getText().toString();
	        custom = custom.replace("the baby", babyname);
	        custom = custom.replace("Baby", babyname);
	        check.setText(custom);
	        
	        check = (CheckBox) findViewById(R.id.checkBox5);
	        custom = check.getText().toString();
	        custom = custom.replace("the baby", babyname);
	        custom = custom.replace("Baby", babyname);
	        check.setText(custom);
	        
	        check = (CheckBox) findViewById(R.id.checkBox6);
	        custom = check.getText().toString();
	        custom = custom.replace("the baby", babyname);
	        custom = custom.replace("Baby", babyname);
	        check.setText(custom);
	        
	        check = (CheckBox) findViewById(R.id.checkBox7);
	        custom = check.getText().toString();
	        custom = custom.replace("the baby", babyname);
	        custom = custom.replace("Baby", babyname);
	        check.setText(custom);
	        
	        check = (CheckBox) findViewById(R.id.checkBox1);
	        custom = check.getText().toString();
	        custom = custom.replace("the baby", babyname);
	        custom = custom.replace("Baby", babyname);
	        check.setText(custom);
	        
	        check = (CheckBox) findViewById(R.id.checkBox2);
	        custom = check.getText().toString();
	        custom = custom.replace("the baby", babyname);
	        custom = custom.replace("Baby", babyname);
	        check.setText(custom);
	        
	        check = (CheckBox) findViewById(R.id.checkBox3);
	        custom = check.getText().toString();
	        custom = custom.replace("the baby", babyname);
	        custom = custom.replace("Baby", babyname);
	        check.setText(custom);
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.changeavatarname :
	        Intent start = new Intent(this, SetUp.class);
			startActivity(start);
	           return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	

}
