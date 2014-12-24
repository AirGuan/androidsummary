package com.jason.listviewoverview.adapter.simpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.jason.listviewoverview.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SimpleAdapter;
import android.widget.Spinner;



public class SimpleAdapterSpinner extends Activity {
    //����Spinner
    private Spinner sp;
    //����Adapter
    private SimpleAdapter adapter;
    //����Դ
    private String[] data = { "���ǵ�1���б���", "���ǵ�2���б���", "���ǵ�3���б���", "���ǵ�4���б���",
            "���ǵ�5���б���", "���ǵ�6���б���", "���ǵ�7���б���", "���ǵ�8���б���", "���ǵ�9���б���" };// ����Դ-->M
    //�������Դ
    ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_spinner);
        //�ҵ�Spinner
        sp = (Spinner) findViewById(R.id.spinner1);
        //��������ӵ�List<Map>�У���ΪSimpleAdapterֻ��װ����������
        Map<String, Object> map;
        for (int i = 0; i < data.length; i++) {
            map = new HashMap<String, Object>();
            map.put("data", data[i]);
            list.add(map);
        }
        //ʵ����Adapter
        adapter = new SimpleAdapter(this, list, R.layout.simple_spinner_cell, new String[] {
                "data"},
                new int[] { R.id.textView1 });
        //��Adapter��Spinner��
        sp.setAdapter(adapter);
    }
}

