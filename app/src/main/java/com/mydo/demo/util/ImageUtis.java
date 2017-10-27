package com.mydo.demo.util;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mydo.demo.R;


/**
 * @author: LiBing.
 * @date: 2017/10/26.
 * @version: V1.0.0.
 */

public class ImageUtis {

    public static void loadImage(Context context, String url, ImageView view, int res){
        Glide.with(context).load(url).placeholder(R.mipmap.ic_launcher).diskCacheStrategy(DiskCacheStrategy.ALL)/*.override(width, width)*/.into(view);
    }
}
