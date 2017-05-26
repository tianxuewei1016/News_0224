package com.atguigu.news_0224.fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.atguigu.news_0224.base.BaseFragment;
import com.atguigu.news_0224.bean.NewsCenterBean;

import java.util.List;

/**
 * 作者：田学伟 on 2017/5/25 16:59
 * QQ：93226539
 * 作用：
 */

public class LeftMunuFragment extends BaseFragment {
    private TextView textView;

    private List<NewsCenterBean.DataBean> datas;

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

    public void setData(List<NewsCenterBean.DataBean> dataBeanList) {
        this.datas = dataBeanList;

        for (int i = 0; i < datas.size(); i++) {
            Log.e("TAG", datas.get(i).getTitle());
        }
    }
}
