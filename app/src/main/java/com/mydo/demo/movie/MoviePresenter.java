package com.mydo.demo.movie;

import com.mydo.demo.base.ResultLisenter;
import com.mydo.demo.entity.Movie;
import com.mydo.demo.http.RetrofitUtils;
import com.mydo.demo.util.LogUtil;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

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

        RetrofitUtils.getInstance().listNewsData(2, 1).subscribe(new Observer<Movie>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                LogUtil.e("onSubscribe");
            }

            @Override
            public void onNext(@NonNull Movie movie) {
                LogUtil.e("onNext");
                movieView.hideLoading();
                if(movie != null){
                    movieView.setMovie(movie);
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {
                LogUtil.e("onError");
                movieView.hideLoading();
            }

            @Override
            public void onComplete() {
                LogUtil.e("onComplete");
            }
        });
    }
}
