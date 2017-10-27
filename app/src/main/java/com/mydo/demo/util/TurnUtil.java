package com.mydo.demo.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.io.Serializable;
import java.util.List;

/**
 * 跳转工具类
 * @author: LiBing.
 * @date: 2017/10/27.
 * @version: V1.0.0.
 */

public class TurnUtil {
    public static String KEY = "key";

    public static void openActivity(Context context, Class<?> turnClass, Bundle bundle, boolean isFinsh) {
        Intent intent = new Intent();
        intent.setClass(context, turnClass);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        context.startActivity(intent);
        if(isFinsh){
            ((Activity)context).finish();
        }
    }


    public static void openActivity(Context context, Class<?> turnClass, String key, List<?> value, boolean isFinsh) {
        Intent intent = new Intent();
        intent.setClass(context, turnClass);
        if (value != null) {
            intent.putExtra(key, (Serializable)value);
        }
        context.startActivity(intent);
        if(isFinsh){
            ((Activity)context).finish();
        }
    }

    public static void openActivity(Context context, Class<?> turnClass, String key, Object value, boolean isFinsh) {
        Intent intent = new Intent();
        intent.setClass(context, turnClass);
        if (value != null) {
            intent.putExtra(key, (Serializable)value);
        }
        context.startActivity(intent);
        if(isFinsh){
            ((Activity)context).finish();
        }
    }

    public static void openActivity(Context context, Class<?> turnClass, String key, String value, boolean isFinsh) {
        Intent intent = new Intent();
        intent.setClass(context, turnClass);
        intent.putExtra(key, value);
        context.startActivity(intent);
        if(isFinsh){
            ((Activity)context).finish();
        }
    }


    public static void openActivity(Context context, Class<?> turnClass, String[] keys, String[] values, boolean isFinish) {
        Intent intent = new Intent();
        intent.setClass(context, turnClass);
        for (int i = 0; i < keys.length; i++){
            intent.putExtra(keys[i], values[i]);
        }
        context.startActivity(intent);
        if(isFinish){
            ((Activity)context).finish();
        }
    }

    public static void openActivity(Context context, Class<?> turnClass) {
        Intent intent = new Intent();
        intent.setClass(context, turnClass);
        context.startActivity(intent);
    }
    public static void openActivity(Context context, Class<?> turnClass, boolean isFinish) {
        Intent intent = new Intent();
        intent.setClass(context, turnClass);
        context.startActivity(intent);
        if(isFinish){
            ((Activity)context).finish();
        }
    }
}
