package com.niuyi.test;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class PinDaoActivity extends Activity {
	
	private class EfficientAdapter extends BaseAdapter {
        private LayoutInflater flater;
        private Bitmap icon;

        public EfficientAdapter(Context context) {
            flater = LayoutInflater.from(context);
            icon = BitmapFactory.decodeResource(context.getResources(), R.drawable.label_icon);
        }

        public int getCount() {
            return names.length;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = flater.inflate(R.layout.list_item, null);
                holder = new ViewHolder();
                
                holder.text = (TextView) convertView.findViewById(R.id.text);
                holder.icon = (ImageView) convertView.findViewById(R.id.icon);
                holder.activity = MovieActivity.class;
                
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.text.setText(names[position]);
            holder.icon.setImageBitmap(icon);

            return convertView;
        }
    }
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pindao);
		ListView listView =  (ListView)this.findViewById(R.id.listView1);
		listView.setAdapter(new EfficientAdapter(this));
		
		listView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Object tag = view.getTag();
				if(tag != null){
					Intent intent = new Intent(PinDaoActivity.this, ((ViewHolder)tag).activity);
					startActivity(intent);
				}
			}
			
		});
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
	
	class ViewHolder {
        TextView text;
        ImageView icon;
        Class activity;
    }
}