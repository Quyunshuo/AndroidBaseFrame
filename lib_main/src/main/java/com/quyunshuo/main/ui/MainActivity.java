package com.quyunshuo.main.ui;

import android.view.View;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.quyunshuo.base.base.BaseFragment;
import com.quyunshuo.base.base.mvp.BaseLifecycleActivity;
import com.quyunshuo.base.capsulation.eventbus.EventBusBinding;
import com.quyunshuo.comm.route.RouteUrl;
import com.quyunshuo.main.R;
import com.quyunshuo.main.databinding.MainActivityBinding;

/**
 * @Author: QuYunShuo
 * @Time: 2020/4/12
 * @Class: MainActivity
 * @Remark:
 */
@EventBusBinding
@Route(path = RouteUrl.MAIN_ACTIVITY)
public class MainActivity extends BaseLifecycleActivity<MainContract.Presenter> implements MainContract.View {

    private MainActivityBinding mViewBinding;

    @Override
    protected View getViewBinding() {
        mViewBinding = MainActivityBinding.inflate(getLayoutInflater());
        return mViewBinding.getRoot();
    }

    @Override
    protected void initView() {
        BaseFragment homeFragment = (BaseFragment) ARouter.getInstance().build(RouteUrl.HOME_FRAGMENT).navigation();
        BaseFragment xxxFragment = (BaseFragment) ARouter.getInstance().build(RouteUrl.XXX_FRAGMENT).navigation();

        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frame_layout_1, homeFragment);
        fragmentTransaction.add(R.id.frame_layout_2, xxxFragment);

        fragmentTransaction.commit();
    }

    @Override
    protected MainContract.Presenter getPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
