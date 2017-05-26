package com.atguigu.news_0224.newscenter.view;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;

import com.atguigu.news_0224.base.BasePager;
import com.atguigu.news_0224.utils.Constants;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

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
        Log.e("TAG", "新闻页面加载数据了");
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
        //网络请求
        getDataFromNet();
    }

    /**
     * 网络请求数据
     */
    private void getDataFromNet() {
        //联网地址
        RequestParams params = new RequestParams(Constants.NEWSCENTER_PAGER_URL);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("TAG", "请求成功==" + result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("TAG", "请求失败==" + ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
}
