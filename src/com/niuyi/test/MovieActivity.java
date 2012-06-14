package com.niuyi.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

public class MovieActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.movie);
		GridView gridView = (GridView)findViewById(R.id.gridview1);
		gridView.setAdapter(new ImageAdapter(this));
		
		Button button = (Button)findViewById(R.id.button1);
		button.setBackgroundDrawable(this.getResources().getDrawable(R.drawable.corners_bg));
	}

}
