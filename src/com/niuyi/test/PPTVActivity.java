package com.niuyi.test;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.Toast;

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
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		MenuInflater menuInflater = this.getMenuInflater();
		menuInflater.inflate(R.menu.title_icon, menu);
		return true;
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.happy:
                Toast.makeText(this, "Happy!", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.neutral:
                Toast.makeText(this, "Neutral", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.sad:
            	Toast.makeText(this, "Sad", Toast.LENGTH_SHORT).show();
                return true;
                
            case R.id.simple:
            	Toast.makeText(this, "Simple", Toast.LENGTH_SHORT).show();
                return true;
            
        }
        return false;
    }
}