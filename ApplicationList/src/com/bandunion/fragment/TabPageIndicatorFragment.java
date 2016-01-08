package com.bandunion.fragment;

import java.util.ArrayList;
import java.util.List;

import me.maxwin.view.IXListViewLoadMore;
import me.maxwin.view.IXListViewRefreshListener;
import me.maxwin.view.XListView;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bandunion.adapter.CSDNViewpagerAdapter;
import com.bandunion.adapter.CSDNXListViewAdapter;
import com.bandunion.applist.R;
import com.bandunion.data.factory.CSDNNewsItemFactory;
import com.bandunion.util.Util;
import com.bandunion.vo.CSDNNewsItem;


public class TabPageIndicatorFragment extends Fragment implements IXListViewRefreshListener, IXListViewLoadMore{
	private static String TAG = "TabPageIndicatorFragment";
	private int fragmentType = CSDNNewsItemFactory.NEW_TYPE_YEJIE;
	private XListView xListView;
	private int currentPage = 1;
	private List<CSDNNewsItem> listDatas = new ArrayList<CSDNNewsItem>();
	private CSDNXListViewAdapter adapter;
	
	public TabPageIndicatorFragment(int newType) {
		Util.log(TAG, "TabPageIndicatorFragment init");
		this.fragmentType = newType;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Util.log(TAG, "onCreateView......");
		View view = null;
		if(fragmentType > 4){
			Util.log(TAG, "the current page is " + fragmentType);
			view = Util.Inflate(R.layout.csdn_viewpager_fragment_layout);
			TextView content = (TextView) view.findViewById(R.id.csdn_content_tv);
			content.setText(CSDNViewpagerAdapter.listDatas.get(fragmentType));
		}else{
			Util.log(TAG, "the current page is " + fragmentType);
			view = Util.Inflate(R.layout.csdn_viewpager_fragment_layout_use);
			xListView = (XListView) view.findViewById(R.id.csdn_fragment_xlistview);
		}
		return view;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		Util.log(TAG, "the current page is " + fragmentType + " onActivityCreated ---> xlistview" + xListView);
		if(xListView != null){
			Util.log(TAG, "xListView is not null");
			adapter = new CSDNXListViewAdapter(getActivity(), listDatas);
			xListView.setAdapter(adapter);
			xListView.setPullRefreshEnable(this);
			xListView.setPullLoadEnable(this);
			xListView.startRefresh();
			onLoadMore();
		}
		super.onActivityCreated(savedInstanceState);
	}
	
	@Override
	public void onLoadMore() {
		Util.log(TAG, "xListView onloadMore");
		new LoadDataTask().execute();
	}

	@Override
	public void onRefresh() {
		Util.log(TAG, "xListView onRefresh");
		
	}
	
	class LoadDataTask extends AsyncTask<Void, Void, Void>{

		@Override
		protected Void doInBackground(Void... params) {
			Util.log(TAG, "doInBackground to get data");
			listDatas = CSDNNewsItemFactory.getNewsItemByType(fragmentType, currentPage);
			Util.log(TAG, "listData ------>" + listDatas.toString());
			return null;
		}
		
		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			Util.log(TAG, "onPostExecute listData refresh success");
			adapter.addMore(listDatas);
			adapter.notifyDataSetChanged();
			xListView.stopRefresh();
		}
	}
}
