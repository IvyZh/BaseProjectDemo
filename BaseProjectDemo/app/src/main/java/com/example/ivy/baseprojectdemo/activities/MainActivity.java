package com.example.ivy.baseprojectdemo.activities;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ivy.baseprojectdemo.R;
import com.example.ivy.baseprojectdemo.base.BaseActivity;
import com.example.ivy.baseprojectdemo.constant.Constant;
import com.example.ivy.baseprojectdemo.net.OkHttpClientUtils;
import com.example.ivy.baseprojectdemo.utils.L;
import com.example.ivy.baseprojectdemo.utils.UIUtils;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tv_result)
    TextView mTvResult;
    @BindView(R.id.bt_get)
    Button mBtGet;
    private Context mContext;

    @Override
    protected void initView() {

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = this;

        mTvResult.setText("ButterKnife");
    }

    @Override
    protected void initListener() {

    }

    public void get(View v) {

        OkHttpClientUtils.getDataAsync(this, String.format(Constant.URL_LATEST, 1), new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                UIUtils.showToast("网络异常，加载失败！");
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (response.isSuccessful()) {
                    String result_json = response.body().string();
                    L.j(result_json);
                }
            }
        }, "main");
    }

    @Override
    protected void onStop() {
        super.onStop();
        OkHttpClientUtils.cancelCall(mContext, "main");
    }
}
