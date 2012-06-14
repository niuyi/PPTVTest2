package com.niuyi.test;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class TestView extends View {

	private static final int RADIUS = 3;
	private static final int SPAN = 20;
	private int total = 0;
	private int index = 0;
	private Paint whitePaint;
	private Paint grayPaint;
	private int begin;
	private int height;

	public TestView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public void setTotalAndIndex(int total, int index) {
		this.total = total;
		this.index = index;
		setUpPaint();
	}

	private void setUpPaint() {
		whitePaint = new Paint();
		whitePaint.setColor(Color.WHITE);

		grayPaint = new Paint();
		grayPaint.setColor(Color.GRAY);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		height = h / 2;
		begin = (w - (total - 1) * SPAN) / 2;
	}

	@Override
	public void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		for (int i = 0; i < total; i++) {
			if (i == index) {
				canvas.drawCircle(begin + i * 20, height, RADIUS, whitePaint);
				continue;
			}
			canvas.drawCircle(begin + i * 20, height, RADIUS, grayPaint);
		}

		this.invalidate();
	}
}
