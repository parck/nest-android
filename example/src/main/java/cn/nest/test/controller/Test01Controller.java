package cn.nest.test.controller;

import cn.edots.nest.Controller;
import cn.nest.test.model.view.TestView;
import cn.nest.test.ui.TestActivity;

/**
 * Created by parck on 2018/3/17.
 */

public class Test01Controller extends Controller<TestView> {

    private static final long serialVersionUID = 2724156953538565008L;

    @Override
    public void initialize() {
        viewModel.titleView.setText("Controller 01");
        ((TestActivity)getContext()).setCenterTitleContent("Test01Controller");
    }

    @Override
    public void restore() {

    }

    @Override
    public void destroy() {

    }
}
