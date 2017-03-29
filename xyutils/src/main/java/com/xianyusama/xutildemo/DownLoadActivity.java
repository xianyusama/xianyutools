package com.xianyusama.xutildemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ProgressBar;

import com.xkq.qutil.utils.klog.KLog;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.FileCallBack;

import java.io.File;

import okhttp3.Call;

/**
 * Created by xiao on 2017/3/29.
 */

public class DownLoadActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        final ProgressBar mProgressBar = (ProgressBar) findViewById(R.id.pro_download);
        mProgressBar.setProgress(0);
        mProgressBar.setMax(100);
        OkHttpUtils//
                .get()//
                .url("http://tcy.whcsfh.com/editplus_ha_gr.zip")//
                .build()//
                .execute(new FileCallBack(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "xiazai", "editplus_ha_gr.zip")//
                {
                    @Override
                    public void inProgress(float progress, long total, int id) {
                        mProgressBar.setProgress((int) (progress * 100));
                        KLog.d(progress);
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(File response, int id) {

                    }

                });
    }
}
