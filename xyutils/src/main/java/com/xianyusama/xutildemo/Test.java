package com.xianyusama.xutildemo;

import android.app.Activity;
import android.os.Bundle;

import com.xianyusama.xutildemo.model.User;
import com.xianyusama.xutildemo.utils.XOut;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xkq on 2017/3/25.
 */

public class Test extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            users.add(new User("xiao" + i, "age" + i));
        }
        XOut.print(users);

    }
}
