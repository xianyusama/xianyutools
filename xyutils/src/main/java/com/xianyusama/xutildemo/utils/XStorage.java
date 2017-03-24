package com.xianyusama.xutildemo.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by xiao on 2017/1/5.
 */

public class XStorage {
    private static final int DEFAULT_INT = 0;
    private static final boolean DEFAULT_BOOLEAN = false;
    private static final String DEFAULT_STRING = null;
    private static final float DEFAULT_FLOAT = 0.0f;
    private static final long DEFAULT_LONG = 0;

    private XStorage() {
    }

    //获取Editor实例
    private static SharedPreferences.Editor getEditor(Context context, String name) {
        return getSharedPreferences(context, name).edit();
    }

    //获取SharedPreferences实例
    private static SharedPreferences getSharedPreferences(Context context, String name) {
        return context.getSharedPreferences(name, Context.MODE_PRIVATE);
    }

    /**
     * 向SharedPreferences中写入int类型数据
     *
     * @param context 上下文环境
     * @param name    对应的xml文件名称
     * @param key     键
     * @param value   值
     */
    public static void setInt(Context context, String name, String key,
                              int value) {
        SharedPreferences.Editor sp = getEditor(context, name);
        sp.putInt(key, value);
        sp.commit();
    }

    /**
     * 向SharedPreferences中写入boolean类型的数据
     *
     * @param context 上下文环境
     * @param name    对应的xml文件名称
     * @param key     键
     * @param value   值
     */
    public static void setBoolean(Context context, String name, String key,
                                  boolean value) {
        SharedPreferences.Editor sp = getEditor(context, name);
        sp.putBoolean(key, value);
        sp.commit();
    }

    /**
     * 向SharedPreferences中写入String类型的数据
     *
     * @param context 上下文环境
     * @param name    对应的xml文件名称
     * @param key     键
     * @param value   值
     */
    public static void setString(Context context, String name, String key,
                                 String value) {
        SharedPreferences.Editor sp = getEditor(context, name);
        sp.putString(key, value);
        sp.commit();
    }

    /**
     * 向SharedPreferences中写入float类型的数据
     *
     * @param context 上下文环境
     * @param name    对应的xml文件名称
     * @param key     键
     * @param value   值
     */
    public static void setFloat(Context context, String name, String key,
                                float value) {
        SharedPreferences.Editor sp = getEditor(context, name);
        sp.putFloat(key, value);
        sp.commit();
    }

    /**
     * 向SharedPreferences中写入long类型的数据
     *
     * @param context 上下文环境
     * @param name    对应的xml文件名称
     * @param key     键
     * @param value   值
     */
    public static void setLong(Context context, String name, String key,
                               long value) {
        SharedPreferences.Editor sp = getEditor(context, name);
        sp.putLong(key, value);
        sp.commit();
    }

    /**
     * 从SharedPreferences中读取int类型的数据
     *
     * @param context 上下文环境
     * @param name    对应的xml文件名称
     * @param key     键
     * @return 返回读取的值
     */
    public static int getInt(Context context, String name, String key) {
        SharedPreferences sp = getSharedPreferences(context, name);
        int value = sp.getInt(key, DEFAULT_INT);
        return value;
    }

    /**
     * 从SharedPreferences中读取boolean类型的数据
     *
     * @param context 上下文环境
     * @param name    对应的xml文件名称
     * @param key     键
     * @return 返回读取的值
     */
    public static boolean getBoolean(Context context, String name, String key) {
        SharedPreferences sp = getSharedPreferences(context, name);
        boolean value = sp.getBoolean(key, DEFAULT_BOOLEAN);
        return value;
    }

    /**
     * 从SharedPreferences中读取String类型的数据
     *
     * @param context 上下文环境
     * @param name    对应的xml文件名称
     * @param key     键
     * @return 返回读取的值
     */
    public static String getString(Context context, String name, String key) {
        SharedPreferences sp = getSharedPreferences(context, name);
        String value = sp.getString(key, DEFAULT_STRING);
        return value;
    }

    /**
     * 从SharedPreferences中读取float类型的数据
     *
     * @param context 上下文环境
     * @param name    对应的xml文件名称
     * @param key     键
     * @return 返回读取的值
     */
    public static float getFloat(Context context, String name, String key) {
        SharedPreferences sp = getSharedPreferences(context, name);
        float value = sp.getFloat(key, DEFAULT_FLOAT);
        return value;
    }

    /**
     * 从SharedPreferences中读取long类型的数据
     *
     * @param context 上下文环境
     * @param name    对应的xml文件名称
     * @param key     键
     * @return 返回读取的值
     */
    public static long getLong(Context context, String name, String key) {
        SharedPreferences sp = getSharedPreferences(context, name);
        long value = sp.getLong(key, DEFAULT_LONG);
        return value;
    }


}

