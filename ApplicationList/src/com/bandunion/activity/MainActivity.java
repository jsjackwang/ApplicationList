package com.bandunion.activity;

import java.util.ArrayList;
import java.util.List;

import com.bandunion.adapter.BandUnionAdapter;
import com.bandunion.applist.R;
import com.bandunion.vo.ItemDescription;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;


public class MainActivity extends Activity {

	private static List<ItemDescription> listDatas = new ArrayList<ItemDescription>();
    private ListView listview = null;

    static{
    	listDatas.add(new ItemDescription("RecyclerView", "RecyclerViewDemo"));
    }
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        listview.setAdapter(new BandUnionAdapter());
        listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
			}
        	
		});
    }

	private void initViews() {
		listview = (ListView) findViewById(R.id.activity_main_list);
	}
}
