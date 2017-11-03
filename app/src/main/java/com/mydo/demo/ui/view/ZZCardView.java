package com.mydo.demo.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.mydo.demo.R;

/**
 * @author: LiBing.
 * @date: 2017/11/3.
 * @version: V1.0.0.
 */

public class ZZCardView extends LinearLayout {

    private ImageView iv_banner;
    private CardView cv_root;

    public ZZCardView(Context context) {
        super(context);
        initView();
    }


    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_zzcardview, this, true);
        iv_banner = (ImageView) findViewById(R.id.iv_banner);
        cv_root = (CardView) findViewById(R.id.cv_root);
    }


    public void setScaleType(ImageView.ScaleType scaleType) {
        iv_banner.setScaleType(ImageView.ScaleType.FIT_XY);
    }

    public void setImageResource(int resId) {
        iv_banner.setImageResource(resId);
    }

    public void setImageResource(String resId) {
        Glide.with(getContext())
                .load(resId)
                .placeholder(R.mipmap.banner_def)
                .error(R.mipmap.banner_def)
                .into(iv_banner);
//        iv_banner.setImageResource(R.mipmap.bg_dvr_home);
    }

    /**
     * ImageView recycle
     */
    public void releaseImageViewResouce() {
        if (iv_banner == null) return;
        Drawable drawable = iv_banner.getDrawable();
        if (drawable != null && drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        } if (cv_root == null) return;
        Drawable drawable2 = cv_root.getBackground();
        if (drawable2 != null && drawable2 instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
//        releaseImageViewResouce();
    }
}

