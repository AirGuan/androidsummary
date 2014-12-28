package com.jason.intentsummary.mainListView;

import java.util.ArrayList;
import java.util.HashMap;

import com.jason.intentsummary.MainIntentopenActivity;
import com.jason.intentsummary.R;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 
 * @author Administrator
 * 
 * 
 *         (1�������࣬�̳���BaseAdapter --->MyAdapter
 * 
 *         2����д���е��ĸ�����
 * 
 *         ��int��getCount()�����ص�������Դ����ĸ��������б�����
 * 
 *         ��Object��getItem(int position)������ָ��λ��position�ϵ��б�
 * 
 *         ��long��getItemId(int position)������ָ��λ�ô����Уɣ�
 * 
 *         ��View getView()�������б����Ӧ����ͼ����������
 * 
 *         ��ʵ������ͼ����� ----->holder = new ViewHolder();
 * 
 *         ������ͼ�����������Xml�ļ���ʵ������ͼ convertView =
 *         mInflater.inflate(R.layout.base_item, null); holder = new
 *         ViewHolder(); holder.title = (TextView) convertView
 *         .findViewById(R.id.ItemTitle); holder.text = (TextView) convertView
 *         .findViewById(R.id.ItemText); holder.bt = (Button)
 *         convertView.findViewById(R.id.ItemButton);
 *         convertView.setTag(holder);// ��ViewHolder����
 * 
 *         �����ݲ����ҵ��ؼ������������� holder.title = (TextView) convertView
 *         .findViewById(R.id.ItemTitle); holder.text = (TextView) convertView
 *         .findViewById(R.id.ItemText); holder.bt = (Button)
 *         convertView.findViewById(R.id.ItemButton);
 *         convertView.setTag(holder);// ��ViewHolder����
 * 
 *         ������View��ͼ ---->return convertView;
 * 
 */
public class BaseAdapterActivity extends Activity {

	private ListView lv;
	/* ����һ����̬���� */
	ArrayList<HashMap<String, Object>> listItem;
	
	private final int REQUEST_CODE = 1;

	private final String LOF_FLAG = "BaseAdapterActivity";

	/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.base_main);

		lv = (ListView) findViewById(R.id.listView);
		MyAdapter mAdapter = new MyAdapter(this);// �õ�һ��MyAdapter����
		lv.setAdapter(mAdapter);// ΪListView��Adapter /*ΪListView��ӵ���¼�*/

		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Toast.makeText(arg1.getContext(),
						"MyListViewBase ������ListView��Ŀ" + arg2, 1000).show();// ��LogCat�������Ϣ
			}
		});

	}/* ���һ���õ����ݵķ���������ʹ�� */
	
	
	/**
	 * ʹ��setResult�����
		startActivityForResult(it,REQUEST_CODE)������Activity��
	 */
	@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE){
            if(resultCode==RESULT_CANCELED)
                  setTitle("cancle");
            else if (resultCode==RESULT_OK) {
                 String temp=null;
                 Bundle bundle=data.getExtras();
                 if(bundle!=null)   temp=bundle.getString("name");
                 setTitle(temp);
            }
        }
    }

	private final String OPEN_ACTIVITY = "OPEN_ACTIVITY";
	private final String OPEN_OHONE_CALL = "OPEN_CALL";
	private final String OPEN_SEND_MASSAGE = "SEND_MESSAGE";
	private final String OPEN_SEND_MASSAGE_ATTACH = "SEND_MESSAGE_ATTACH";
	private final String OPEN_SEND_EMAIL = "OPEN_SEND_EMAIL";
	private final String OPEN_PLAY_MEDIA = "OPEN_PLAY_MEDIA";
	private final String OPEN_SEARCH = "OPEN_SEARCH";
	private final String OPEN_BROWSER = "OPEN_BROWSER";
	private final String OPEN_HIDE_INTENT = "OPEN_HIDE_INTENT";

	private ArrayList<HashMap<String, Object>> getDate() {

		ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
		/*
		 * Ϊ��̬�����������
		 * 
		 * 1.��AndroidManifest.xml��layout��xml�ļ���:
		 * android:text="@string/resource_name" 2.��activity�
		 * ����һ:this.getString(R.string.resource_name);
		 * ������:getResources().getString(R.string.resource_name);
		 * 3.������java�ļ���������Context��pplication�� ����һ:
		 * context.getString(R.string.resource_name); ������:
		 * application.getString(R.string.resource_name);
		 */
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("ItemTitle", this.getString(R.string.open_activity));
		map.put("ItemText", "");
		map.put("type", OPEN_ACTIVITY);
		listItem.add(map);
		map = new HashMap<String, Object>();
		map.put("ItemTitle", this.getString(R.string.open_phone_call));
		map.put("ItemText", "");
		map.put("type", OPEN_OHONE_CALL);

		listItem.add(map);
		map = new HashMap<String, Object>();
		map.put("ItemTitle", this.getString(R.string.send_message));
		map.put("ItemText", "");
		map.put("type", OPEN_SEND_MASSAGE);

		listItem.add(map);
		map = new HashMap<String, Object>();
		map.put("ItemTitle", this.getString(R.string.send_message_attach));
		map.put("ItemText", "");
		map.put("type", OPEN_SEND_MASSAGE_ATTACH);

		listItem.add(map);
		map = new HashMap<String, Object>();
		map.put("ItemTitle", this.getString(R.string.send_email));
		map.put("ItemText", "");
		map.put("type", OPEN_SEND_EMAIL);

		listItem.add(map);
		map = new HashMap<String, Object>();
		map.put("ItemTitle", this.getString(R.string.send_play_mp3));
		map.put("ItemText", "");
		map.put("type", OPEN_PLAY_MEDIA);

		listItem.add(map);
		map = new HashMap<String, Object>();
		map.put("ItemTitle", this.getString(R.string.send_search));
		map.put("ItemText", "");
		map.put("type", OPEN_SEARCH);

		listItem.add(map);
		map = new HashMap<String, Object>();
		map.put("ItemTitle", this.getString(R.string.send_open_browser));
		map.put("ItemText", "");
		map.put("type", OPEN_BROWSER);
		
		listItem.add(map);
		map = new HashMap<String, Object>();
		map.put("ItemTitle", this.getString(R.string.send_hide_intent));
		map.put("ItemText", "");
		map.put("type", OPEN_HIDE_INTENT);
		
		

		listItem.add(map);

		return listItem;

	}/*
	 * * �½�һ����̳�BaseAdapter��ʵ����ͼ�����ݵİ�
	 */

	private class MyAdapter extends BaseAdapter {
		private LayoutInflater mInflater;// �õ�һ��LayoutInfalter�����������벼�� /*���캯��*/

		public MyAdapter(Context context) {
			this.mInflater = LayoutInflater.from(context);
		}

		@Override
		public int getCount() {

			return getDate().size();// ��������ĳ���
		}

		@Override
		public Object getItem(int position) {
			return position;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		/* ������ϸ���͸÷��� */
		@Override
		public View getView(final int position, View convertView,
				ViewGroup parent) {
			ViewHolder holder;
			// �۲�convertView��ListView�������

			Log.v(LOF_FLAG, "getView " + position + " " + convertView);
			if (convertView == null) {
				convertView = mInflater.inflate(R.layout.base_item, null);
				holder = new ViewHolder();
				/* �õ������ؼ��Ķ��� */

				holder.title = (TextView) convertView
						.findViewById(R.id.ItemTitle);
				holder.text = (TextView) convertView
						.findViewById(R.id.ItemText);
				holder.bt = (Button) convertView.findViewById(R.id.ItemButton);
				convertView.setTag(holder);// ��ViewHolder����
			} else {
				holder = (ViewHolder) convertView.getTag();// ȡ��ViewHolder����
			}
			/* ����TextView��ʾ�����ݣ������Ǵ���ڶ�̬�����е����� */

			holder.title.setText(getDate().get(position).get("ItemTitle")
					.toString());
			holder.text.setText(getDate().get(position).get("ItemText")
					.toString());
			holder.bt.setText("Open");
			/* ΪButton��ӵ���¼� */
			holder.bt.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					Object type = getDate().get(position).get("type");
					/**
					 * // put Bundle Data Intent intent = new Intent("xxxxx");
					 * Bundle bundle = new Bundle(); bundle.putInt("id", 0);
					 * bundle.putString("name", "scott");
					 * intent.putExtras(bundle); startActivity(intent);
					 * 
					 * // get Bundle Data Bundle bundle = intent.getExtras();
					 * int id = bundle.getInt("id"); String name =
					 * bundle.getString("name"); or int id =
					 * intent.getIntExtra(); String name =
					 * intent.getStringExtra();
					 */
					if (type == OPEN_ACTIVITY) {
						Intent intent = new Intent(getApplication()
								.getBaseContext(), MainIntentopenActivity.class);
						String text = "���Ǵ�BaseAdapterActivity����Intent";
						intent.putExtra("text", text);
						//startActivity(intent);
						startActivityForResult(intent,REQUEST_CODE);
					}
					
					/**
					 * ��ʽIntent ��Ҫ Activity���� Filter action
					 */
					if (type == OPEN_HIDE_INTENT) {
						Intent it = new Intent();
						it.setAction("com.google.test");
						String text = "������ʽIntent";
						it.putExtra("text", text);
						startActivity(it);
					}

					/**
					 * Uri uri = Uri.parse("tel:10086"); Intent intent = new
					 * Intent(Intent.ACTION_DIAL, uri); startActivity(intent);
					 */
					if (type == OPEN_OHONE_CALL) {
						Uri uri = Uri.parse("tel:10086");
						Intent intent = new Intent(Intent.ACTION_DIAL, uri);
						startActivity(intent);
					}

					/***
					 * // ��10086��������Ϊ��Hello���Ķ��� Uri uri =
					 */
					if (type == OPEN_SEND_MASSAGE) {
						Uri uri = Uri.parse("smsto:10086");
						Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
						intent.putExtra("sms_body", "Hello");
						startActivity(intent);
					}

					/**
					 * // ���Ͳ��ţ��൱�ڷ��ʹ������Ķ��ţ� ��������ô���� ���� �����ʦ ��ɷ��ʼ���
					 */
					if (type == OPEN_SEND_MASSAGE_ATTACH) {
						Intent intent = new Intent(Intent.ACTION_SENDTO);
						intent.putExtra("sms_body", "Hello");
						Uri uri = Uri
								.parse("content://media/external/images/media/23");
						intent.putExtra(Intent.EXTRA_STREAM, uri);
						intent.setType("image/png");
						startActivity(intent);
					}

					/**
					 * 
					 */
					if (type == OPEN_SEND_EMAIL) {
						// Uri uri = Uri.parse("mailto:wuxianglong098@163.com");
						// Intent intent = new Intent(Intent.ACTION_SENDTO,
						// uri);
						// startActivity(intent);
						Intent intent = new Intent(Intent.ACTION_SEND);
						String[] tos = { "me@abc.com" };
						String[] ccs = { "you@abc.com" };
						intent.putExtra(Intent.EXTRA_EMAIL, tos);
						intent.putExtra(Intent.EXTRA_CC, ccs);
						intent.putExtra(Intent.EXTRA_TEXT,
								"The email body text");
						intent.putExtra(Intent.EXTRA_SUBJECT,
								"The email subject text");
						intent.setType("message/rfc822");
						startActivity(Intent.createChooser(intent,
								"Choose Email Client"));
					}

					/**
					 * play mp3
					 */
					if (type == OPEN_PLAY_MEDIA) {
						Intent intent = new Intent(Intent.ACTION_VIEW);
						Uri uri = Uri.parse("file:///sdcard/cwj.mp3");
						intent.setDataAndType(uri, "audio/mp3");
						startActivity(intent);
					}

					/**
					 * 
					 */

					if (type == OPEN_SEARCH) {
						Intent intent = new Intent();
						intent.setAction(Intent.ACTION_WEB_SEARCH);
						intent.putExtra(SearchManager.QUERY, "android");
						startActivity(intent);
					}

					/***
					 * 
					 */
					if (type == OPEN_BROWSER) {
						Uri uri = Uri.parse("http://www.baidu.com");
						Intent intent = new Intent(Intent.ACTION_VIEW, uri);
						startActivity(intent);
					}
					
				

				}
			});

			return convertView;
		}

	}/* ��ſؼ� */

	public final class ViewHolder {
		public TextView title;
		public TextView text;
		public Button bt;
	}
}
