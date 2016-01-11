package com.bandunion.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.bandunion.adapter.MainListViewAdapter;
import com.bandunion.applist.R;
import com.bandunion.util.Util;
import com.bandunion.vo.ItemDescription;


public class MainActivity extends Activity {
	private static String TAG = "MainActivity";
	private static List<ItemDescription> listDatas = new ArrayList<ItemDescription>();
    private ListView listview = null;
	private TextView tv_header;

    static{
    	Util.log(TAG, "listDatas init");
    	listDatas.add(new ItemDescription("RecyclerViewDemo", "RECYCLERVIEWDEMOACTIVITY"));
    	listDatas.add(new ItemDescription("TabPageIndicatorDemo", "TABINDICATORACTIVITY"));
    	listDatas.add(new ItemDescription("AndroidBaseWidgetUseDemo", "ANDROIDBASEWIDGETUSEACTIVITY"));
    }
  
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initViews();
        listview.setAdapter(new MainListViewAdapter(listDatas));
        listview.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Button btn = (Button) view.findViewById(R.id.main_listview_item);
				ItemDescription item = (ItemDescription) btn.getTag();
				Util.log(TAG, "item position --->" + position + " appName ---> " + item.getAppName());
				Intent intent = new Intent();
				intent.setAction(item.getClassName());
				startActivity(intent);
			}
		});
    }

	private void initViews() {
		Util.log(TAG, "initViews init");
		listview = (ListView) findViewById(R.id.activity_main_list);
		tv_header = (TextView) findViewById(R.id.main_item_tv_header);
		tv_header.setText("DemoList");
	}
}
