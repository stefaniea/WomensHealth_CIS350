package com.example.womenshealth_cis350;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class BreastfeedingNo extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.breastfeedingno);
	}
	
	public boolean onDidYouKnowClick(View v) {
		Intent start = new Intent(this, BenefitsOfBreastfeeding.class);
		start.putExtra("activity","second");
		
		startActivity(start);
		return true;
	}
	
	public boolean mythBustersClick(View v) {
		Intent start = new Intent(this, MythBusters.class);
		startActivity(start);

		return true;
	}
	
	public boolean costsOfFormulaClick(View v) {
		Intent start = new Intent(this, CostFormula.class);
		startActivity(start);

		return true;
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

