package com.xianyusama.xutildemo;

import android.app.Application;

import com.xkq.httputil.XYHttp;
import com.xkq.qutil.utils.klog.KLog;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by xiao on 2017/3/27.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        KLog.init(true, "UTIL");


        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();
//        XYHttp.initClient(okHttpClient);
        OkHttpUtils.initClient(okHttpClient);
    }
}
