package com.konggeek.android.geek.utils;

import android.app.Activity;
import android.widget.Toast;

import com.konggeek.android.geek.manager.ActivityManager;
import com.socks.library.KLog;

/**
 * 打印工具类
 * Created by wanglei on 16/3/23.
 */
public class PrintUtil {


    /**
     * 取ActivityManager中当前Activity显示message
     * @param message
     */
    public static void toastMakeText(String message) {
        Activity activity = ActivityManager.getActivity().get();
        if (activity != null) {
            toastMakeText(activity, message);
        }
    }

    /**
     * ToastMake 显示message
     * @param activity
     * @param message
     */
    public static void toastMakeText(Activity activity, String message) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }


    /**
     * 打印log
     * @param msg
     */
    public static void log(Object msg) {
        KLog.d(String.valueOf(msg));
    }

    /**
     * 打印log
     * @param msg
     */
    public static void log(String tag, String msg) {
        KLog.d(tag, msg);
    }


}
