package com.xkq.httputil;

import android.os.Build;

import com.xkq.qutil.utils.XLog;
import com.xkq.qutil.utils.klog.KLog;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.builder.GetBuilder;
import com.zhy.http.okhttp.utils.Platform;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Objects;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

import static android.R.attr.key;
import static android.R.attr.mode;
import static android.R.attr.name;

/**
 * Created by xiao on 2017/3/29.
 */

public class XYHttp {
    private static LinkedHashMap<Object, Object> params;
    private static OkHttpClient client = new OkHttpClient();
    private static Request.Builder requestBuilder = new Request.Builder();
    private static FormBody.Builder formBodyBuilder = new FormBody.Builder();
    private static MultipartBody.Builder multiBodyBuilder = new MultipartBody.Builder();
    private static final int GET = 1;
    private static final int POST = 2;
    private static final int NORMAL = 1;
    private static final int FILE = 2;
    private static int type = GET;
    private static int mode = NORMAL;


    public static class Builder {

        public Builder get() {
            type = GET;
            return this;
        }

        public Builder post() {
            type = POST;
            return this;
        }

        public Builder file(String name, String fileName, RequestBody requestBody) {
            multiBodyBuilder.addFormDataPart(name, fileName, requestBody);
            return this;
        }

        public Builder url(String url) {
            requestBuilder.url(url);
            return this;
        }

        public Builder url(URL url) {
            requestBuilder.url(url);
            return this;
        }

        public Builder header(String name, String value) {
            requestBuilder.header(name, value);
            return this;
        }

        public Builder addHeader(String name, String value) {
            requestBuilder.addHeader(name, value);
            return this;
        }

        public Builder tag(Object obj) {
            requestBuilder.tag(obj);
            return this;
        }


        public Builder addParam(String key, String value) {
            if (mode == NORMAL) {
                formBodyBuilder.add(key, value);
            } else if (mode == FILE) {
//                RequestBody fileBody = new RequestBody.create()
//                multiBodyBuilder.addPart(Headers.of(key, value),
//                        fileBody);
            }
            return this;
        }


        public XYHttp build() {
            return new XYHttp();
        }


    }

    /**
     * @return 同步执行
     */
    public static Response execute() {
        Response response = null;

        try {
            if (type == 1) {
                response = client.newCall(requestBuilder.get().build()).execute();
            } else {
                response = client.newCall(requestBuilder.post(formBodyBuilder.build()).build()).execute();
            }
        } catch (IOException e) {
            e.printStackTrace();
            KLog.e(e.toString());
        }

        return response;
    }

    /**
     * @return 同步执行
     */
    public static String executeString() {
        Response response = execute();
        try {
            return response.body().string();
        } catch (IOException e) {
            KLog.e(e.toString());
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 异步执行
     */
    public static void enqueue(Callback callback) {
        if (type == 1) {
            client.newCall(requestBuilder.get().build()).enqueue(callback);
        } else {
            client.newCall(requestBuilder.post(formBodyBuilder.build()).build()).enqueue(callback);
        }
    }
}
