package com.quyunshuo.main.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.quyunshuo.base.base.mvp.BaseLifecycleFragment;
import com.quyunshuo.base.capsulation.eventbus.EventBusBinding;
import com.quyunshuo.comm.route.RouteUrl;
import com.quyunshuo.main.databinding.MainHomeFragmentBinding;

import org.greenrobot.eventbus.Subscribe;

/**
 * @Author: QuYunShuo
 * @Time: 2020/4/12
 * @Class: HomeFragment
 * @Remark:
 */
@EventBusBinding
@Route(path = RouteUrl.HOME_FRAGMENT)
public class HomeFragment extends BaseLifecycleFragment<HomeContract.Presenter> implements HomeContract.View {

    private MainHomeFragmentBinding mViewBinding;

    @Override
    protected HomeContract.Presenter getPresenter() {
        return new HomePresenter(this);
    }

    @Override
    protected View initViewBinding(@NonNull LayoutInflater inflater) {
        mViewBinding = MainHomeFragmentBinding.inflate(inflater);
        return mViewBinding.getRoot();
    }

    @Override
    protected void initView() {
        mViewBinding.tv.setOnClickListener(v -> Toast.makeText(getContext(), "Test", Toast.LENGTH_SHORT).show());
    }

    /**
     * 为了生成索引类 每个lib必须要有一个订阅方法 如果有了其他的订阅方法 此订阅方法可以删除
     */
    @Subscribe
    public void testEventIndex(String event) {
    }
}
