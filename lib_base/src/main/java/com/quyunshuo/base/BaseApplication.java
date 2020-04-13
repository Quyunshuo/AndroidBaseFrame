package com.quyunshuo.base;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.tencent.mmkv.MMKV;

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
        if (BuildConfig.IS_DEBUG) {     // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();          // 打印日志
            ARouter.openDebug();        // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(mApplication);     // 尽可能早，推荐在Application中初始化
        MMKV.initialize(this);  // 初始化MMKV
    }
}
