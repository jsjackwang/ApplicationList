package com.bandunion.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bandunion.applist.R;
import com.bandunion.util.Util;
import com.bandunion.vo.CSDNNewsItem;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

public class CSDNXListViewAdapter extends BaseAdapter{
	private static String TAG = "CSDNXListViewAdapter";
	private List<CSDNNewsItem> list = null;
	private ImageLoader imageLoader = ImageLoader.getInstance();  
	private DisplayImageOptions options; 
	
	public CSDNXListViewAdapter(Context context, List<CSDNNewsItem> listDatas) {
		Util.log(TAG, "CSDNXListViewAdapter init");
		list = listDatas;
		imageLoader.init(ImageLoaderConfiguration.createDefault(context));  
        options = new DisplayImageOptions.Builder().showStubImage(R.drawable.images)  
                .showImageForEmptyUri(R.drawable.images).showImageOnFail(R.drawable.images).cacheInMemory()  
                .cacheOnDisc().displayer(new RoundedBitmapDisplayer(20)).displayer(new FadeInBitmapDisplayer(300))  
                .build();  
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public CSDNNewsItem getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		Util.log(TAG, "CSDN XListView getView");
		if(convertView == null){
			holder = new ViewHolder();
			convertView = Util.Inflate(R.layout.csdn_viewpager_xlistview_item);
			holder.title = (TextView) convertView.findViewById(R.id.csdn_xlistview_tv_title);
			holder.image = (ImageView) convertView.findViewById(R.id.csdn_xlistview_iv_img);
			holder.content = (TextView) convertView.findViewById(R.id.csdn_xlistview_tv_content);
			holder.date = (TextView) convertView.findViewById(R.id.csdn_xlistview_tv_date);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		CSDNNewsItem item = getItem(position);
		holder.title.setText(item.getTitle());
		holder.content.setText(item.getContent());
		if(item.getImgUrl() == null){
			holder.image.setVisibility(View.GONE);
		}else{
			holder.image.setVisibility(View.VISIBLE);
		    imageLoader.displayImage(item.getImgUrl(), holder.image, options);
		}
		return convertView;
	}

	public void addMore(List<CSDNNewsItem> listDatas) {
		this.list.addAll(listDatas);
	}
	
	class ViewHolder{
		TextView title;
		ImageView image;
		TextView content;
		TextView date;
	}
}
