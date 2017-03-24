package com.xianyusama.xutildemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.xianyusama.xyutils.XOut;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       XOut.f("nihao");
        XOut.m(MainActivity.class);
    }
}
