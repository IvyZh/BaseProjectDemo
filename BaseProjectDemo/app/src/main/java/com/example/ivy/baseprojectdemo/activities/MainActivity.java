package com.example.ivy.baseprojectdemo.activities;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.example.ivy.baseprojectdemo.constant.Constant;
import com.example.ivy.baseprojectdemo.R;
import com.example.ivy.baseprojectdemo.base.BaseActivity;
import com.example.ivy.baseprojectdemo.net.OkHttpClientUtils;
import com.example.ivy.baseprojectdemo.utils.L;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class MainActivity extends BaseActivity {

    private Context mContext;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
        mContext = this;

    }

    @Override
    protected void initListener() {

    }

    public void get(View v) {

        OkHttpClientUtils.getDataAsync(this, String.format(Constant.URL_LATEST, 1), new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(mContext, "网络异常，加载失败！", Toast.LENGTH_SHORT).show();
                    }
                });
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
