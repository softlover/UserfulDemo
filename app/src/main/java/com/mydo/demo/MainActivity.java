package com.mydo.demo;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.mydo.demo.R;
import com.mydo.demo.base.BaseListActivity;
import com.mydo.demo.util.LogUtil;
import com.mydo.demo.util.PackageUti;
import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dalvik.system.DexFile;

/**
 * @author: LiBing.
 * @date: 2017/10/26.
 * @version: V1.0.0.
 */
public class MainActivity extends BaseListActivity {

    private String packageName = "com.mydo.demo.Path";

    @Override
    public String getPackage() {
        return packageName;
    }
}