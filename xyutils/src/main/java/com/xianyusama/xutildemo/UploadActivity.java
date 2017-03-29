package com.xianyusama.xutildemo;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.xkq.httputil.XYHttp;
import com.xkq.qutil.utils.XLog;
import com.xkq.qutil.utils.klog.KLog;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;

import static android.R.attr.data;

/**
 * Created by xiao on 2017/3/29.
 */

public class UploadActivity extends Activity implements View.OnClickListener {
    private String localurl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        Button btnSelect = (Button) findViewById(R.id.btn_select);
        Button btnUpload = (Button) findViewById(R.id.btn_upload);
        btnSelect.setOnClickListener(this);
        btnUpload.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {//是否选择，没选择就不会继续
            Uri uri = data.getData();//得到uri，后面就是将uri转化成file的过程。
            String[] proj = {MediaStore.Images.Media.DATA};
            Cursor actualimagecursor = managedQuery(uri, proj, null, null, null);
            int actual_image_column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            actualimagecursor.moveToFirst();
            localurl = actualimagecursor.getString(actual_image_column_index);
            KLog.d(localurl);
//            File file = new File(img_path);
//            Toast.makeText(UploadActivity.this, file.toString(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_select:


                final XYHttp xyHttp = new XYHttp.Builder()
                        .post()
                        .url("http://v.juhe.cn/toutiao/index")
                        .addParam("type", "top")
                        .addParam("key", "90139c3055bd2345d52ce2c76985f085")
                        .tag("zheshishenme")
                        .addHeader("Accept", "application/json; q=0.5")
                        .build();
                xyHttp.enqueue(new com.xkq.httputil.StringCallback() {
                    @Override
                    protected void handleError(Call call, IOException e) {
                        super.handleError(call, e);
                    }

                    @Override
                    protected void handleResponse(Call call, String response) {
                        super.handleResponse(call, response);
                    }
                });


                break;
            case R.id.btn_upload:
                if (localurl != null) {
                    File file = new File(localurl);
                    OkHttpUtils.post()//
                            .addFile("tobu", "Caelum.mp3", file)//
                            .url("http://192.168.1.146:8080/t01/Upload")
//                            .params(params)//
//                            .headers(headers)//
                            .build()//
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
                break;
        }

    }
}
