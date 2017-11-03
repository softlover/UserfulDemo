package com.mydo.demo.http;


import com.mydo.demo.DemoApplication;
import com.mydo.demo.loader.ObjectLoader;
import com.mydo.demo.entity.Movie;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * 数据返回类
 * @author: LiBing.
 * @date: 2017/10/26.
 * @version: V1.0.0.
 */
public class RetrofitUtils extends ObjectLoader{

    public static RetrofitUtils getInstance() {
        return RetrofitHolder.instance;
    }

    private static class RetrofitHolder {
        private static final RetrofitUtils instance = new RetrofitUtils();
    }

    /**
     * 获取新闻资讯
     *
     * @param position 下标
     * @param type     新闻类型
     */
    public Observable<Movie> listNewsData(int position, int type) {

        return observe(DemoApplication.getInstance().apiService.listNewsData(position, type)).map(new Function<Movie, Movie>() {
            @Override
            public Movie apply(@NonNull Movie movie) throws Exception {
                return movie;
            }
        });


    }



}
