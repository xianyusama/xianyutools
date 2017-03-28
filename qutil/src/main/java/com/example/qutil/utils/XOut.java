package com.example.qutil.utils;

import java.util.List;

/**
 * Created by xiao on 2016/12/22.
 * 【Console工具类】
 */

public class XOut {
    private static boolean DEBUG = true;//是否进行调试


    /**
     * @param debug 是否调试
     */
    public static void setDEBUG(boolean debug) {
        XOut.DEBUG = debug;
    }

    private static void p(String message) {
        System.out.println("[" + message + "]");
    }

    private static void p(Object object) {
        System.out.println("[" + object.getClass().getSimpleName() + " = " + object + "]");
    }

    private static void p(Class<?> clazz) {
        System.out.println("[-------------------------" + clazz.getSimpleName() + "------------------------------]");
    }

    public static void print(String message) {
        if (DEBUG) {
            p(message);
        }
    }

    public static void print(String... messages) {
        if (DEBUG) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < messages.length; i++) {
                stringBuffer.append(messages[i] + "\t");
            }
            p(stringBuffer.toString());
        }
    }

    public static void print(Object object) {
        if (DEBUG) {
            p(object);
        }
    }

    public static void print(Object... objects) {
        if (DEBUG) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < objects.length; i++) {
                stringBuffer.append(objects[i].getClass().getSimpleName() + " = " + objects[i] + "\t");
            }
            p(stringBuffer.toString());
        }
    }

    public static void print(Class<?> clazz) {
        if (DEBUG) {
            p(clazz);
        }
    }

    public static void print(List<? extends Object> lists) {
        if (DEBUG) {
            StringBuffer stringBuffer = new StringBuffer();
            for (Object obj : lists) {
                stringBuffer.append(obj.getClass().getSimpleName() + " = " + obj + "\t");
            }
            p(stringBuffer.toString());
        }
    }


}
