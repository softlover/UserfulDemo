package com.mydo.demo;

import android.support.v4.content.ContextCompat;
import android.view.View;

import com.mydo.demo.base.BaseActivity;
import com.mydo.demo.databinding.ActivityLayoutOptimizeBinding;
import com.mydo.demo.http.RetrofitUtils;
import com.mydo.demo.model.Movie;
import com.mydo.demo.util.ImageUtil;
import com.mydo.demo.util.LogUtil;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class LayoutOptimizeActivity extends BaseActivity<ActivityLayoutOptimizeBinding> {

    @Override
    public int getLayoutId() {
        return R.layout.activity_layout_optimize;
    }

    @Override
    public void initView() {
        mViewBinding.textviewLinespace.setTextColor(ContextCompat.getColor(context, R.color.black));
        mViewBinding.headLayout.topBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


       RetrofitUtils.getInstance().listNewsData(2, 1).subscribe(new Observer<Movie>() {
           @Override
           public void onSubscribe(@NonNull Disposable d) {

           }

           @Override
           public void onNext(@NonNull Movie movie) {
               LogUtil.e(movie.getTitle() + "\n" + movie.getSubjects().get(0).getImages().getSmall());

               String url = movie.getSubjects().get(0).getImages().getSmall();
               ImageUtil.loadImage(context, url, mViewBinding.bottomImg, 0);
           }

           @Override
           public void onError(@NonNull Throwable e) {

           }

           @Override
           public void onComplete() {

           }
       });


    }


}
