package com.example.womenshealth_cis350;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;

public class PositioningLatch extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.positioninglatch);
		SharedPreferences settings = getSharedPreferences(MainActivity.USER_PREFERENCES, 0);
		String babyname = settings.getString("babyName", "");
		if(!babyname.equals("")) {
		
		//replace button names with baby name
		Button b = (Button) findViewById(R.id.gettingEnough_btn);
		    String custom = b.getText().toString();
	    	custom = custom.replace("your baby", "<b>"+babyname+"</b>");
	    	custom = custom.replace("my baby", "<b>"+babyname+"</b>");
			b.setText(Html.fromHtml(custom));
		
		b = (Button) findViewById(R.id.latchedOn_btn);
		  custom = b.getText().toString();
	        custom = custom.replace("your baby", "<b>"+babyname+"</b>");
	        custom = custom.replace("my baby", "<b>"+babyname+"</b>");
			b.setText(Html.fromHtml(custom));
		
	    	b = (Button) findViewById(R.id.howHungry_btn);
			    custom = b.getText().toString();  
		        custom = custom.replace("your baby", "<b>"+babyname+"</b>");
		    	custom = custom.replace("my baby", "<b>"+babyname+"</b>");
				b.setText(Html.fromHtml(custom));
		}
	}
	
	public boolean onPacifierClick(View v) {
		Intent start = new Intent(this, Pacifier.class);
		startActivity(start);

		return true;
	}
	
	public boolean onLatchedClick(View v) {
		Intent start = new Intent(this, LatchingCorrectly.class);
		startActivity(start);

		return true;
	}
	
	public boolean isBabyHungryClick(View v) {
		Intent start = new Intent(this, BabyHungry.class);
		startActivity(start);
// -- add this   android:onClick="isBabyHungry" >
		return true;
	}
	
	public boolean onPositionsClick(View v) {
		Intent start = new Intent(this, DifferentPositions.class);
		startActivity(start);
		
		return true;
	}
	
	public boolean onEnoughClick(View v) {
		Intent start = new Intent(this, BabyGettingEnoughMilk.class);
		startActivity(start);
		
		return true;
	}
	
	
	

}
