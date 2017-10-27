package com.mydo.demo.movie;

import com.mydo.demo.base.ResultLisenter;
import com.mydo.demo.entity.Movie;

/**
 * @author: LiBing.
 * @date: 2017/10/27.
 * @version: V1.0.0.
 */

public class MoviePresenter extends MovieContract.MoviePresenter {
    @Override
    public void listMovieData(int position, int type) {
        final MovieContract.MovieView movieView = getView();
        if (movieView == null) {
            return;
        }

        movieView.showLoading();

        mModel.listMovieData(position, type, new ResultLisenter() {
            @Override
            public void onSuccess(Object obj) {
                movieView.hideLoading();
                movieView.setMovie((Movie) obj);
            }

            @Override
            public void onError() {
                movieView.hideLoading();
            }
        });
    }
}
