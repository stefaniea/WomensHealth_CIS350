package com.example.womenshealth_cis350;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SuccessfulSteps extends Activity {
	TextView title;
	TextView content;
	String[] content_strings;
	String[] title_strings;
	int page;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.successful_steps);
		title = (TextView) this.findViewById(R.id.title_step);
		content = (TextView) this.findViewById(R.id.step_content);
		
		title.setText(R.string.title_rooming_in);
		content.setText(R.string.content_rooming_in);
		int page = 0;
	}
	
	public boolean onNextClick(View v) {
		if (page == 0) {
			content.setText(R.string.content_feeding);
			title.setText(R.string.title_feeding);
			page++;
		}
		if (page == 1) {
			content.setText(R.string.content_exclusivity);
			title.setText(R.string.title_exclusivity);
			page++;
		}
		if (page == 2) {
			content.setText(R.string.content_pacifier);
			title.setText(R.string.title_pacifier);
			Button btn = (Button) this.findViewById(R.id.steps_btn);
			btn.setText("Back to Pregnant Page");
			page++;
		}
		if (page == 3) {
			page = 0;
			Intent start = new Intent(this, Pregnant.class);
			startActivity(start);
		}
		
		return true;
	}
	
}
