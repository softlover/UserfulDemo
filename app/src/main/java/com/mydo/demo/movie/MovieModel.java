package com.mydo.demo.movie;

import com.mydo.demo.base.ResultLisenter;
import com.mydo.demo.entity.Movie;
import com.mydo.demo.http.RetrofitUtils;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * @author: LiBing.
 * @date: 2017/10/27.
 * @version: V1.0.0.
 */

public class MovieModel implements MovieContract.MovieModel {
    @Override
    public void listMovieData(int position, int type, final ResultLisenter resultLisenter) {
        RetrofitUtils.getInstance().listNewsData(2, 1).subscribe(new Observer<Movie>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Movie movie) {
                if(movie != null){
                    resultLisenter.onSuccess(movie);
                }else{
                    resultLisenter.onError();
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {
                resultLisenter.onError();
            }

            @Override
            public void onComplete() {

            }
        });

    }
}
