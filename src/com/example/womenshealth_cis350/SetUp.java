package com.example.womenshealth_cis350;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff.Mode;

import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


public class SetUp extends Activity {	
	ImageButton img1;
	ImageButton img2;
	ImageButton img3;
	ImageButton img4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.set_up);
		
		img1 = (ImageButton) findViewById(R.id.imageButton1);
		img2 = (ImageButton) findViewById(R.id.imageButton2);
		img3 = (ImageButton) findViewById(R.id.imageButton3);
		img4 = (ImageButton) findViewById(R.id.imageButton4);
		
	}
	
	public boolean onSubmitClick(View v) {
		//get the information:
		String babyname = ((EditText)findViewById(R.id.babyname)).getText().toString();
		
	  SharedPreferences settings = getSharedPreferences(MainActivity.USER_PREFERENCES, 0);
	  SharedPreferences.Editor editor = settings.edit();
	  editor.putString("babyName", babyname); //put baby name there
	  
	  
	  editor.putBoolean("filledOut", true); //keep track of having filled out this form
	  editor.commit();
	
		Intent start = new Intent(this, LetsGetStarted.class);
		startActivity(start);
		return true;
	}
	
	public boolean onAvatarClick(View v) {
		//get rid of other filters
		img1.getBackground().setColorFilter(null);
		img2.getBackground().setColorFilter(null);
		img3.getBackground().setColorFilter(null);
		img4.getBackground().setColorFilter(null);
		//if(v.isSelected()) {
		
		//put filter on selected
		  v.getBackground().setColorFilter(R.color.white, Mode.SRC_ATOP);
          v.invalidate();
          
          SharedPreferences settings = getSharedPreferences(MainActivity.USER_PREFERENCES, 0);
    	  SharedPreferences.Editor editor = settings.edit();
    	  
    	  
    	  //which image was pressed?
    	  if(v.getId() == img1.getId()) {
    	  editor.putInt("avatar", R.drawable.avatar1);
    	  }
    	  else if(v.getId() == img2.getId()) {
        	  editor.putInt("avatar", R.drawable.avatar2);
        	  }
    	  else if(v.getId() == img3.getId()) {
        	  editor.putInt("avatar", R.drawable.avatar3);
        	  }
    	  else if(v.getId() == img4.getId()) {
        	  editor.putInt("avatar", R.drawable.avatar4);
        	  }
    	  //editor.putString("avatar",v.toString()); 
    	  editor.commit();
    
    	  
		
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
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
