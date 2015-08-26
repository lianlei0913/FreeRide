package com.myzyd.freeride.forthActivity;

import android.app.LocalActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.myzyd.freeride.MainActivity;
import com.myzyd.freeride.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiehehe on 15/7/31.
 */
public class MyOrderAct extends MainActivity {

    private ImageButton orderBack;
    private List<View> listViews;
    private Context context = null;
    private LocalActivityManager manager = null;

    public TabHost tabHost = null;

    public static ViewPager pager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forth_order);

        OrderInitView();

        manager = new LocalActivityManager(this, true);
        manager.dispatchCreate(savedInstanceState);

        tabHost = (TabHost) findViewById(R.id.tabhost);
        tabHost.setup();
        tabHost.setup(manager);

        context = MyOrderAct.this;

        pager = (ViewPager) findViewById(R.id.viewpager);

        Intent i1 = new Intent(context, MyOrderAct1.class);
        Intent i2 = new Intent(context, MyOrderAct2.class);
        Intent i3 = new Intent(context, MyOrderAct3.class);
        Intent i4 = new Intent(context, MyOrderAct4.class);

        listViews = new ArrayList<>();  //实例化listViews
        listViews.add(manager.startActivity("T1", i1).getDecorView());
        listViews.add(manager.startActivity("T2", i2).getDecorView());
        listViews.add(manager.startActivity("T3", i3).getDecorView());
        listViews.add(manager.startActivity("T4", i4).getDecorView());

        RelativeLayout tabIndicator1 = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.tabwidget, null);
        //tabIndicator1从一个layout文件获取view（即单个选项卡）再在大布局里显示
        TextView tvTab1 = (TextView) tabIndicator1.findViewById(R.id.tv_title);
        //id是tabIndicator1的
        tvTab1.setText("全部");

        RelativeLayout tabIndicator2 = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.tabwidget, null);
        TextView tvTab2 = (TextView) tabIndicator2.findViewById(R.id.tv_title);
        tvTab2.setText("待付款");

        RelativeLayout tabIndicator3 = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.tabwidget, null);
        TextView tvTab3 = (TextView) tabIndicator3.findViewById(R.id.tv_title);
        tvTab3.setText("待收货");

        RelativeLayout tabIndicator4 = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.tabwidget, null);
        TextView tvTab4 = (TextView) tabIndicator4.findViewById(R.id.tv_title);
        tvTab4.setText("售后");

        tabHost.addTab(tabHost.newTabSpec("A").setIndicator(tabIndicator1).setContent(i1));
        //TabSpec的名字A，B，C，D为各个tab的Id
        tabHost.addTab(tabHost.newTabSpec("B").setIndicator(tabIndicator2).setContent(i2));
        tabHost.addTab(tabHost.newTabSpec("C").setIndicator(tabIndicator3).setContent(i3));
        tabHost.addTab(tabHost.newTabSpec("D").setIndicator(tabIndicator4).setContent(i4));

        //为tabhost设置滑动监听
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
                    @Override
                    public void onTabChanged(String tabId) {
                        if ("A".equals(tabId)) {
                            pager.setCurrentItem(0);//在tabhost的监听改变Viewpager
                        }
                        if ("B".equals(tabId)) {
                            pager.setCurrentItem(1);
                        }
                        if ("C".equals(tabId)) {
                            pager.setCurrentItem(2);
                        }
                        if ("D".equals(tabId)) {
                            pager.setCurrentItem(3);
                        }
                    }
                });

            }
        });

        pager.setAdapter(new MyPageAdapter(listViews));
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                tabHost.setCurrentTab(position);//在Viewpager改变tabhost

            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }

    /**
     * 订单页适配器
     */
    private class MyPageAdapter extends PagerAdapter {

        private List<View> list;

        private MyPageAdapter(List<View> list) {
            this.list = list;
        }

        @Override
        public void destroyItem(ViewGroup view, int position, Object arg2) {
            ViewPager pViewPager = ((ViewPager) view);
            pViewPager.removeView(list.get(position));
        }

        @Override
        public void finishUpdate(View arg0) {
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object instantiateItem(ViewGroup view, int position) {
            ViewPager pViewPager = ((ViewPager) view);
            pViewPager.addView(list.get(position));
            return list.get(position);
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void restoreState(Parcelable arg0, ClassLoader arg1) {
        }

        @Override
        public Parcelable saveState() {
            return null;
        }

        @Override
        public void startUpdate(View arg0) {
        }
    }

    public void OrderInitView() {
        orderBack = (ImageButton) findViewById(R.id.order_back);
        orderBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("返回个人中心");
                finish();
            }
        });

    }

}
