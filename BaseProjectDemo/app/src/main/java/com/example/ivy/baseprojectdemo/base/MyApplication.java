package com.example.ivy.baseprojectdemo.base;

import android.app.Application;
import android.os.Handler;

import com.orhanobut.logger.Logger;

/**
 * Created by Ivy on 2016/10/7.
 */

public class MyApplication extends Application {

    private MyApplication mContext;//全局上下文
    private Handler mHandler;//全局Handler
    private int mMainTid;//主线程的线程Id

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        mHandler = new Handler();
        mMainTid = android.os.Process.myTid();


        initLogger();//初始化Logger
        initOkHttp();//初始化OkHttp
        initGlide();//初始化Glide

    }

    private void initGlide() {
    }

    private void initOkHttp() {

    }

    private void initLogger() {
        Logger.init("way");
    }
}
