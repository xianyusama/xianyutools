package com.xianyusama.xutildemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.xianyusama.xutildemo.widget.simpledialog.SweetAlertDialog;


public class MainActivity extends AppCompatActivity {

    private SweetAlertDialog sweetAlertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sweetAlertDialog = new SweetAlertDialog(MainActivity.this);
        sweetAlertDialog.setTitleText("hahahahah");
        sweetAlertDialog.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (sweetAlertDialog != null) {
                                sweetAlertDialog.cancel();
                            }
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (sweetAlertDialog != null) {
            sweetAlertDialog.cancel();
        }
    }
}
