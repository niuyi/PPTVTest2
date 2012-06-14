package com.niuyi.test;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SearchActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		TextView view = new TextView(this);
		view.setText("Search");
		
		setContentView(view);
	}
}
