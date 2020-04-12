package com.quyunshuo.base.base.mvp;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.quyunshuo.base.base.BaseFragment;
import com.quyunshuo.base.base.mvp.im.IPresenter;

/**
 * @Author: QuYunShuo
 * @Time: 2020/4/12
 * @Class: BaseLifecycleFragment
 * @Remark:
 */
public abstract class BaseLifecycleFragment<P extends IPresenter> extends BaseFragment {

    protected P mPresenter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mPresenter = getPresenter();
        if (mPresenter != null) {
            getLifecycle().addObserver(mPresenter);
        }
        super.onViewCreated(view, savedInstanceState);
    }

    protected abstract P getPresenter();

}
