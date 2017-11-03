package com.mydo.demo.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.mydo.demo.ui.view.ZZCardView;

import java.util.List;

/**
 * @author: LiBing.
 * @date: 2017/11/3.
 * @version: V1.0.0.
 */

public class BannerViewPageAdapter extends PagerAdapter {

    /**
     * 装ImageView数组
     */
    private List<ZZCardView> mImageViews;
    private Context mContext;
    private List<String> mBannsers;

    public void setmImageViews(Context lContext, List<ZZCardView> Ivs, List<String> lBannsers) {
        mImageViews = Ivs;
        this.mContext = lContext;
        mBannsers = lBannsers;
    }

    private int mChildCount = 0;

    @Override
    public void notifyDataSetChanged() {
        mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override
    public int getItemPosition(Object object) {
        if (mChildCount > 0) {
            mChildCount--;
            return POSITION_NONE;
        }
        return super.getItemPosition(object);
    }

    @Override
    public int getCount() {
        return mImageViews == null ? 0 : mImageViews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mImageViews.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View lView = mImageViews.get(position);
        lView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });
        container.addView(lView);

        return lView;
    }
}

