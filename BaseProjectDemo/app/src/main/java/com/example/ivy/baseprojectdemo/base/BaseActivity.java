package com.example.ivy.baseprojectdemo.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Ivy on 2016/10/7.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initListener();
    }



    /**
     * setContentView和findViewById操作
     */
    protected abstract void initView();

    /**
     * 给控件添加点击监听事件
     */
    protected abstract void initListener();

}
