package cn.edots.nest.ui;

import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import cn.edots.nest.R;

/**
 * @author Parck.
 * @date 2017/9/28.
 * @desc
 */
public abstract class TitleBarActivity extends BaseActivity {

    protected Toolbar toolbar;
    protected ImageView backButton;
    protected TextView leftTitle;
    protected TextView centerTitle;
    protected ImageView rightButton;
    protected TextView rightText;
    protected FrameLayout contentLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.setContentView(R.layout.activity_base_title_bar);
        initView();
        initListener();
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        backButton = (ImageView) findViewById(R.id.back_btn);
        leftTitle = (TextView) findViewById(R.id.left_title_text);
        centerTitle = (TextView) findViewById(R.id.center_title_text_view);
        rightButton = (ImageView) findViewById(R.id.right_image_btn);
        rightText = (TextView) findViewById(R.id.right_text_btn);
        contentLayout = (FrameLayout) findViewById(R.id.content_layout);
    }

    private void initListener() {
    }

    @Override
    public void setContentView(View view) {
        setContentView(view, contentLayout.getLayoutParams());
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        getLayoutInflater().inflate(layoutResID, contentLayout);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        contentLayout.removeAllViews();
        contentLayout.addView(view, params);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.back_btn:
                if (isBackToExit())
                    onExit();
                else
                    onBack();
                break;
        }
    }

    protected void setLeftTitleContent(CharSequence title) {
        setLeftTitleContent(title, R.color.default_text_color);
    }

    protected void setLeftTitleContent(CharSequence title, @ColorRes int resId) {
        leftTitle.setVisibility(View.VISIBLE);
        leftTitle.setText(title);
        leftTitle.setTextColor(THIS.getResources().getColor(resId));
    }

    protected void setCenterTitleContent(CharSequence title) {
        setCenterTitleContent(title, R.color.default_text_color);
    }

    protected void setCenterTitleContent(CharSequence title, @ColorRes int resId) {
        centerTitle.setVisibility(View.VISIBLE);
        centerTitle.setText(title);
        centerTitle.setTextColor(THIS.getResources().getColor(resId));
    }

    protected void setRightButtonImageResource(@DrawableRes int resId) {
        rightButton.setVisibility(View.VISIBLE);
        rightButton.setImageResource(resId);
    }

    protected void setRightButtonListener(View.OnClickListener listener) {
        rightButton.setOnClickListener(listener);
    }

    protected void setRightTextContent(CharSequence text) {
        setRightTextContent(text, R.color.default_text_color);
    }

    protected void setRightTextContent(CharSequence text, @ColorRes int resId) {
        rightText.setVisibility(View.VISIBLE);
        rightText.setText(text);
        rightText.setTextColor(THIS.getResources().getColor(resId));
    }

    protected void setRightTextListener(View.OnClickListener listener) {
        rightText.setOnClickListener(listener);
    }

    /**
     * 返回按钮点击事件
     *
     * @param listener
     */
    protected void setOnBackButtonClickListener(View.OnClickListener listener) {
        backButton.setOnClickListener(listener);
    }

}
