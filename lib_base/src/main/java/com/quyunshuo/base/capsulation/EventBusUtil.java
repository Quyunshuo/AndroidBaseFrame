package com.quyunshuo.base.capsulation;

import org.greenrobot.eventbus.EventBus;

/**
 * @Author: QuYunShuo
 * @Time: 2020/4/12
 * @Class: EventBusUtil
 * @Remark: EventBus用法封装
 */
public class EventBusUtil {

    /**
     * 注册
     */
    public static void register(Object object) {
        EventBus.getDefault().register(object);
    }

    /**
     * 解除注册
     */
    public static void unRegister(Object object) {
        EventBus.getDefault().unregister(object);
    }

    /**
     * 发送普通事件
     */
    public static void postEvent(Object event) {
        EventBus.getDefault().post(event);
    }

    /**
     * 发送粘性事件
     */
    public static void postStickyEvent(Object event) {
        EventBus.getDefault().postSticky(event);
    }

    /**
     * 手动获取粘性事件
     */
    public static <T> T getStickyEvent(Class<T> eventType) {
        return EventBus.getDefault().getStickyEvent(eventType);
    }

    /**
     * 手动删除粘性事件
     */
    public static <T> T removeStickyEvent(Class<T> eventType) {
        return EventBus.getDefault().removeStickyEvent(eventType);
    }
}