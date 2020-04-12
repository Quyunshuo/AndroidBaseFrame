package com.quyunshuo.base.base;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.quyunshuo.base.capsulation.BaseEvent;
import com.quyunshuo.base.capsulation.EventBusBinding;
import com.quyunshuo.base.capsulation.EventBusUtil;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

/**
 * @Author: QuYunShuo
 * @Time: 2020/4/12
 * @Class: BaseActivity
 * @Remark: Activity基类
 */
public abstract class BaseActivity extends AppCompatActivity {

    /**
     * AnimatorList
     */
    protected ArrayList<Animator> mAnimators = new ArrayList<>();

    /**
     * AnimatorSetList
     */
    protected ArrayList<AnimatorSet> mAnimatorSets = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView
        if (isOpenViewBinding()) {
            setContentView(getViewBinding());
        } else {
            setContentView(getLayoutId());
        }
        // EventBus注册
        if (this.getClass().isAnnotationPresent(EventBusBinding.class)) {
            EventBusUtil.register(this);
        }
        initView();
    }

    /**
     * 获取ViewBinding
     */
    protected abstract View getViewBinding();

    /**
     * 初始化View
     */
    protected abstract void initView();

    /**
     * 如果不使用ViewBinding，需要重写此方法传入布局Id,并重写isOpenViewBinding返回false
     */
    protected int getLayoutId() {
        return 0;
    }

    /**
     * 是否开启了ViewBinding
     */
    protected boolean isOpenViewBinding() {
        return true;
    }

    /**
     * 简化findViewById
     *
     * @param id  控件id
     * @param <T> 控件类型
     * @return view
     */
    protected <T extends View> T find(int id) {
        return findViewById(id);
    }

    public Context getContext() {
        return this;
    }

    @Subscribe
    public void getEvent(BaseEvent even) {
    }

    @Override
    protected void onDestroy() {
        for (Animator animator : mAnimators) {
            animator.removeAllListeners();
            animator.cancel();
        }
        mAnimators.clear();
        mAnimators = null;

        for (AnimatorSet animatorSet : mAnimatorSets) {
            animatorSet.removeAllListeners();
            animatorSet.cancel();
        }
        mAnimatorSets.clear();
        mAnimatorSets = null;
        super.onDestroy();
        // EventBus解除注册
        if (this.getClass().isAnnotationPresent(EventBusBinding.class)) {
            EventBusUtil.unRegister(this);
        }
    }
}
