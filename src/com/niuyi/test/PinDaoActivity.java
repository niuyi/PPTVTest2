package com.niuyi.test;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class PinDaoActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pindao);
		ListView listView =  (ListView)this.findViewById(R.id.listView1);
		listView.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, names));
		listView.setTextFilterEnabled(true);
		listView.setHeaderDividersEnabled(true);
	}
	
	private final String[] names = new String[]{
			"电影",
			"电视剧",
			"动漫",
			"游戏",
			"娱乐",
			"综艺",
			"热点",
			"体育",
			"生活",
			"旅游"
	};

}
