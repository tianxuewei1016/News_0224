package com.atguigu.news_0224.fragment;

import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.atguigu.news_0224.base.BaseFragment;

/**
 * 作者：田学伟 on 2017/5/25 16:59
 * QQ：93226539
 * 作用：
 */

public class LeftMunuFragment extends BaseFragment{
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
        textView.setText("左侧菜单——Fragment");
    }
}
