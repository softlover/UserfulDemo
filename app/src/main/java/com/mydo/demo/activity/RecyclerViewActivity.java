package com.mydo.demo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mydo.demo.R;
import com.mydo.demo.base.DataBindingActivity;
import com.mydo.demo.databinding.ActivityRecyclerviewBinding;

/**
 * @author: LiBing.
 * @date: 2017/10/26.
 * @version: V1.0.0.
 */
public class RecyclerViewActivity extends DataBindingActivity<ActivityRecyclerviewBinding> {


    @Override
    public int getLayoutId() {
        return R.layout.activity_recyclerview;
    }

    @Override
    public void initView() {
        mViewBinding.headLayout.topCenterTitle.setText(getTitle());
    }
}
