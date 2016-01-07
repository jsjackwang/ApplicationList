package com.bandunion.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bandunion.adapter.CSDNViewpagerAdapter;
import com.bandunion.applist.R;
import com.bandunion.util.Util;


public class TabPageIndicatorFragment extends Fragment{

	private int fragmentType;
	
	public TabPageIndicatorFragment(int position) {
		this.fragmentType = position;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = Util.Inflate(R.layout.csdn_viewpager_item);
		TextView content = (TextView) view.findViewById(R.id.csdn_content_tv);
		content.setText(CSDNViewpagerAdapter.listDatas.get(fragmentType));
		return view;
	}
}
