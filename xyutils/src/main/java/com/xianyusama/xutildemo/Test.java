package com.xianyusama.xutildemo;


import android.os.Bundle;

import com.alibaba.fastjson.JSON;
import com.xianyusama.xutildemo.logger.Logger;
import com.xianyusama.xutildemo.model.User;
import com.xianyusama.xutildemo.ui.base.BaseLogActivity;
import com.example.qutil.utils.klog.KLog;

/**
 * Created by xkq on 2017/3/25.
 */

public class Test extends BaseLogActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.init("TAG");
        User user = new User("zhouxingxing", "54");
        String json = JSON.toJSONString(user);
//        Logger.json(json);
        KLog.json(json);
        KLog.i(user);
    }
}
