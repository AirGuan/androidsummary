package com.example.widgetsummary.activity;

import com.example.widgetsummary.R;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerActivity extends ActionBarActivity  implements OnItemSelectedListener{
	
	private String[] items=   {"lorem", "ipsum", "dolor", "sit", "amet"};
	private Spinner spin;
	private TextView label;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spinner);
		//�ڶ���������ʾspinnerû��չ��ǰ��UI����
		ArrayAdapter<String> aa = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,items); 
		spin = (Spinner) findViewById(R.id.spinner);
		spin.setOnItemSelectedListener(this); 
		spin.setAdapter(aa); //֮ǰ�Ѿ�ͨ��Spinner spin = (Spinner) findViewById(R.id.spinner);����ȡspin���� 
		label = (TextView) findViewById(R.id.spinner_label);
		aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.spinner, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	public void gotoSpinner(View v){
		spin.forceLayout();
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		  label.setText(items[position]); //label���������õĵ�һ��TextView widget��arg2����Ԫ�ص�pos��Ҫ 
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		 label.setText(""); 
	}
}
