package com.example.womenshealth_cis350;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class References extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.references);
	}
	
	
	public boolean Mayo_ClinicClick(View v) {
		String url = "http://www.mayoclinic.org/healthy-living/infant-and-toddler-health/multimedia/breast-feeding/sls-20076017?s=5";
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url));
		startActivity(i);
		return true;
	}
	
	public boolean Mayo_Clinic_PacifierClick(View v) {
		String url = "http://www.mayoclinic.org/healthy-living/infant-and-toddler-health/in-depth/pacifiers/art-20048140?footprints=mine";
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url));
		startActivity(i);
		return true;
	}
	
	public boolean laLecheLeagueClick(View v) {
		String url = "http://www.llli.org/faq/enough.html";
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url));
		startActivity(i);
		return true;
	}
	
	public boolean WIC_FeedingCuesClick(View v) {
		String url = "http://www.nal.usda.gov/wicworks/WIC_Learning_Online/support/job_aids/cues.pdf";
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url));
		startActivity(i);
		return true;
	}
	
	public boolean Womenshealth_govClick(View v) {
		String url = "http://www.womenshealth.gov/breastfeeding/common-challenges/";
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url));
		startActivity(i);
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
