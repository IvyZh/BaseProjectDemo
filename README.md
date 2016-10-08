# BaseProjectDemo

OkHttp+Glide


网络请求框架：Okhttp

图片加载框架：Glide


### 权限
    
    <uses-permission android:name="android.permission.INTERNET"/>


### MyApplication
* initOkHttp
* initGlide

	[完整代码](https://github.com/IvyZh/BaseProjectDemo/blob/master/BaseProjectDemo/app/src/main/java/com/example/ivy/baseprojectdemo/base/MyApplication.java)

### Okhttp
	
	compile 'com.squareup.okhttp:okhttp:2.7.1'

### Glide
	
	compile 'com.github.bumptech.glide:glide:3.7.0'
	compile 'com.github.bumptech.glide:okhttp-integration:1.4.0'

### BaseActivity
* initView()
* initListener()

### Utils

* L(logger)
	* compile 'com.orhanobut:logger:1.15'

	* 自定义Tag:
		* Logger.init("way");

* Code:
	
	[完整代码](https://github.com/IvyZh/BaseProjectDemo/blob/master/BaseProjectDemo/app/src/main/java/com/example/ivy/baseprojectdemo/utils/L.java)


* AppManager

	[完整代码](https://github.com/IvyZh/BaseProjectDemo/blob/master/BaseProjectDemo/app/src/main/java/com/example/ivy/baseprojectdemo/utils/AppManager.java)
	
完整代码

	在BaseActivity中引用：
	
		@Override
	    protected void onDestroy() {
	        super.onDestroy();
	        // 结束Activity&从堆栈中移除
	        AppManager.getAppManager().finishActivity(this);
	    }
	
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        AppManager.getAppManager().addActivity(this);// 添加Activity到堆栈
	        initView();
	        initListener();
	    }

* SharePreUtils
	
	[完整代码](https://github.com/IvyZh/BaseProjectDemo/blob/master/BaseProjectDemo/app/src/main/java/com/example/ivy/baseprojectdemo/utils/SharedPreUtils.java)


### OkHttpClientUtils 
	
* 代码

	[完整代码](https://github.com/IvyZh/BaseProjectDemo/blob/master/BaseProjectDemo/app/src/main/java/com/example/ivy/baseprojectdemo/net/OkHttpClientUtils.java)


### ButterKnife

配置参考：

[http://www.jianshu.com/p/bf9018c1a7f6](http://www.jianshu.com/p/bf9018c1a7f6)