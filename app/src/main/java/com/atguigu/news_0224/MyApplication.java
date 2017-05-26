package com.atguigu.news_0224;

import android.app.Application;

import org.xutils.x;

/**
 * 作者：田学伟 on 2017/5/26 21:19
 * QQ：93226539
 * 作用：
 */

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG); // 是否输出debug日志, 开启debug会影响性能.
    }
}
