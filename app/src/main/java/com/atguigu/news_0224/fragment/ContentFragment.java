package com.atguigu.news_0224.fragment;

import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.atguigu.news_0224.base.BaseFragment;

/**
 * 作者：田学伟 on 2017/5/25 16:58
 * QQ：93226539
 * 作用：主菜单
 */

public class ContentFragment extends BaseFragment {
    private TextView textView;

    @Override
    protected View initView() {
        textView = new TextView(mContext);
        textView.setTextSize(20);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    @Override
    public void initData() {
        super.initData();
        textView.setText("主页——Fragment");
    }
}
