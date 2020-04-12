package com.quyunshuo.xxx.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.quyunshuo.base.base.mvp.BaseLifecycleFragment;
import com.quyunshuo.base.capsulation.EventBusBinding;
import com.quyunshuo.comm.route.RouteUrl;
import com.quyunshuo.xxx.databinding.XxxFragmentBinding;

/**
 * @Author: QuYunShuo
 * @Time: 2020/4/12
 * @Class: XxxFragment
 * @Remark:
 */
@EventBusBinding
@Route(path = RouteUrl.XXX_FRAGMENT)
public class XxxFragment extends BaseLifecycleFragment<XxxContract.Presenter> implements XxxContract.View {

    private XxxFragmentBinding mViewBinding;

    @Override
    protected XxxContract.Presenter getPresenter() {
        return new XxxPresenter(this);
    }

    @Override
    protected View initViewBinding(@NonNull LayoutInflater inflater) {
        mViewBinding = XxxFragmentBinding.inflate(inflater);
        return mViewBinding.getRoot();
    }

    @Override
    protected void initView() {
        mViewBinding.tv.setOnClickListener(v -> Toast.makeText(getContext(), "Test", Toast.LENGTH_SHORT).show());
    }
}
