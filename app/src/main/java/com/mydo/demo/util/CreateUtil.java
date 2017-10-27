package com.mydo.demo.util;

import java.lang.reflect.ParameterizedType;

/**
 * @author: LiBing.
 * @date: 2017/10/27.
 * @version: V1.0.0.
 */

public class CreateUtil {

   public static <T> T getT(Object obj, int i){
        try {
            return ((Class<T>)((ParameterizedType)(obj.getClass().getGenericSuperclass())).getActualTypeArguments()[i]).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }


}
