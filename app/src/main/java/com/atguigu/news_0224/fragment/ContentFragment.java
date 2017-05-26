package com.atguigu.news_0224.fragment;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.atguigu.news_0224.R;
import com.atguigu.news_0224.activity.MainActivity;
import com.atguigu.news_0224.base.BaseFragment;
import com.atguigu.news_0224.base.BasePager;
import com.atguigu.news_0224.newscenter.view.NewsCenterPager;
import com.atguigu.news_0224.pager.HomePager;
import com.atguigu.news_0224.pager.SettingPager;
import com.atguigu.news_0224.view.NoScrollViewPager;
import com.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 作者：田学伟 on 2017/5/25 16:58
 * QQ：93226539
 * 作用：主菜单
 */

public class ContentFragment extends BaseFragment {


    @InjectView(R.id.viewpager)
    NoScrollViewPager viewpager;
    @InjectView(R.id.rg_main)
    RadioGroup rgMain;

    private ArrayList<BasePager>basePagers;

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_content, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void initData() {
        super.initData();

        //初始化三个页面
        initPager();

        setAdapter();

        initListener();
    }

    private void initListener() {
        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            //先默认设置不可以滑动
            MainActivity mainActivity = (MainActivity) mContext;
            //mainActivity.getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_home:
                        viewpager.setCurrentItem(0,false);
                        break;
                    case R.id.rb_news:
                        viewpager.setCurrentItem(1,false);
                        //当切换到新闻的时候，修改成可以滑动
                        mainActivity.getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
                        break;
                    case R.id.rb_setting:
                        viewpager.setCurrentItem(2,false);
                        break;
                }
            }
        });
        //默认选中新闻
        rgMain.check(R.id.rb_news);

        //监听页面的选中
        viewpager.addOnPageChangeListener(new MyOnPageChangeListener());
        basePagers.get(1).initData();//孩子的视图和父类的FrameLayout结合
    }

    class MyOnPageChangeListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
        basePagers.get(position).initData();//孩子的视图和父类的FrameLayout结合
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    /**
     * 设置viewpager的适配器
     */
    private void setAdapter() {
        viewpager.setAdapter(new MyPagerAdapter());
    }

    class MyPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return basePagers.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            BasePager basePager = basePagers.get(position);
            //代表不同页面的实例
            View rootView = basePager.rootView;
            //调用initData
//            basePager.initData();
            container.addView(rootView);
            return rootView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    private void initPager() {
        basePagers = new ArrayList<>();
        basePagers.add(new HomePager(mContext));//主页
        basePagers.add(new NewsCenterPager(mContext));//新闻中心
        basePagers.add(new SettingPager(mContext));//设置中心
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
