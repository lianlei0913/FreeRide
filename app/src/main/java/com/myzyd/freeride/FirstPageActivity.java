package com.myzyd.freeride;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.myzyd.freeride.Adapter.FirstAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by xiehehe on 15/7/27.
 */
public class FirstPageActivity extends android.support.v4.app.Fragment {

    private GridView mGridView = null;
    private FirstAdapter mAdapter = null;
//    private LinearLayout fastbuyArr[] ={R.id.fast_buy, R.id.fast_buy};
private int imgArr[] = { R.drawable.a, R.drawable.a,
        R.drawable.a, R.drawable.a, R.drawable.a,
        R.drawable.a, R.drawable.a, R.drawable.a};

    //存放图片
    private ViewPager viewPager;
    private List<ImageView> imageViews;

    private int[] imageResId;
    //底部小圆点
    private List<View> dots;
    //当前索引值
    private int currentItem = 0;
    //定时任务
    private ScheduledExecutorService scheduledExecutorService;
    //发送消息
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            viewPager.setCurrentItem(currentItem);
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.page_first, container, false);

        imageResId = new int[]{R.drawable.aa, R.drawable.bb, R.drawable.cc, R.drawable.dd, R.drawable.ee};
        imageViews = new ArrayList<ImageView>();

        // 图片轮播
        for (int i = 0; i < imageResId.length; i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setImageResource(imageResId[i]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageViews.add(imageView);

            viewPager = (ViewPager) v.findViewById(R.id.vp);
            viewPager.setAdapter(new MyAdapter());
            viewPager.setOnPageChangeListener(new MyPageChangeListener());

            dots = new ArrayList<View>();
            dots.add(v.findViewById(R.id.v_dot0));
            dots.add(v.findViewById(R.id.v_dot1));
            dots.add(v.findViewById(R.id.v_dot2));
            dots.add(v.findViewById(R.id.v_dot3));
            dots.add(v.findViewById(R.id.v_dot4));

            //轮播图片下面的小圆点数量的动态设置
            if (imageResId.length < 5) {
                for (int j = 0; j < 5 - imageResId.length; j++) {
                    dots.get(dots.size() - 1 - j).setVisibility(View.GONE);
                }
            }
        }

        mGridView = (GridView) v.findViewById(R.id.my_gridView);
        mGridView.setSelector(new ColorDrawable(Color.TRANSPARENT));// 设置item选中色
        initGridView();

        return v;

    }

    //今日特价
    private void initGridView() {

        // 初始化并设置Adapter
        mAdapter = new FirstAdapter(getActivity(), imgArr);
        mGridView.setAdapter(mAdapter);
    }

    @Override
    public void onStart() {
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(new ScrollTask(), 1, 2, TimeUnit.SECONDS);
        super.onStart();
    }

    @Override
    public void onStop() {
        scheduledExecutorService.shutdown();
        super.onStop();
    }

    private class ScrollTask implements Runnable {

        public void run() {
            synchronized (viewPager) {
//                System.out.println("currentItem: " + currentItem);
                currentItem = (currentItem + 1) % imageViews.size();
                handler.obtainMessage().sendToTarget(); //
            }
        }

    }

    private class MyPageChangeListener implements ViewPager.OnPageChangeListener {
        private int oldPosition = 0;


        public void onPageSelected(int position) {
            currentItem = position;
            dots.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);
            dots.get(position).setBackgroundResource(R.drawable.dot_focused);
            oldPosition = position;
        }

        public void onPageScrollStateChanged(int arg0) {

        }

        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }
    }

    private class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return imageResId.length;
        }

        @Override
        public Object instantiateItem(View arg0, int arg1) {
            ((ViewPager) arg0).addView(imageViews.get(arg1));
            return imageViews.get(arg1);
        }

        @Override
        public void destroyItem(View arg0, int arg1, Object arg2) {
            ((ViewPager) arg0).removeView((View) arg2);
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

        @Override
        public void finishUpdate(View arg0) {

        }
    }
}
