package com.xianyusama.xutildemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.xianyusama.xutildemo.model.Root;
import com.xkq.qutil.utils.klog.KLog;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;


public class MainActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView_news);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//设置布局管理器
        mRecyclerView.setLayoutManager(layoutManager);
//设置为垂直布局，这也是默认的
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
//设置Adapter
//        mRecyclerView.setAdapter(recycleAdapter);
        //设置分隔线
//        mRecyclerView.addItemDecoration( new DividerGridItemDecoration(this ));
//设置增加或删除条目的动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        String url="http://v.juhe.cn/toutiao/index";
        OkHttpUtils
                .post()
                .url(url)
                .addParams("type", "top")
                .addParams("key", "90139c3055bd2345d52ce2c76985f085")
                .build()
                .execute(new StringCallback() {

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        KLog.e(e.toString());

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        KLog.d(response);
                       final Root root= JSON.parseObject(response,Root.class);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mRecyclerView.setAdapter(new MyRecyclerAdapter(MainActivity.this,root));
                            }
                        });
                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
