package com.bandunion.adapter;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bandunion.fragment.TabPageIndicatorFragment;
import com.bandunion.util.Util;

public class CSDNViewpagerAdapter extends FragmentPagerAdapter {
	private static String TAG = "CSDNViewpagerAdapter";
	public static List<String> listDatas;
	
	static {
		Util.log(TAG, "csdn viewpager init data");
		listDatas = new ArrayList<String>();
		listDatas.add("业界");
		listDatas.add("移动");
		listDatas.add("研发");
		listDatas.add("程序员");
		listDatas.add("云计算");
		listDatas.add("IOS");
		listDatas.add("Android");
		listDatas.add("大数据");
		listDatas.add("极客");
	}
	
	public CSDNViewpagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public TabPageIndicatorFragment getItem(int position) {
		Util.log(TAG, "fragment postion ----->" + position + "--" + getPageTitle(position));
		return new TabPageIndicatorFragment(position);
	}
	
	@Override
	public CharSequence getPageTitle(int position) {
		return listDatas.get(position % getCount());
	}

	@Override
	public int getCount() {
		return listDatas.size();
	}

}
