package com.example.ivy.baseprojectdemo.utils;

import com.orhanobut.logger.Logger;

/**
 * Created by Ivy on 2016/10/7.
 * 日志工具类
 */

public class L {
    private static boolean isOpen = true;//日志开关

    public static void d(Object o) {
        if (isOpen)
            Logger.d(o);
    }

    public static void e(String o) {
        if (isOpen)
            Logger.e(o);
    }

    public static void w(String o) {
        if (isOpen)
            Logger.w(o);
    }

    public static void v(String o) {
        if (isOpen)
            Logger.v(o);
    }

    public static void j(String o) {
        if (isOpen)
            Logger.json(o);
    }

    public static void xml(String o) {
        if (isOpen)
            Logger.xml(o);
    }
}
