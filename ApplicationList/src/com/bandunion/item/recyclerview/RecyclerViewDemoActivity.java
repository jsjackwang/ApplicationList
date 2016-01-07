package com.bandunion.item.recyclerview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.bandunion.applist.R;
import com.bandunion.util.Util;

public class RecyclerViewDemoActivity extends Activity{
	private static String TAG = "RecyclerViewDemoActivity";
	private Button btn_listview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_recyclerview);
		initViews();
		initListeners();
	}

	private void initListeners() {
		setBtnOnclickListener(btn_listview, RecyclerViewLayoutManagerActivity.class);
	}

	private void setBtnOnclickListener(View view, final Class<?> cls){
		view.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Util.log(TAG, "where activity---> " + cls.getSimpleName());
				Intent intent = new Intent(RecyclerViewDemoActivity.this, cls);
				startActivity(intent);
			}
		});
	}
	
	private void initViews() {
		btn_listview = (Button) findViewById(R.id.recyclerview_btn_listview);
		TextView tv_header = (TextView) findViewById(R.id.main_item_tv_header);
		tv_header.setText("RecyclerView”¶”√");
	}
}
