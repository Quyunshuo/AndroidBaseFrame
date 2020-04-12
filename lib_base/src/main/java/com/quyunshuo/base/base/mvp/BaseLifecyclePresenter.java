package com.quyunshuo.base.base.mvp;

import android.util.Log;

import androidx.annotation.StringRes;
import androidx.lifecycle.LifecycleOwner;

import com.quyunshuo.base.base.mvp.im.IPresenter;
import com.quyunshuo.base.base.mvp.im.IView;

import java.lang.ref.WeakReference;

/**
 * @Author: QuYunShuo
 * @Time: 2020/4/12
 * @Class: BaseLifecyclePresenter
 * @Remark:
 */
public abstract class BaseLifecyclePresenter<V extends IView> implements IPresenter {

    private WeakReference<V> mWeakReference;

    public BaseLifecyclePresenter(V view) {
        mWeakReference = new WeakReference<V>(view);
    }

    protected V getView() {
        if (mWeakReference != null && mWeakReference.get() != null) {
            return mWeakReference.get();
        }
        return null;
    }

    protected String getString(@StringRes int id) {
        return getView().getContext().getString(id);
    }

    protected String getString(@StringRes int id, Object... formatArgs) {
        return getView().getContext().getString(id, formatArgs);
    }

    @Override
    public void onCreate(LifecycleOwner owner) {

    }

    @Override
    public void onStart(LifecycleOwner owner) {

    }

    @Override
    public void onResume(LifecycleOwner owner) {

    }

    @Override
    public void onPause(LifecycleOwner owner) {

    }

    @Override
    public void onStop(LifecycleOwner owner) {

    }

    @Override
    public void onDestroy(LifecycleOwner owner) {
        mWeakReference.clear();
        mWeakReference = null;
        Log.d("miyan", "super.onDestroy: ");

    }
}
