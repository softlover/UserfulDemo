package com.mydo.demo;

import com.mydo.demo.base.BaseListActivity;

/**
 * @author: LiBing.
 * @date: 2017/10/26.
 * @version: V1.0.0.
 */
public class MainActivity extends BaseListActivity {

    @Override
    public String getPackage() {
        String packageStr =  getPackageName()+".Path";
        return packageStr;
    }
}