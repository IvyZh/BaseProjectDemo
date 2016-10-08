package com.example.ivy.baseprojectdemo;

import com.example.ivy.baseprojectdemo.base.BaseActivity;
import com.example.ivy.baseprojectdemo.utils.L;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends BaseActivity {


    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
        String JSON_CONTENT = "{'name':'zhang san','age':'18'}";
        L.d("hello");
        L.e("hello");
        L.w("hello");
        L.v("hello");
        L.j(JSON_CONTENT);
//        Logger.xml(XML_CONTENT);
//        Logger.log(DEBUG, "tag", "message", throwable);

        ArrayList list = new ArrayList<String>();
        list.add("zhangsan111");
        list.add("list111");
        L.d(list);

        HashMap map = new HashMap<Integer, String>();
        map.put(1,"h11h");
        map.put(2,"xi22xi");
        L.d(map);


    }

    @Override
    protected void initListener() {

    }
}
