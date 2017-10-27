package com.mydo.demo.http;

import com.mydo.demo.contant.UrlConstant;
import com.mydo.demo.model.Movie;
import com.mydo.demo.model.News;
import com.mydo.demo.model.ObjRoot;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 网络请求类
 * @author: Created by LiBing on 2017/10/26.
 * @version: V1.0.0.
 */

public interface ApiService {


    @GET("top250")
    Observable<Movie> listNewsData(@Query("start") int start, @Query("count") int count);

}
