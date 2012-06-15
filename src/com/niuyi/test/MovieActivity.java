package com.niuyi.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.PopupWindow;
import android.widget.TextView;

public class MovieActivity extends Activity {
	private PopupWindow popupWindow;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.movie);
		GridView gridView = (GridView)findViewById(R.id.gridview1);
		gridView.setAdapter(new ImageAdapter(this));
		
		Button button = (Button)findViewById(R.id.button1);
		button.setBackgroundDrawable(this.getResources().getDrawable(R.drawable.corners_button));
		
		button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				if(popupWindow == null){
					View popup = MovieActivity.this.getLayoutInflater().inflate(R.layout.pop, null, true);
					popupWindow = new PopupWindow(popup, 100, 200, true);
					popupWindow.setOutsideTouchable(true);  
					popup.setOnTouchListener(new OnTouchListener(){

						@Override
						public boolean onTouch(View v, MotionEvent event) {
							if(popupWindow != null && popupWindow.isShowing()){
								popupWindow.dismiss();
								popupWindow = null;
								return true;
							}
							return false;
						}
						
					});
				}
				
				
				popupWindow.showAsDropDown(v);
			}
			
		});
	}

}
