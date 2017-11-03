package com.mydo.demo.base;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.mydo.demo.util.LogUtil;
import com.mydo.demo.util.PackageUti;

/**
 * @author: LiBing.
 * @date: 2017/11/3.
 * @version: V1.0.0.
 */

public abstract class BaseListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);


        Intent intent = getIntent();
        String path = intent.getStringExtra(getPackage());
        if (path == null) {
            path = "";
        }
        LogUtil.d("apidemos onCreate path == " + path);
        setListAdapter(new SimpleAdapter(this, PackageUti.getData(this, getPackage(), path),
                android.R.layout.simple_list_item_1, new String[]{"title"},
                new int[]{android.R.id.text1}));
        getListView().setTextFilterEnabled(true);

    }



    @Override
    @SuppressWarnings("unchecked")
    protected void onListItemClick(ListView l, View v, int position, long id) {
        PackageUti.turn(this, l, position);
    }

    public abstract String getPackage();

}
