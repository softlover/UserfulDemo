package com.mydo.demo.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mydo.demo.R;

public abstract class DataBindingActivity<B extends ViewDataBinding> extends AppCompatActivity {

    public Context context;
    public B mViewBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = getLayoutInflater().inflate(this.getLayoutId(), null, false);
        mViewBinding = DataBindingUtil.bind(rootView);
        setContentView(rootView);
        context = this;
        initView();
    }

    public abstract int getLayoutId();

    public abstract void initView();

}
