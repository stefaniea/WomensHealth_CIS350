package com.example.womenshealth_cis350;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PositioningLatch extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.positioninglatch);
	}
	
	public boolean onPacifierClick(View v) {
		Intent start = new Intent(this, Pacifier.class);
		startActivity(start);

		return true;
	}

}
