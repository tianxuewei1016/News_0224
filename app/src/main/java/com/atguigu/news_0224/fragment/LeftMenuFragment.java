package com.atguigu.news_0224.fragment;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.atguigu.news_0224.R;
import com.atguigu.news_0224.activity.MainActivity;
import com.atguigu.news_0224.base.BaseFragment;
import com.atguigu.news_0224.bean.NewsCenterBean;
import com.atguigu.news_0224.utils.DensityUtil;

import java.util.List;

/**
 * 作者：田学伟 on 2017/5/26 21:45
 * QQ：93226539
 * 作用：
 */

public class LeftMenuFragment extends BaseFragment {
    private ListView listView;
    private LeftMenuFragmentAdapter adapter;
    /**
     * 左侧菜单对应的数据
     */
    private List<NewsCenterBean.DataBean> datas;
    /**
     * 左侧菜单对应的数据
     */
    private int prePosition = 0;

    @Override
    protected View initView() {
        listView = new ListView(mContext);
        listView.setPadding(0, DensityUtil.dip2px(mContext, 40), 0, 0);
        listView.setBackgroundColor(Color.BLACK);
        //设置监听
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //1.记录位置和刷新适配器
                prePosition = position;
                adapter.notifyDataSetChanged();

                //2.关闭侧滑菜单
                MainActivity mainActivity = (MainActivity) mContext;
                mainActivity.getSlidingMenu().toggle();//关<->开
                //3.切换到对应的详情页面

            }
        });
        return listView;
    }

    public void setData(List<NewsCenterBean.DataBean> dataBeanList) {
        this.datas = dataBeanList;
        //设置适配器
        adapter = new LeftMenuFragmentAdapter();
        listView.setAdapter(adapter);
    }

    @Override
    public void initData() {
        super.initData();
    }

    class LeftMenuFragmentAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView = (TextView) View.inflate(mContext, R.layout.item_leftmenu, null);
            //设置内容
            textView.setText(datas.get(position).getTitle());

            if (prePosition == position) {
                //把颜色设置高亮-红色
                textView.setEnabled(true);
            } else {
                textView.setEnabled(false);
                //把颜色设置默认-白色
            }
            return textView;
        }
    }
}
