package com.example.womenshealth_cis350;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SetUp extends Activity {	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.set_up);
		
	}
	
	public boolean onSubmitClick(View v) {
		//get the information:
		String babyname = ((EditText)findViewById(R.id.babyname)).getText().toString();
		String username = ((EditText)findViewById(R.id.yourname)).getText().toString();
		
	  SharedPreferences settings = getSharedPreferences(MainActivity.USER_PREFERENCES, 0);
	  SharedPreferences.Editor editor = settings.edit();
	  editor.putString("babyName", babyname); //put baby name there
	  editor.putString("userName", username);
	  
	  editor.putBoolean("filledOut", true); //keep track of having filled out this form
	  editor.commit();
	
		Intent start = new Intent(this, LetsGetStarted.class);
		startActivity(start);
		return true;
	}
	
	
	
}
