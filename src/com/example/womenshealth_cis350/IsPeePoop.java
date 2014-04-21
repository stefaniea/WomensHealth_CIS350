package com.example.womenshealth_cis350;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class IsPeePoop extends Activity implements OnItemSelectedListener {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.what_to_expect);
		Spinner spinner = (Spinner) findViewById(R.id.age_spinner);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		 R.array.peepoop_array, R.layout.dropdown_blue);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(R.layout.spinner_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		TextView content = (TextView) findViewById(R.id.age_content);
		if(arg3 == 1) {
			content.setText(R.string.dayone_pp);
		}
		if(arg3 == 2) {
			content.setText(R.string.daytwo_pp);
		}
		if(arg3 == 3) {
			content.setText(R.string.daythree_pp);
		}
		if(arg3 == 4) {
			content.setText(R.string.dayfour_pp);
		}
		if(arg3 == 5) {
			content.setText(R.string.dayfivesix_pp);
		}
		if(arg3 == 6) {
			content.setText(R.string.dayseven_pp);
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
