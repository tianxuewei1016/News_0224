package com.atguigu.news_0224.newscenter.view;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.atguigu.news_0224.base.BasePager;

/**
 * 作者：田学伟 on 2017/5/25 20:23
 * QQ：93226539
 * 作用：
 */

public class SettingPager extends BasePager{
    public SettingPager(Context mContext) {
        super(mContext);
    }
    @Override
    public void initData() {
        super.initData();
        //设置标题
        tv_title.setText("设置");

        //实例视图
        TextView textView = new TextView(mContext);
        textView.setTextSize(20);
        textView.setGravity(Gravity.CENTER);
        textView.setText("设置");
        textView.setTextColor(Color.RED);

        //和父类的FrameLayout结合
        fl_main.addView(textView);
    }
}

