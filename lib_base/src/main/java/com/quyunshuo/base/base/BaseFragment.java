package com.quyunshuo.base.base;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

/**
 * @Author: QuYunShuo
 * @Time: 2020/4/12
 * @Class: BaseFragment
 * @Remark: Fragment基类
 */
public abstract class BaseFragment extends Fragment {

    protected ArrayList<Animator> mAnimators = new ArrayList<>();

    protected ArrayList<AnimatorSet> mAnimatorSets = new ArrayList<>();

    protected View mFragmentView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (isFragmentOpenViewBinding()) {
            mFragmentView = initViewBinding(inflater);
        } else {
            mFragmentView = inflater.inflate(getLayoutId(), container, false);
        }
        return mFragmentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    /**
     * 初始化ViewBinding
     * 示例:
     * protected View initViewBinding(@NonNull LayoutInflater inflater) {
     * mBinding = FragmentBlankBinding.inflate(inflater);
     * return mBinding.getRoot();
     * }
     */
    protected abstract View initViewBinding(@NonNull LayoutInflater inflater);

    /**
     * 初始化View
     */
    protected abstract void initView();

    /**
     * 如果不使用ViewBinding，需要重写此方法传入布局Id,并重写isFragmentOpenViewBinding返回false
     */
    protected int getLayoutId() {
        return 0;
    }

    /**
     * 是否开启了ViewBinding
     */
    protected boolean isFragmentOpenViewBinding() {
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
        return mFragmentView.findViewById(id);
    }

    @Override
    public void onDestroyView() {
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
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
