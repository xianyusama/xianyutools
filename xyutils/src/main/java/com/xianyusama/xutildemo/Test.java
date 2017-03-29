package com.xianyusama.xutildemo;


import android.os.Bundle;

import com.alibaba.fastjson.JSON;
import com.xianyusama.xutildemo.logger.Logger;
import com.xianyusama.xutildemo.model.User;
import com.xianyusama.xutildemo.ui.base.BaseLogActivity;
import com.xkq.qutil.utils.XLog;
import com.xkq.qutil.utils.klog.KLog;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by xkq on 2017/3/25.
 */

public class Test extends BaseLogActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Logger.init("TAG");
//        User user = new User("zhouxingxing", "54");
//        String json = JSON.toJSONString(user);
////        Logger.json(json);
//        KLog.json(json);
//        KLog.i(user);
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
                    }
                });
    }
}
