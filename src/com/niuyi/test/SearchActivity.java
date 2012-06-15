package com.niuyi.test;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SearchActivity extends Activity {
	
	static final String[] COUNTRIES = new String[] { "Afghanistan", "Albania",
		"Algeria", "American Samoa", "Andorra", "Angola", "Anguilla",
		"Antarctica", "Antigua and Barbuda", "Argentina", "Armenia",
		"Aruba", "Australia", "Austria", "Azerbaijan", "Bahrain",
		"Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin",
		"Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegovina",
		"Botswana", "Bouvet Island", "Brazil",
		"British Indian Ocean Territory", "British Virgin Islands",
		"Brunei", "Bulgaria", "Burkina Faso", "Burundi", "Cote d'Ivoire",
		"Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands",
		"Central African Republic", "Chad", "Chile", "China",
		"Christmas Island", "Cocos (Keeling) Islands", "Colombia",
		"Comoros", "Congo", "Cook Islands", "Costa Rica", "Croatia",
		"Cuba", "Cyprus", "Czech Republic",
		"Democratic Republic of the Congo", "Denmark", "Djibouti",
		"Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt",
		"El Salvador", "Equatorial Guinea", "Eritrea", "Estonia",
		"Ethiopia", "Faeroe Islands", "Falkland Islands", "Fiji",
		"Finland", "Former Yugoslav Republic of Macedonia", "France",
		"French Guiana", "French Polynesia", "French Southern Territories",
		"Gabon", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece",
		"Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala",
		"Guinea", "Guinea-Bissau", "Guyana", "Haiti",
		"Heard Island and McDonald Islands", "Honduras", "Hong Kong",
		"Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq",
		"Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan",
		"Kazakhstan", "Kenya", "Kiribati", "Kuwait", "Kyrgyzstan", "Laos",
		"Latvia", "Lebanon", "Lesotho", "Liberia", "Libya",
		"Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Madagascar",
		"Malawi", "Malaysia", "Maldives", "Mali", "Malta",
		"Marshall Islands", "Martinique", "Mauritania", "Mauritius",
		"Mayotte", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia",
		"Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia",
		"Nauru", "Nepal", "Netherlands", "Netherlands Antilles",
		"New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria",
		"Niue", "Norfolk Island", "North Korea", "Northern Marianas",
		"Norway", "Oman", "Pakistan", "Palau", "Panama",
		"Papua New Guinea", "Paraguay", "Peru", "Philippines",
		"Pitcairn Islands", "Poland", "Portugal", "Puerto Rico", "Qatar",
		"Reunion", "Romania", "Russia", "Rwanda", "Sqo Tome and Principe",
		"Saint Helena", "Saint Kitts and Nevis", "Saint Lucia",
		"Saint Pierre and Miquelon", "Saint Vincent and the Grenadines",
		"Samoa", "San Marino", "Saudi Arabia", "Senegal", "Seychelles",
		"Sierra Leone", "Singapore", "Slovakia", "Slovenia",
		"Solomon Islands", "Somalia", "South Africa",
		"South Georgia and the South Sandwich Islands", "South Korea",
		"Spain", "Sri Lanka", "Sudan", "Suriname",
		"Svalbard and Jan Mayen", "Swaziland", "Sweden", "Switzerland",
		"Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand",
		"The Bahamas", "The Gambia", "Togo", "Tokelau", "Tonga",
		"Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan",
		"Turks and Caicos Islands", "Tuvalu", "Virgin Islands", "Uganda",
		"Ukraine", "United Arab Emirates", "United Kingdom",
		"United States", "United States Minor Outlying Islands", "Uruguay",
		"Uzbekistan", "Vanuatu", "Vatican City", "Venezuela", "Vietnam",
		"Wallis and Futuna", "Western Sahara", "Yemen", "Yugoslavia",
		"Zambia", "Zimbabwe" };
	
	private AutoCompleteTextView textView;

	private SearchResultListAdapter searchResultListAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.search);
		textView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_dropdown_item_1line, COUNTRIES);
		textView.setAdapter(adapter);
		
		ListView searchResultListView = (ListView)findViewById(R.id.search_result_list);
		searchResultListView.setEmptyView(this.findViewById(R.id.empty));
		searchResultListAdapter = new SearchResultListAdapter(this);
		searchResultListView.setAdapter(searchResultListAdapter);
		
		Button searchButton = (Button)this.findViewById(R.id.search_button); 
		searchButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				String text = textView.getText().toString();
				searchResultListAdapter.addResult(text);
			}
			
		});
	}
	
	class SearchResultListAdapter extends BaseAdapter{
		
		private List<String> results = new ArrayList<String>();
		private final Context context;

		public SearchResultListAdapter(Context context){
			this.context = context;
		}

		@Override
		public int getCount() {
			return results.size();
		}

		@Override
		public Object getItem(int position) {
			return results.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			TextView textView = new TextView(context);
			textView.setText(results.get(position));
			textView.setPadding(3, 3, 3, 3);
			textView.setTextColor(Color.WHITE);
			textView.setTextSize(20);
			return textView;
		}
		
		public void addResult(String result){
			results.add(result);
			notifyDataSetChanged();
		}
		
	}
}
