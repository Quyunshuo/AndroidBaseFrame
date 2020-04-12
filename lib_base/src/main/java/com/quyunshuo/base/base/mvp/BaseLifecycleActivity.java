package com.quyunshuo.base.base.mvp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.quyunshuo.base.base.BaseActivity;
import com.quyunshuo.base.base.mvp.im.IPresenter;
import com.quyunshuo.base.base.mvp.im.IView;

/**
 * @Author: QuYunShuo
 * @Time: 2020/4/12
 * @Class: BaseLifecycleActivity
 * @Remark: ActivityMVP基类
 */
public abstract class BaseLifecycleActivity<P extends IPresenter> extends BaseActivity implements IView {

    /**
     * P层接口
     */
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mPresenter = getPresenter();
        if (mPresenter != null) {
            getLifecycle().addObserver(mPresenter);
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    public Context getContext() {
        return this;
    }

    protected abstract P getPresenter();

}
