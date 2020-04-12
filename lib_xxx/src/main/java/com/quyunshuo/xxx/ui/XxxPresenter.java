package com.quyunshuo.xxx.ui;

import com.quyunshuo.base.base.mvp.BaseLifecyclePresenter;

/**
 * @Author: QuYunShuo
 * @Time: 2020/4/12
 * @Class: XxxPresenter
 * @Remark:
 */
public class XxxPresenter extends BaseLifecyclePresenter<XxxContract.View> implements XxxContract.Presenter {
    public XxxPresenter(XxxContract.View view) {
        super(view);
    }
}
