package com.xianyusama.xutildemo.utils;

import android.util.Log;

/**
 * Created by xiao on 2017/2/18.
 * log打印工具类
 */

public class XLog {

    private static final String DEFAULT_TAG = "MTW";
    /**
     * 是否允许调试，默认为TRUE
     */
    private static boolean DEBUG = true;

    /**
     * @param DEBUG 是否允许调试，默认为TRUE(Setter)
     */
    public static void setDEBUG(boolean DEBUG) {
        XLog.DEBUG = DEBUG;
    }

    public static void v(String tag, String message) {
        if (DEBUG) {
            Log.v(tag, "[ " + message + " ]");
        }
    }

    public static void v(String message) {
        v(DEFAULT_TAG, message);
    }

    public static void d(String tag, String message) {
        if (DEBUG) {
            Log.d(tag, "[ " + message + " ]");
        }
    }

    public static void d(String message) {
        d(DEFAULT_TAG, message);
    }


    public static void i(String tag, String message) {
        if (DEBUG) {
            Log.i(tag, "[ " + message + " ]");
        }
    }

    public static void i(String message) {
        i(DEFAULT_TAG, message);
    }

    public static void w(String tag, String message) {
        if (DEBUG) {
            Log.w(tag, "[ " + message + " ]");

        }
    }

    public static void w(String message) {
        w(DEFAULT_TAG, message);
    }

    public static void e(String tag, String message) {
        if (DEBUG) {
            Log.e(tag, "[ " + message + " ]");
        }
    }

    public static void e(String message) {
        e(DEFAULT_TAG, message);
    }
}
