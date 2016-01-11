package com.bandunion.item.basewidget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.bandunion.applist.R;

public class AndroidBaseWidgetUseActivity extends Activity {
	private TextView tvHeader;
	private Button btnWebView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_androidbase_widgetuse_layout);
		initViews();
		initListeners();
		initDatas();
	}

	private void initDatas() {
		tvHeader.setText("Android基本组件应用");
	}

	private void initListeners() {
		setBtnOnClickListener(btnWebView, WebViewActivity.class);
	}

	private void setBtnOnClickListener(Button btn,
			final Class<? extends Activity> cls) {
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// Util.startActivity(AndroidBaseWidgetUseActivity.this, cls);
				Intent intent = new Intent(AndroidBaseWidgetUseActivity.this, WebViewActivity.class);
				startActivity(intent);
			}
		});
	}

	private void initViews() {
		tvHeader = (TextView) findViewById(R.id.main_item_tv_header);
		btnWebView = (Button) findViewById(R.id.btn_basewidget_webview);
	}
}
