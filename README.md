# BaseProjectDemo

OkHttp+Glide


网络请求框架：Okhttp

图片加载框架：Glide


### 权限
    
    <uses-permission android:name="android.permission.INTERNET"/>


### MyApplication
* initOkHttp
* initGlide

### BaseActivity
* initView()
* initListener()

### Utils

* L(logger)
	* compile 'com.orhanobut:logger:1.15'

Code:

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

* SharePreUtils