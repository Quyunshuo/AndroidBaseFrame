package com.quyunshuo.main;

import android.view.View;

import com.quyunshuo.base.base.mvp.BaseLifecycleActivity;
import com.quyunshuo.main.databinding.MainActivityBinding;

public class MainActivity extends BaseLifecycleActivity<IMainContract.Presenter> implements IMainContract.View {

    private MainActivityBinding binding;

    @Override
    protected View getViewBinding() {
        binding = MainActivityBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    protected void initView() {
    }

    @Override
    protected IMainContract.Presenter getPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
