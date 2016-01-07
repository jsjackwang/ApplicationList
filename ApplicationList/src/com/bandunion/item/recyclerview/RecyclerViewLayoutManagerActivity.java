package com.bandunion.item.recyclerview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;

import com.bandunion.applist.R;
import com.bandunion.util.Util;

public class RecyclerViewLayoutManagerActivity extends Activity{
	private static String TAG = "RecyclerViewLayoutManagerActivity";
	private RecyclerView recyclerView;
	private List<String> listDatas;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_recyclerview_layout_manager);
		initViews();
		initDatas();
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
//		recyclerView.setAdapter(new RecyclerViewAdapter());
//		recyclerView.addItemDecoration(decor);
//		recyclerView.setAnimation(animation);
	}

	private void initDatas() {
		Util.log(TAG, "init listDatas");
		listDatas = new ArrayList<String>();
		for(int i='A'; i <= 'Z'; i++){
			listDatas.add("" + (char)i);
		}
	}

	private void initViews() {
		recyclerView = (RecyclerView) findViewById(R.id.recyclerview_layout_manager);
	}
}
