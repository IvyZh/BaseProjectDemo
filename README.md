# BaseProjectDemo

OkHttp+Glide


网络请求框架：Okhttp

图片加载框架：Glide


### 权限
    
    <uses-permission android:name="android.permission.INTERNET"/>


### MyApplication
* initOkHttp
* initGlide

	完整代码

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
		完整代码


* AppManager

	Code:
	
		public class AppManager {
		
		    // Activity栈
		    private static Stack<Activity> activityStack;
		    // 单例模式
		    private static AppManager instance;
		
		    private AppManager() {
		    }
		
		    /**
		     * 单一实例
		     */
		    public static AppManager getAppManager() {
		        if (instance == null) {
		            instance = new AppManager();
		        }
		        return instance;
		    }
		
		    /**
		     * 添加Activity到堆栈
		     */
		    public void addActivity(Activity activity) {
		        if (activityStack == null) {
		            activityStack = new Stack<Activity>();
		        }
		        activityStack.add(activity);
		    }
		
		    /**
		     * 获取当前Activity（堆栈中最后一个压入的）
		     */
		    public Activity currentActivity() {
		        Activity activity = activityStack.lastElement();
		        return activity;
		    }
		
		    /**
		     * 结束当前Activity（堆栈中最后一个压入的）
		     */
		    public void finishActivity() {
		        Activity activity = activityStack.lastElement();
		        finishActivity(activity);
		    }
		
		    /**
		     * 结束指定的Activity
		     */
		    public void finishActivity(Activity activity) {
		        if (activity != null) {
		            activityStack.remove(activity);
		            activity.finish();
		            activity = null;
		        }
		    }
		
		    /**
		     * 结束指定类名的Activity
		     */
		    public void finishActivity(Class<?> cls) {
		        for (Activity activity : activityStack) {
		            if (activity.getClass().equals(cls)) {
		                finishActivity(activity);
		            }
		        }
		    }
		
		    /**
		     * 结束所有Activity
		     */
		    public void finishAllActivity() {
		        for (int i = 0; i < activityStack.size(); i++) {
		            if (null != activityStack.get(i)) {
		                activityStack.get(i).finish();
		            }
		        }
		        activityStack.clear();
		    }
		
		    /**
		     * 退出应用程序
		     */
		    public void AppExit(Context context) {
		        try {
		            finishAllActivity();
		            ActivityManager activityMgr = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
		            activityMgr.killBackgroundProcesses(context.getPackageName());
		            System.exit(0);
		        } catch (Exception e) {
		        }
		    }
		}

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
	
	完整代码


### OkHttpClientUtils 
	
	完整代码