package com.quyunshuo.base;

import android.app.Application;

/**
 * @Author: QuYunShuo
 * @Time: 2020/4/12
 * @Class: BaseApplication
 * @Remark:
 */
public class BaseApplication extends Application {

    private static BaseApplication mApplication;

    public static BaseApplication getApplication() {
        return mApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
    }
}
