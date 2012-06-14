package com.niuyi.test;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;

public class PPTVActivity extends TabActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Resources resources = this.getResources();
		TabHost tabHost = this.getTabHost();

		tabHost.addTab(tabHost
				.newTabSpec("TuiJian")
				.setIndicator(getString(R.string.tuijian), resources.getDrawable(R.drawable.tabs))
				.setContent(new Intent(this, TuiJianActivity.class)));

		tabHost.addTab(tabHost.newTabSpec(getString(R.string.pindao))
				.setIndicator(getString(R.string.pindao), resources.getDrawable(R.drawable.tabs))
				.setContent(new Intent(this, PinDaoActivity.class)));

		tabHost.addTab(tabHost.newTabSpec(getString(R.string.zhibo))
				.setIndicator(getString(R.string.zhibo), resources.getDrawable(R.drawable.tabs))
				.setContent(new Intent(this, ZhiBoActivity.class)));
		
		tabHost.addTab(tabHost.newTabSpec(getString(R.string.search))
				.setIndicator(getString(R.string.search), resources.getDrawable(R.drawable.tabs))
				.setContent(new Intent(this, SearchActivity.class)));

		tabHost.addTab(tabHost.newTabSpec(getString(R.string.personal))
				.setIndicator(getString(R.string.personal), resources.getDrawable(R.drawable.tabs))
				.setContent(new Intent(this, PersonalActivity.class)));
		
		tabHost.setCurrentTab(0);

	}
}