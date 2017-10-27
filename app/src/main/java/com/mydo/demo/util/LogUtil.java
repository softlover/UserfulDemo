package com.mydo.demo.util;


import com.mydo.demo.BuildConfig;
import com.orhanobut.logger.Logger;

/**
 * 日志打印类
 * @author: LiBing.
 * @date: 2017/10/27.
 * @version: V1.0.0.
 */

public class LogUtil {

    private static final String TAG = "syso";
    private static final boolean DEBUG = BuildConfig.DEBUG;

    public static void d(Object object){
        if(DEBUG){
            Logger.t(TAG).d(object);
        }

    }

    public static void d(String tag, Object object){
        if(DEBUG) {
            Logger.t(tag).d(object);
        }
    }

    public static void e(String message){
        if(DEBUG) {
            Logger.t(TAG).e(message, "");
        }
    }


    public static void e(String tag, String message){
        if(DEBUG) {
            Logger.t(tag).e(message, "");
        }
    }

    public static void json(String tag, String jsonData){
        if(DEBUG) {
            Logger.t(tag).json(jsonData);
        }
    }

    public static void xml(String tag, String xmlData){
        if(DEBUG) {
            Logger.t(tag).xml(xmlData);
        }
    }
}
