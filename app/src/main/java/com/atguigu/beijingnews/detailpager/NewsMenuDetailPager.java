package com.atguigu.beijingnews.detailpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.atguigu.beijingnews.R;
import com.atguigu.beijingnews.base.MenuDetailBasePager;
import com.atguigu.beijingnews.bean.NewsCenterBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：尚硅谷-杨光福 on 2017/2/6 11:27
 * 微信：yangguangfu520
 * QQ号：541433511
 * 作用：新闻详情页面
 */
public class NewsMenuDetailPager extends MenuDetailBasePager {
    /**
     * 新闻详情页面的数据
     */
    private final List<NewsCenterBean.DataBean.ChildrenBean> childrenData;

    private ArrayList<TabDetailPager>tabDetailPagers;
    private ViewPager viewpager;
    public NewsMenuDetailPager(Context context, NewsCenterBean.DataBean dataBean) {
        super(context);
        this.childrenData = dataBean.getChildren();//12条
    }

    @Override
    public View initView() {
        //新闻详情页面的视图
        View view = View.inflate(mContext, R.layout.news_menu_detail_pager, null);
        viewpager = (ViewPager) view.findViewById(R.id.viewpager);
        return view;
    }

    @Override
    public void initData() {
        super.initData();

        tabDetailPagers = new ArrayList<>();
        for (int i =0;i<childrenData.size();i++){
            tabDetailPagers.add(new TabDetailPager(mContext,childrenData.get(i)));
        }
        //设置适配器
        viewpager.setAdapter(new MyPagerAdapter());
    }

    class MyPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return tabDetailPagers.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TabDetailPager tabDetailPager = tabDetailPagers.get(position);
            tabDetailPager.initData();
            View rootView = tabDetailPager.rootView;
            container.addView(rootView);
            return rootView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
