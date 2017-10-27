package com.mydo.demo.base;

import android.databinding.ViewDataBinding;

import com.mydo.demo.util.CreateUtil;

/**
 * Activity基类
 * @author: LiBing.
 * @date: 2017/10/26.
 * @version: V1.0.0.
 */
public abstract class BaseActivity<P extends BasePresenter/*, M extends BaseModel*/, B extends ViewDataBinding> extends DataBindingActivity<B> {

    public P mPresenter;
//    public M mModel;


    @Override
    protected void initPresenter() {
        mPresenter = CreateUtil.getT(this, 0);
//        mModel = CreateUtil.getT(this, 1);
        mPresenter.attachModelView(/*mModel, */this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter == null) {
            mPresenter.onDettach();
        }

    }
}
