package com.xianyusama.xutildemo;

import android.app.Application;

import com.example.qutil.utils.klog.KLog;

/**
 * Created by xiao on 2017/3/27.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        KLog.init(true, "TAG");
    }
}
