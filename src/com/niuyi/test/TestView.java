package com.niuyi.test;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


public class TestView extends View {

	private int total = 0;
	private int index = 0;

	public TestView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	public void setTotalAndIndex(int total, int index){
		this.total = total;
		this.index = index;
	}
	
	@Override
	public void onDraw(Canvas canvas){
		super.onDraw(canvas);
		int width = this.getWidth();
		int height = this.getHeight();
		int begin = (width - (total - 1)*20)/2;
		
		Paint whitePaint = new Paint();
		whitePaint.setColor(Color.WHITE);
		
		Paint grayPaint = new Paint();
		grayPaint.setColor(Color.GRAY);
		
		for(int i = 0 ; i < total ; i ++){
			if(i == index){
				canvas.drawCircle(begin + i*20, height/2, 3, whitePaint);
				continue;
			}
			canvas.drawCircle(begin + i*20, height/2, 3, grayPaint);
		}
		
		this.invalidate();
	}
}
