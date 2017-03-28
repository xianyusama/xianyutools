package com.xianyusama.xutildemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.xkq.qutil.utils.XLog;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        XLog.d(MainActivity.class.getSimpleName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
