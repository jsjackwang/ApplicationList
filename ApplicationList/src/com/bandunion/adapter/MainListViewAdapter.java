package com.bandunion.adapter;

import java.util.List;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;

import com.bandunion.applist.R;
import com.bandunion.util.Util;
import com.bandunion.vo.ItemDescription;

public class MainListViewAdapter extends BaseAdapter implements ListAdapter {
	private static String TAG = "MainListViewAdapter";
	private List<ItemDescription> listDatas = null;

	public MainListViewAdapter(List<ItemDescription> listDatas) {
		this.listDatas = listDatas;
	}

	@Override
	public int getCount() {
		return listDatas.size();
	}

	@Override
	public ItemDescription getItem(int position) {
		return listDatas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Util.log(TAG, "MainListViewAdapter getview....");
		ViewHolder holder = null;
		ItemDescription item = getItem(position);
		if(convertView == null){
			holder = new ViewHolder();
			convertView = Util.Inflate(R.layout.listview_item_activity_main);
			holder.btn = (Button) convertView.findViewById(R.id.main_listview_item);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.btn.setText(item.getAppName());
		holder.btn.setTag(item);
		return convertView;
	}
	
	class ViewHolder{
		Button btn;
	}

}
