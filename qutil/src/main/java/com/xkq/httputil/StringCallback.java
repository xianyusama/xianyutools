package com.xkq.httputil;

import com.xkq.qutil.utils.XLog;
import com.xkq.qutil.utils.klog.KLog;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by xiao on 2017/3/29.
 */

public class StringCallback extends CustomCallback {


    @Override
    protected void handleError(Call call, IOException e) {
        KLog.e(e.toString());
    }

    @Override
    protected void handleResponse(Call call, String response) {
        KLog.d(response);
    }
}
