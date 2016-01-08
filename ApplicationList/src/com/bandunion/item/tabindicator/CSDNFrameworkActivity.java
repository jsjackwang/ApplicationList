package com.bandunion.item.tabindicator;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;

import com.bandunion.adapter.CSDNViewpagerAdapter;
import com.bandunion.applist.R;
import com.bandunion.item.tabindicator.framework.TabPageIndicator;
import com.bandunion.util.Util;

public class CSDNFrameworkActivity extends FragmentActivity {
	private static String TAG = "CSDNFrameworkActivity";
	private ImageButton csdn_imageBtn;
	private ViewPager viewPager;
	private TabPageIndicator tabPageIndicator;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_csdn_layout);
		initViews();
		initListeners();
		viewPager.setAdapter(new CSDNViewpagerAdapter(getSupportFragmentManager()));
		tabPageIndicator.setViewPager(viewPager, 0);
	}

	private void initListeners() {
		csdn_imageBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Util.log(TAG, "csdn imagebtn onclick");
				Util.showToastShort("add slidingmenu");
			}
		});
	}

	private void initViews() {
		csdn_imageBtn = (ImageButton) findViewById(R.id.csdn_image_btn_title);
		viewPager = (ViewPager) findViewById(R.id.csdn_id_viewpager);
		tabPageIndicator = (TabPageIndicator) findViewById(R.id.csdn_tabpageindicator);
	}
}
