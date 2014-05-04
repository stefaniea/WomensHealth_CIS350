package com.example.womenshealth_cis350;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class GoalSetting extends Activity implements OnItemSelectedListener {

	static TextView bubble;
	static SharedPreferences settings;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.goal_setting);
		Spinner spinner = (Spinner) findViewById(R.id.age_spinner);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		 R.array.goalsetting_array, R.layout.dropdown_blue);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(R.layout.spinner_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);
		
		settings = getSharedPreferences(MainActivity.USER_PREFERENCES, 0);

		//set correct avatar:
		ImageView avatar = (ImageView) findViewById(R.id.imageView1);
		int img = settings.getInt("avatar", R.drawable.avatar1);
		avatar.setImageResource(img);
		
		bubble = (TextView) this.findViewById(R.id.bubble_goalsetting);
		bubble.setVisibility(bubble.INVISIBLE); //set invisible before selected something
		
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
		TextView content = (TextView) findViewById(R.id.goal_setting_content);
		if(arg3 == 0) {
			bubble.setVisibility(bubble.INVISIBLE); //invisible again
			bubble.setText("");
			content.setText(R.string.empty);
		}
		if(arg3 == 1) {
			content.setText(R.string.days_gs); 
			bubble.setText("That's great!  Congratulations on making the comittment to feed " +
					"your baby for a few days in the hospital!");
			bubble.setVisibility(bubble.VISIBLE); //visible now
		}
		if(arg3 == 2) {
			content.setText(R.string.weeks_gs);
			bubble.setText("That's great!  Congratulations on making the comittment to feed " +
					"your baby for 1-3 weeks!");
			bubble.setVisibility(bubble.VISIBLE); //visible now
		}
		if(arg3 == 3) {
			content.setText(R.string.months_gs);
			bubble.setText("That's great!  Congratulations on making the comittment to feed " +
					"your baby for a 1-2 months!");
			bubble.setVisibility(bubble.VISIBLE); //visible now
		}
		if(arg3 == 4) {
			content.setText(R.string.three_months_gs);
			bubble.setText("That's great!  Congratulations on making the comittment to feed " +
					"your baby for 3 months!");
			bubble.setVisibility(bubble.VISIBLE); //visible now
		}
		if(arg3 == 5) {
			content.setText(R.string.four_months_gs);
			bubble.setText("That's great!  Congratulations on making the comittment to feed " +
					"your baby for 4 months!");
			bubble.setVisibility(bubble.VISIBLE); //visible now
		}
		if(arg3 == 6) {
			content.setText(R.string.six_months_gs);
			bubble.setText("That's great!  Congratulations on making the comittment to feed " +
					"your baby for 6 months!");
			bubble.setVisibility(bubble.VISIBLE); //visible now
		}
		if(arg3 == 7) {
			content.setText(R.string.morethan_six_months_gs);
			bubble.setText("That's great!  Congratulations on making the comittment to feed " +
					"your baby for greater than 6 months!");
			bubble.setVisibility(bubble.VISIBLE); //visible now
		}
		
		//replace your baby with name of baby if there is one
		String c = (String) content.getText();
		String babyname = settings.getString("babyName", "your baby");
		if(babyname.equals("")) babyname = "your baby";
		c = c.replace("your baby", babyname);
		c = c.replace("Your baby", babyname);
		c = c.replace("Your Baby", babyname);
		content.setText(c);
		
		c = (String) bubble.getText();
		if(!babyname.equals("")){
		c = c.replace("your baby",  "<b>"+babyname+"</b>");
		bubble.setText(Html.fromHtml(c));
		}
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
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
