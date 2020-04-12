package com.quyunshuo.main.ui;

import androidx.lifecycle.LifecycleOwner;

import com.quyunshuo.base.base.mvp.BaseLifecyclePresenter;

public class MainPresenter extends BaseLifecyclePresenter<MainContract.View>
        implements MainContract.Presenter {

    MainPresenter(MainContract.View view) {
        super(view);
    }

    @Override
    public void onDestroy(LifecycleOwner owner) {
        super.onDestroy(owner);
    }
}
