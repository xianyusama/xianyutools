package com.xkq.httputil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static android.R.attr.handle;

/**
 * Created by xiao on 2017/3/29.
 */

public abstract class CustomCallback implements Callback {
    @Override
    public void onFailure(Call call, IOException e) {
        handleError(call, e);
    }


    @Override
    public void onResponse(Call call, Response response) throws IOException {
        String res = response.body().string();
        handleResponse(call, res);
    }

    protected abstract void handleError(Call call, IOException e);

    protected abstract void handleResponse(Call call, String response);

}
