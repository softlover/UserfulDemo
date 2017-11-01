package com.mydo.demo;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.mydo.demo.constant.DemoConstant;
import com.mydo.demo.constant.UrlConstant;
import com.mydo.demo.http.ApiService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author: LiBing.
 * @date: 2017/10/26.
 * @version: V1.0.0.
 */
public class DemoApplication extends Application {

    private static DemoApplication instance;
    public Retrofit retrofit = null;
    public ApiService apiService = null;

    public static DemoApplication getInstance() {
        return instance;
    }



    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        init();
    }

    private void init() {
        initStetho();
        initHttp();
    }

    private void initHttp() {
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(DemoConstant.SERVERCONNECTTTIME, TimeUnit.SECONDS)
                .connectTimeout(DemoConstant.SERVERCONNECTTTIME, TimeUnit.SECONDS)
                .addInterceptor(logInterceptor)
                .addNetworkInterceptor(new StethoInterceptor())
                .build();

        retrofit = new Retrofit.Builder().baseUrl(UrlConstant.SERVERURL).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).client(okHttpClient).build();

        apiService = retrofit.create(ApiService.class);
    }

    private void initStetho(){
        Stetho.initializeWithDefaults(this);
    }

}
