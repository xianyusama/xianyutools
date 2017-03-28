package com.xianyusama.xutildemo.ui.base;

import android.app.Activity;
import android.os.Bundle;

import com.example.qutil.utils.XLog;

/**
 * Created by xiao on 2017/3/27.
 */

public class BaseLogActivity extends Activity {
    private static final String TAG = "Activity的生命周期";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        XLog.d("-----------------onCreate---------------------------");
    }

    @Override
    protected void onStart() {
        super.onStart();
        XLog.d("-----------------onStart---------------------------");
    }

    @Override
    protected void onResume() {
        super.onResume();
        XLog.d("-----------------onResume---------------------------");
    }

    @Override
    protected void onPause() {
        super.onPause();
        XLog.d("-----------------onPause---------------------------");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        XLog.d("-----------------onRestart---------------------------");
    }

    @Override
    protected void onStop() {
        super.onStop();
        XLog.d("-----------------onStop---------------------------");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        XLog.d("-----------------onDestroy---------------------------");
    }

}
