package com.mydo.demo.activity;

import android.view.View;

import com.mydo.demo.R;
import com.mydo.demo.base.BaseActivity;
import com.mydo.demo.databinding.ActivityMvpBinding;
import com.mydo.demo.entity.Movie;
import com.mydo.demo.movie.MovieContract;
import com.mydo.demo.movie.MoviePresenter;
import com.mydo.demo.util.ImageUtil;
import com.mydo.demo.util.LogUtil;

/**
 * @author: LiBing.
 * @date: 2017/10/26.
 * @version: V1.0.0.
 */
public class MVPActivity extends BaseActivity<MoviePresenter, ActivityMvpBinding> implements MovieContract.MovieView {


    @Override
    public int getLayoutId() {
        return R.layout.activity_mvp;
    }

    @Override
    public void initView() {
        mViewBinding.headLayout.topCenterTitle.setText(getTitle());
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
