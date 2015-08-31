package com.myzyd.freeride;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.myzyd.freeride.Adapter.FragmentAdapter;
import com.myzyd.freeride.Utils.LogUtil;

public class MainActivity extends FragmentActivity implements OnClickListener {
    public static final int TAB_HOME = 0;
    public static final int TAB_CATAGORY = 1;
    public static final int TAB_CAR = 2;
    public static final int TAB_MY = 3;

    private ViewPager mViewPager;
    private LinearLayout bottom_layout;
    private FrameLayout mfirst_page, second_page, third_page, forth_page;
    private RelativeLayout bottom2_layout;
    private ImageButton sou, fanhui, sou_yuan;

//    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        addListener();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.id_viewpage);

        mfirst_page = (FrameLayout) findViewById(R.id.shou_img);
        mfirst_page.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(0);
            }
        });
        second_page = (FrameLayout) findViewById(R.id.guoshu_img);
        second_page.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(1);
            }
        });
        third_page = (FrameLayout) findViewById(R.id.lanzi_img);
        third_page.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(2);
            }
        });
        forth_page = (FrameLayout) findViewById(R.id.wode_img);
        forth_page.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(3);
            }
        });
        bottom_layout = (LinearLayout) findViewById(R.id.bottom_layout);
        bottom2_layout = (RelativeLayout) findViewById(R.id.bottom_layout02);


        sou = (ImageButton) bottom_layout.findViewById(R.id.sou);
        sou.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                bottom_layout.setVisibility(View.GONE);//点击@sou 隐藏bottom
                bottom2_layout.setVisibility(View.VISIBLE);//显示 bottom2
            }
        });

        fanhui = (ImageButton) findViewById(R.id.fanhui_btn);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottom2_layout.setVisibility(View.GONE);//点击@fanhui 隐藏bottom2
                bottom_layout.setVisibility(View.VISIBLE);//显示 bottom
            }
        });

        sou_yuan = (ImageButton) findViewById(R.id.sou_yuan_btn);
        sou_yuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtil.d("MainActivity", "返回个人中心");
            }
        });

        FragmentAdapter adapter = new FragmentAdapter(
                getSupportFragmentManager());
        mViewPager.setAdapter(adapter);

    }


    private void addListener() {
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int id) {
                int currentItem = mViewPager.getCurrentItem();

                switch (currentItem) {
                    case 0:
                        resetImg();
                        mfirst_page.setBackgroundResource(R.drawable.an_xia);
                        break;
                    case 1:
                        resetImg();
                        second_page.setBackgroundResource(R.drawable.an_xia);
                        break;
                    case 2:
                        resetImg();
                        third_page.setBackgroundResource(R.drawable.an_xia);
                        break;
                    case 3:
                        resetImg();
                        forth_page.setBackgroundResource(R.drawable.an_xia);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
    }

    @Override
    public void onClick(View v) {
    }

    private void resetImg() {
        mfirst_page.setBackgroundResource(R.drawable.butt2);
        second_page.setBackgroundResource(R.drawable.butt2);
        third_page.setBackgroundResource(R.drawable.butt2);
        forth_page.setBackgroundResource(R.drawable.butt2);
    }
}