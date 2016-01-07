package com.bandunion.item.tabindicator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.bandunion.applist.R;

public class TabIndicatorActivity extends Activity {
	private Button btn_csdn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tabindicator_layout_manager);
		initViews();
		initListeners();
	}

	private void initListeners() {
		setOnclickListener(btn_csdn, CSDNFrameworkActivity.class);
	}

	private void setOnclickListener(View view,
			final Class<?> cls) {
		view.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(TabIndicatorActivity.this, cls);
				startActivity(intent);
			}
		});
	}

	private void initViews() {
		btn_csdn = (Button) findViewById(R.id.tabindicator_btn_csdn);
		TextView tv_header = (TextView) findViewById(R.id.main_item_tv_header);
		tv_header.setText("TabPageIndicator”¶”√");
	}
}
