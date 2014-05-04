package com.example.womenshealth_cis350;

import java.text.BreakIterator;
import java.util.Locale;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.Toast;

public class BabyHungry extends Activity implements OnItemSelectedListener {
	PopupWindow popUp;
	LinearLayout layout;
	TextView tv;
	LayoutParams params;
	View v;
	boolean dismissPop = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.baby_hungry);
		Spinner spinner = (Spinner) findViewById(R.id.hungry_spinner);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
				R.array.hungry_array, R.layout.dropdown_blue);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(R.layout.spinner_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);


		// for definition pop-up
		layout = new LinearLayout(this);
		layout.setBackgroundColor(this.getResources().getColor(R.color.coloryellow));

		layout.setPadding(20,20, 20, 20);

		popUp = new PopupWindow(this);
		tv = new TextView(this);
		params = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
		layout.setOrientation(LinearLayout.VERTICAL);
		popUp.setHeight(90);
		popUp.setWidth(90);

		tv.setText("Rooting is a type of reflex that your baby may do in response to his/her cheek being stroked. " +
				"Your baby may turn his/her head and make sucking movements towards your chest/nipple.");

		tv.setTextSize(10);
		tv.setTextColor(this.getResources().getColor(R.color.colorred));
		layout.addView(tv, params);
		

		popUp.setContentView(layout);

		popUp.setBackgroundDrawable(new BitmapDrawable()); //gets rid of border
		v = this.findViewById(android.R.id.content);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	//touch anywhere and popup goes away
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		popUp.dismiss();
		dismissPop = true;
		return true;
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {

		TextView content = (TextView) findViewById(R.id.hungry_content);
		//position = at birth
		if(arg3==0) {
			content.setText(R.string.ishungry);
		}
		if(arg3 == 1) {
			content.setText(R.string.birth_5_hungry);
		}
		if(arg3 == 2) {
			content.setText(R.string.month_4_6_hungry);
		}
		if(arg3 == 3) {
			content.setText(R.string.month_5_9_hungry);
		}
		if(arg3 == 4) {
			content.setText(R.string.month_10_12_hungry);
		}

		init();

	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}

	private void init() {
		TextView definitionView = (TextView) findViewById(R.id.hungry_content);
		String definition = definitionView.getText().toString();

		definitionView.setMovementMethod(LinkMovementMethod.getInstance());
		definitionView.setText(definition, BufferType.SPANNABLE);
		Spannable spans = (Spannable) definitionView.getText();
		BreakIterator iterator = BreakIterator.getWordInstance(Locale.US);
		iterator.setText(definition);

		int start = iterator.first();
		for (int end = iterator.next(); end != BreakIterator.DONE; start = end, end = iterator
				.next()) {
			String possibleWord = definition.substring(start, end);
			if (possibleWord.equalsIgnoreCase("rooting")) {
				if (Character.isLetterOrDigit(possibleWord.charAt(0))) {
					ClickableSpan clickSpan = getClickableSpan(possibleWord);
					spans.setSpan(clickSpan, start, end,
							Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
				}
			}
		}
	}

	private ClickableSpan getClickableSpan(final String word) {
		return new ClickableSpan() {
			//final String mWord = "Rooting is a type of reflex that your baby may do in response to his/her cheek being stroked.  " +
			//		"Your baby may turn his/her head and make sucking movements towards your chest/nipple.";

			@Override
			public void onClick(View widget) {
				//Log.d("tapped on:", mWord);
				//Toast.makeText(widget.getContext(), mWord, Toast.LENGTH_LONG).show();
				if (!dismissPop) {
					popUp.showAtLocation(v, Gravity.CENTER, 10, 10);
					popUp.update((int) v.getWidth()/2, 200);

				} else {
					popUp.dismiss();
				}
				dismissPop = !dismissPop;
			}

			public void updateDrawState(TextPaint ds) {
				super.updateDrawState(ds);
			}
		};
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
