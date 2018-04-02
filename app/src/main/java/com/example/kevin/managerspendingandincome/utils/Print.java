package com.example.kevin.managerspendingandincome.utils;

import android.util.Log;

import com.example.kevin.managerspendingandincome.app.MyApplication;

/**
 * Created by kevin on 2018/4/1.
 * https://github.com/yinkaiwen
 */

public class Print {
    public static void e(String tag, String msg) {
        if (MyApplication.DEBUG) {
            Log.e(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (MyApplication.DEBUG) {
            Log.w(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (MyApplication.DEBUG) {
            Log.d(tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (MyApplication.DEBUG) {
            Log.i(tag, msg);
        }
    }

    public static void v(String tag, String msg) {
        if (MyApplication.DEBUG) {
            Log.v(tag, msg);
        }
    }
}
