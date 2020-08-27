package debug;

import android.view.View;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.alibaba.android.arouter.launcher.ARouter;
import com.quyunshuo.base.base.BaseActivity;
import com.quyunshuo.comm.route.RouteUrl;
import com.quyunshuo.main.R;
import com.quyunshuo.main.databinding.MainActivityDebugBinding;
import com.quyunshuo.main.ui.HomeFragment;

public class DebugMainActivity extends BaseActivity {

    private MainActivityDebugBinding mViewBinding;

    @Override
    protected View getViewBinding() {
        mViewBinding = MainActivityDebugBinding.inflate(getLayoutInflater());
        return mViewBinding.getRoot();
    }

    @Override
    protected void initView() {
        HomeFragment homeFragment = (HomeFragment) ARouter.getInstance().build(RouteUrl.HOME_FRAGMENT).navigation();

        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_layout, homeFragment);
        fragmentTransaction.commit();
    }
}
