package com.atguigu.news_0224.activity;


import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.atguigu.news_0224.R;
import com.atguigu.news_0224.fragment.ContentFragment;
import com.atguigu.news_0224.fragment.LeftMunuFragment;
import com.atguigu.news_0224.utils.DensityUtil;
import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {

    public static final String LEFTMENU_TAG = "leftmenu_tag";
    public static final String CONENT_TAG = "conent_tag";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.设置主页面
        setContentView(R.layout.activity_main);

        //2.设置左侧菜单
        setBehindContentView(R.layout.leftmenu);

        //3.设置右侧菜单
        SlidingMenu slidingMenu = getSlidingMenu();

        //4.设置模式：左侧+主页；左侧+主页+右侧；主页+右侧
        slidingMenu.setMode(SlidingMenu.LEFT);

        //5.设置滑动的模式：全屏，边缘，不可以滑动
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

        //6.设置主页面占的宽度dip
        slidingMenu.setBehindOffset(DensityUtil.dip2px(this,200));

        initFragment();
    }

    /**
     * 初始化Fragment
     */
    private void initFragment() {
        //1.得到事物
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        //2.替换:左侧菜单和主要
        ft.replace(R.id.fl_leftmenu,new LeftMunuFragment(),LEFTMENU_TAG);
        ft.replace(R.id.fl_content,new ContentFragment(),  CONENT_TAG);

        //3.提交
        ft.commit();
    }
}