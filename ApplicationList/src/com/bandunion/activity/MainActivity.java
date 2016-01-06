package com.bandunion.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.bandunion.adapter.MainListViewAdapter;
import com.bandunion.applist.R;
import com.bandunion.item.recyclerview.RecyclerViewDemoActivity;
import com.bandunion.util.Util;
import com.bandunion.vo.ItemDescription;


public class MainActivity extends Activity {
	private static String TAG = "MainActivity";
	private static List<ItemDescription> listDatas = new ArrayList<ItemDescription>();
    private ListView listview = null;

    static{
    	Util.log(TAG, "listDatas init");
    	listDatas.add(new ItemDescription("RecyclerViewDemo", RecyclerViewDemoActivity.class));
    }
  
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        listview.setAdapter(new MainListViewAdapter(listDatas));
        listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				ItemDescription item = (ItemDescription) view.getTag();
				Util.log(TAG, "item position --->" + position + " appName ---> " + item.getAppName());
				Util.startActivity(MainActivity.this, item.getCls());
			}
		});
    }

	private void initViews() {
		Util.log(TAG, "initViews init");
		listview = (ListView) findViewById(R.id.activity_main_list);
	}
}
