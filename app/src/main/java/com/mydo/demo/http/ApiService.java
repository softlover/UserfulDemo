package com.mydo.demo.http;

import com.mydo.demo.entity.Movie;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 网络请求类
 * @author: LiBing.
 * @date: 2017/10/26.
 * @version: V1.0.0.
 */
public interface ApiService {


    @GET("top250")
    Observable<Movie> listNewsData(@Query("start") int start, @Query("count") int count);

}
