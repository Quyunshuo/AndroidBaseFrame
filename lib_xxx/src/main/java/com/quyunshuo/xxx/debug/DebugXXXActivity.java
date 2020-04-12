package com.quyunshuo.xxx.debug;

import android.view.View;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.alibaba.android.arouter.launcher.ARouter;
import com.quyunshuo.base.base.BaseActivity;
import com.quyunshuo.comm.route.RouteUrl;
import com.quyunshuo.xxx.R;
import com.quyunshuo.xxx.databinding.XxxActivityDebugBinding;
import com.quyunshuo.xxx.ui.XxxFragment;

/**
 * @Author: QuYunShuo
 * @Time: 2020/4/12
 * @Class: DebugXXXActivity
 * @Remark:
 */
public class DebugXXXActivity extends BaseActivity {

    private XxxActivityDebugBinding mViewBinding;

    @Override
    protected View getViewBinding() {
        mViewBinding = XxxActivityDebugBinding.inflate(getLayoutInflater());
        return mViewBinding.getRoot();
    }

    @Override
    protected void initView() {
        XxxFragment homeFragment = (XxxFragment) ARouter.getInstance().build(RouteUrl.XXX_FRAGMENT).navigation();

        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_layout, homeFragment);
        fragmentTransaction.commit();
    }
}
