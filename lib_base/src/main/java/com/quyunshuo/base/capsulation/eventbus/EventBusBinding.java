package com.quyunshuo.base.capsulation.eventbus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: QuYunShuo
 * @Time: 2020/4/12
 * @Class: EventBusBinding
 * @Remark: EventBus注册与解除注册的注解封装
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EventBusBinding {
}
