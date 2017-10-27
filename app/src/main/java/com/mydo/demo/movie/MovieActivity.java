package com.mydo.demo.movie;

import android.support.v4.content.ContextCompat;
import android.view.View;

import com.mydo.demo.R;
import com.mydo.demo.base.BaseActivity;
import com.mydo.demo.databinding.ActivityLayoutOptimizeBinding;
import com.mydo.demo.entity.Movie;
import com.mydo.demo.util.ImageUtil;
import com.mydo.demo.util.LogUtil;

/**
 * @author: LiBing.
 * @date: 2017/10/26.
 * @version: V1.0.0.
 */
public class MovieActivity extends BaseActivity<MoviePresenter, ActivityLayoutOptimizeBinding> implements MovieContract.MovieView {


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

        mPresenter.listMovieData(2, 1);

    }


    @Override
    public void setMovie(Movie movie) {
        LogUtil.e(movie.getTitle() + "\n" + movie.getSubjects().get(0).getImages().getSmall());

        String url = movie.getSubjects().get(0).getImages().getSmall();
        ImageUtil.loadImage(context, url, mViewBinding.bottomImg, 0);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError() {

    }


}
