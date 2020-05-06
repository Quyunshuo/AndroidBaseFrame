package com.quyunshuo.androidbaseframe;

import com.example.myapp.MainEventBusIndex;
import com.example.myapp.XxxEventBusIndex;
import com.quyunshuo.comm.CommApplication;

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
