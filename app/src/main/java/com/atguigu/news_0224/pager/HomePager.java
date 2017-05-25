package com.atguigu.news_0224.pager;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;

import com.atguigu.news_0224.base.BasePager;

/**
 * 作者：田学伟 on 2017/5/25 19:57
 * QQ：93226539
 * 作用：主页面
 */

public class HomePager extends BasePager{
    public HomePager(Context context) {
        super(context);
    }

    @Override
    public void initData() {
        super.initData();
        Log.e("TAG","主页面加载数据了");
        //设置标题
        tv_title.setText("主页");

        //实例视图
        TextView textView = new TextView(mContext);
        textView.setTextSize(20);
        textView.setGravity(Gravity.CENTER);
        textView.setText("主页面");
        textView.setTextColor(Color.RED);

        //和父类的FrameLayout结合
        fl_main.addView(textView);
    }
}
