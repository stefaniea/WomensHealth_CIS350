package com.example.womenshealth_cis350;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SuccessfulSteps extends Activity {
	static TextView title;
	static TextView content;
	static Button btn;
	String[] content_strings;
	String[] title_strings;
	int page;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.successful_steps);
		title = (TextView) this.findViewById(R.id.title_step);
		content = (TextView) this.findViewById(R.id.step_content);
		btn = (Button) this.findViewById(R.id.step_button);
		
		title.setText(R.string.title_rooming_in);
		content.setText(R.string.content_rooming_in);
		page = 0;
		
	}
	
	public boolean onNextStep(View v) {
		if (page == 0) {
		   content.setText(R.string.content_feeding);
			title.setText(R.string.title_feeding);
			page++;
		}
		else if (page == 1) {
			content.setText(R.string.content_exclusivity);
			title.setText(R.string.title_exclusivity);
			page++;
		}
		else if (page == 2) {
			content.setText(R.string.content_pacifier);
			title.setText(R.string.title_pacifier);
			btn.setText(R.string.back_first_step);
			page++;
		}
		else if (page == 3) {
			page = 0;
			//btn.setText(R.string.back_first_step);
			title.setText(R.string.title_rooming_in);
			content.setText(R.string.content_rooming_in);
		}
		
		return true;
	}
	
}
