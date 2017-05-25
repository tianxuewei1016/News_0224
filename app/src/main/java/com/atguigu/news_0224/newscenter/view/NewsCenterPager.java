package com.atguigu.news_0224.newscenter.view;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;

import com.atguigu.news_0224.base.BasePager;

/**
 * 作者：田学伟 on 2017/5/25 20:00
 * QQ：93226539
 * 作用：新闻中心
 */

public class NewsCenterPager extends BasePager {
    public NewsCenterPager(Context context) {
        super(context);
    }

    @Override
    public void initData() {
        super.initData();
        Log.e("TAG","新闻页面加载数据了");
        //设置标题
        tv_title.setText("新闻");
        //实例化视图
        TextView textView = new TextView(mContext);
        textView.setTextSize(20);
        textView.setGravity(Gravity.CENTER);
        textView.setText("新闻");
        textView.setTextColor(Color.RED);

        //和父类的FrameLayout结合
        fl_main.addView(textView);
    }
}
