package com.mydo.demo.util;

import android.content.Context;
import android.widget.Toast;

/**
 * 信息提示类
 * @author: LiBing.
 * @date: 2017/10/27.
 * @version: V1.0.0.
 */

public class ToastUtil {
    private static Toast toast = null;

    public static void showToast(Context context, String text){
        if(null == toast){
            toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        }else{
            toast.setText(text);
        }

        toast.show();
    }
}
