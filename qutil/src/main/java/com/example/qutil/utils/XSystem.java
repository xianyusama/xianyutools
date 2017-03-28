package com.example.qutil.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import static android.R.attr.data;

/**
 * Created by xiao on 2017/3/14.
 */

public class XSystem {
    /**
     * @param context   上下文
     * @param videoData 视频本地地址
     *             使用系统的播放器打开视频
     */
    public static void openVideoBySystemPlayer(Context context, String videoData){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        String videoPath = "file://" + data;
        intent.setDataAndType(Uri.parse(videoPath), "multiVideo/*");
        context.startActivity(intent);
    }
}
