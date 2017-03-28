package com.example.qutil.utils;

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

    public static void d(String message) {
        if (DEBUG) {
//            Log.d(DEFAULT_TAG, "[ " + message + " ]");
            StackTraceElement callerTrace = getCallerTrace();
            String messageFormat = messageFormat(callerTrace, message);
            String callerClassName = getCallerClassName(callerTrace);
            String tag = classFormat(callerClassName);
            Log.d(tag, messageFormat);
        }
    }

    private static String classFormat(String callerClassName) {
        String format = callerClassName.substring(callerClassName.lastIndexOf(".") + 1);
        return format;
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


    private static StackTraceElement getCallerTrace() {
        StackTraceElement traceElement = new Exception().getStackTrace()[3];
        return traceElement;
    }

    private static String getCallerClassName(StackTraceElement traceElement) {
        return traceElement.getClassName();
    }

    private static String getCallerFileName(StackTraceElement traceElement) {
        return traceElement.getFileName();
    }

    private static String getCallerMethodName(StackTraceElement traceElement) {
        return traceElement.getMethodName();
    }

    private static String getCallerLineNumber(StackTraceElement traceElement) {
        return String.valueOf(traceElement.getLineNumber());
    }

    private static String messageFormat(StackTraceElement traceElement, String message) {
        String format = "【 调用的地方-->:\t" + getCallerFileName(traceElement) + "\n" + "调用的方法为-->:\t" + getCallerMethodName(traceElement) + "\n" + "\t\t\t消息为：\t" + message + "\n" + "在第\t" + getCallerLineNumber(traceElement) + "\t行调用 】";
        return format;
    }
}
