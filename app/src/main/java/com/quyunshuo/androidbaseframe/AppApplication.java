package com.quyunshuo.androidbaseframe;

import com.quyunshuo.comm.CommApplication;
import com.quyunshuo.eventbus.index.MainEventBusIndex;
import com.quyunshuo.eventbus.index.XxxEventBusIndex;

import org.greenrobot.eventbus.EventBus;

/**
 * @Author: QuYunShuo
 * @Time: 2020/4/12
 * @Class: AppApplication
 * @Remark:
 */
public class AppApplication extends CommApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        // 使用EventBus索引 优化性能
        EventBus.builder()
                .addIndex(new MainEventBusIndex())
                .addIndex(new XxxEventBusIndex())
                .installDefaultEventBus();
    }
}
