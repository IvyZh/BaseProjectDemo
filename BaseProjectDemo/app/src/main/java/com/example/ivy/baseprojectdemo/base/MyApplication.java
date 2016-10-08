package com.example.ivy.baseprojectdemo.base;

import android.app.Application;
import android.os.Handler;

import com.bumptech.glide.Glide;
import com.bumptech.glide.integration.okhttp.OkHttpUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.example.ivy.baseprojectdemo.net.OkHttpClientUtils;
import com.orhanobut.logger.Logger;
import com.squareup.okhttp.OkHttpClient;

import java.io.InputStream;

/**
 * Created by Ivy on 2016/10/7.
 */

public class MyApplication extends Application {

    private static MyApplication mContext;//全局上下文
    private static Handler mHandler;//全局Handler
    private static int mMainTid;//主线程的线程Id

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

    /**
     * 初始化单例Glide对象
     */
    private void initGlide() {
        Glide.get(this).register(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(OkHttpClientUtils.getOkHttpSingletonInstance()));
    }

    /**
     * 初始化单例OkHttpClient对象
     */
    private void initOkHttp() {
        OkHttpClient okHttpClient = OkHttpClientUtils.getOkHttpSingletonInstance();
    }

    private void initLogger() {
        Logger.init("way");
    }


    public static MyApplication getContext() {
        return mContext;
    }

    public static Handler getHandler() {
        return mHandler;
    }

    public static int getMainTid() {
        return mMainTid;
    }
}
