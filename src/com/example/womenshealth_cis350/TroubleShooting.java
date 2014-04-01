package com.example.womenshealth_cis350;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;

public class TroubleShooting extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.troubleshooting);
	}
	
	/*public boolean on(View v) {
		Intent start = new Intent(this, Pregnant.class);
		startActivity(start);

		return true;
	}
	*/
	public boolean onNoMilkClick(View v) {
		Intent start = new Intent(this, NotEnoughMilk.class);
		startActivity(start);

		return true;
	}
	
	public boolean onCrackedClick(View v) {
		Intent start = new Intent(this, NippleHurts.class);
		startActivity(start);

		return true;
	}
	
	public boolean onProviderClick(View v) {
		Intent start = new Intent(this, CallProvider.class);
		startActivity(start);

		return true;
	}
}
