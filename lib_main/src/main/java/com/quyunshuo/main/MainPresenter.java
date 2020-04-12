package com.quyunshuo.main;

import androidx.lifecycle.LifecycleOwner;

import com.quyunshuo.base.base.mvp.BaseLifecyclePresenter;

public class MainPresenter extends BaseLifecyclePresenter<IMainContract.View>
        implements IMainContract.Presenter {

    MainPresenter(IMainContract.View view) {
        super(view);
    }

    @Override
    public void onDestroy(LifecycleOwner owner) {
        super.onDestroy(owner);
    }
}
