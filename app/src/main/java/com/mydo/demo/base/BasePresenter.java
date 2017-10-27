package com.mydo.demo.base;

import java.lang.ref.WeakReference;

/**
 * @author: LiBing.
 * @date: 2017/10/27.
 * @version: V1.0.0.
 */

public abstract class BasePresenter</*M,*/ V> {
//    public M mModel;

    private V mView;

    public WeakReference<V> mViewRef;


    public void attachModelView(/*M pModel,*/ V pView) {

        mViewRef = new WeakReference<V>(pView);

//        this.mModel = pModel;
    }


    public V getView() {
        if (isAttach()) {
            return mViewRef.get();
        } else {
            return null;
        }
    }

    public boolean isAttach() {
        return null != mViewRef && null != mViewRef.get();
    }


    public void onDettach() {
        if (null != mViewRef) {
            mViewRef.clear();
            mViewRef = null;
        }
    }


}
