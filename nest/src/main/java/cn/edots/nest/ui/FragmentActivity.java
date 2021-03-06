package cn.edots.nest.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import cn.edots.nest.R;
import cn.edots.nest.model.view.ViewModel;

/**
 * @author Parck.
 * @date 2017/9/28.
 * @desc
 */

public abstract class FragmentActivity<VM extends ViewModel> extends TitleBarActivity<VM> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.setContentView(R.layout.activity_fragment);
        super.onCreate(savedInstanceState);
        addFragment(R.id.fragment_container, getFragment());
    }

    protected abstract Fragment getFragment();
}
