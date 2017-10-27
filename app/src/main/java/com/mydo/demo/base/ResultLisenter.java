package com.mydo.demo.base;

/**
 * @author: LiBing.
 * @date: 2017/10/27.
 * @version: V1.0.0.
 */

public interface ResultLisenter<E> {
    void onSuccess(E obj);

    void onError();
}
