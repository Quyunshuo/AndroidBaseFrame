package com.quyunshuo.main.ui;

import com.quyunshuo.base.base.mvp.BaseLifecyclePresenter;

/**
 * @Author: QuYunShuo
 * @Time: 2020/4/12
 * @Class: HomePresenter
 * @Remark:
 */
public class HomePresenter extends BaseLifecyclePresenter<HomeContract.View> implements HomeContract.Presenter {
    public HomePresenter(HomeContract.View view) {
        super(view);
    }
}
