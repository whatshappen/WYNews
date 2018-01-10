package com.whatshappen.wynews.base;

import android.app.Activity;
import android.app.Application;
import android.os.Process;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author created by Wangw ;
 * @version 1.0
 * @data created time at 2018/1/9 ;
 * @Description Application基类
 */
public class BaseApplication extends Application {

    private volatile static BaseApplication mBaseApplication = null;
    //使用线程安全的集合CopyOnWriteArrayList
    private CopyOnWriteArrayList<Activity> activityList = new CopyOnWriteArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    /**
     * 获取BaseApplication单例
     *
     * @return
     */
    public static BaseApplication getInstance() {
        if (null == mBaseApplication) {
            synchronized (BaseApplication.class) {
                if (null == mBaseApplication)
                    mBaseApplication = new BaseApplication();
            }
        }
        return mBaseApplication;
    }

    public void addActivity(Activity activity) {
        if (null != activityList)
            activityList.add(activity);
    }

    public void removeActivity(Activity activity) {
        if (null != activityList) {
            activityList.remove(activity);
        }
    }

    //退出程序
    public void exitApp() {
        if (null != activityList) {
            for (Activity activity : activityList) {
                activity.finish();
            }
            activityList.clear();
            activityList = null;
        }
        //杀死进程，强制退出
        Process.killProcess(Process.myPid());
        System.exit(0);
    }
}