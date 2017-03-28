package com.xkq.qutil.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * @author
 * @date
 */
public class XToast {

    /**
     * @param context context
     * @param resId   stringId
     */
    public static void showToast(Context context, int resId) {
        Toast.makeText(context, resId, Toast.LENGTH_SHORT).show();
    }

    /**
     * @param context context
     * @param text    string
     */
    public static void showToast(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    /**
     * @param context context
     * @param resId   stringId
     */
    public static void showLongToast(Context context, int resId) {
        Toast.makeText(context, resId, Toast.LENGTH_SHORT).show();
    }

    /**
     * @param context context
     * @param text    string
     */
    public static void showLongToast(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

}
