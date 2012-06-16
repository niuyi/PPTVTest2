package com.niuyi.test;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class TuiJianActivity extends Activity {

	private ViewFlipper viewFlipper = null;

	private final Integer[] images = { 
			R.drawable.image1, R.drawable.image2,
			R.drawable.image3, R.drawable.image4 };

	private final String[] imageDescription = { "冲浪的人", "绿地生活", "爱在太平洋", "维多利亚花园" };
	private Handler handler;
	private Timer timer = new Timer();
	private ImageTask task;
	private TextView imageDescriptionTextView;

	private GestureDetector gestureDetector;
	private OnTouchListener gestureListener;

	private Animation lInAnim;
	private Animation lOutAnim;
	private Animation rInAnim;
	private Animation rOutAnim;

	private TestView testView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tuijian);
		setUpFlip();
		setUpGridView();
	}

	private void setUpGridView() {
		GridView gridView = (GridView) this.findViewById(R.id.gridview1);
		gridView.setAdapter(new ImageAdapter(this));
	}

	private void setUpFlip() {
		viewFlipper = (ViewFlipper) this.findViewById(R.id.viewflipper);

		gestureDetector = new GestureDetector(new MyGestureDetector());
		gestureListener = new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				return gestureDetector.onTouchEvent(event);
			}
		};

		for (int i = 0; i < images.length; i++) {
			viewFlipper.addView(createImageView(i), new LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		}

		setUpAnimation();

		imageDescriptionTextView = (TextView) this.findViewById(R.id.textView2);
		testView = (TestView) this.findViewById(R.id.testView1);
		testView.setTotalAndIndex(imageDescription.length, 0);

		handler = new Handler() {
			public void handleMessage(Message message) {
				flipRight();
			}
		};
	}

	private void setUpAnimation() {
		lInAnim = AnimationUtils.loadAnimation(TuiJianActivity.this,
				R.anim.push_left_in);
		lOutAnim = AnimationUtils.loadAnimation(TuiJianActivity.this,
				R.anim.push_left_out);
		rInAnim = AnimationUtils.loadAnimation(TuiJianActivity.this,
				R.anim.push_right_in);
		rOutAnim = AnimationUtils.loadAnimation(TuiJianActivity.this,
				R.anim.push_right_out);
	}

	private ImageView createImageView(int i) {
		ImageView view = new ImageView(this);
		view.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT));
		view.setScaleType(ImageView.ScaleType.FIT_START);
		view.setImageResource(images[i]);

		view.setOnTouchListener(gestureListener);
		view.setLongClickable(true);
		view.setTag(new ImageDescriptionHolder(imageDescription[i], i));
		return view;
	}

	@Override
	public void onResume() {
		super.onResume();
		setTask();
	}

	private void setTask() {
		if (task != null)
			task.cancel();

		task = new ImageTask();
		timer.schedule(task, 5000, 5000);
	}

	public void onPause() {
		super.onPause();
		if (task != null)
			task.cancel();
	}

	private void flipRight() {
		viewFlipper.setInAnimation(lInAnim);
		viewFlipper.setOutAnimation(lOutAnim);
		viewFlipper.showNext();
		changeDisplay();
	}

	private void flipLeft() {
		viewFlipper.setInAnimation(rInAnim);
		viewFlipper.setOutAnimation(rOutAnim);
		viewFlipper.showPrevious();
		changeDisplay();
	}

	private void changeDisplay() {
		ImageDescriptionHolder holder = (ImageDescriptionHolder) viewFlipper
				.getCurrentView().getTag();
		imageDescriptionTextView.setText(holder.description);
		testView.setTotalAndIndex(imageDescription.length, holder.index);
	}

	class ImageTask extends TimerTask {
		public void run() {
			Message message = handler.obtainMessage();
			handler.sendMessage(message);
		}
	}

	class MyGestureDetector extends SimpleOnGestureListener {

		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			if (e2.getX() - e1.getX() > 80) { // 从左向右滑动（左进右出）
				flipLeft();
			} else if (e2.getX() - e1.getX() < -80) { // 从右向左滑动（右进左出）
				flipRight();
			}
			setTask();
			return true;
		}

	}

	class ImageDescriptionHolder {
		public final String description;
		public final int index;

		public ImageDescriptionHolder(String description, int index) {
			this.description = description;
			this.index = index;

		}
	}
}
