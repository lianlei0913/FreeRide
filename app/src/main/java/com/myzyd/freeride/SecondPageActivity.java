package com.myzyd.freeride;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.myzyd.freeride.Adapter.FragmentAdapter2;

/**
 * Created by xiehehe on 15/8/5.
 */
public class SecondPageActivity extends android.support.v4.app.Fragment implements View.OnClickListener {

    public static final int VEGETABLE = 0;
    public static final int FRESH = 1;
    public static final int AQUATIC = 2;
    public static final int OTHER = 3;

    private ViewPager mviewPager;
    private RadioButton button1, button2, button3, button4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.page_second, container, false);

        mviewPager = (ViewPager) v.findViewById(R.id.content);
        button1 = (RadioButton) v.findViewById(R.id.button1);
        button2 = (RadioButton) v.findViewById(R.id.button2);
        button3 = (RadioButton) v.findViewById(R.id.button3);
        button4 = (RadioButton) v.findViewById(R.id.button4);
        button4.setOnClickListener(this);
        button3.setOnClickListener(this);
        button2.setOnClickListener(this);
        button1.setOnClickListener(this);

        FragmentAdapter2 adapter2 = new FragmentAdapter2(getChildFragmentManager());
        mviewPager.setAdapter(adapter2);
        addListener();
        button1.setTextSize(19);
        button1.setTextColor(this.getResources().getColor(R.color.blue));

        return v;

    }


    private void addListener() {
        mviewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int id) {
                switch (id) {
                    case VEGETABLE:
                        ShowStyle();
                        button1.setTextSize(19);
                        button1.setTextColor(getResources().getColor(R.color.blue));
                        button1.setChecked(true);
                        break;
                    case FRESH:
                        ShowStyle();
                        button2.setTextSize(19);
                        button2.setTextColor(getResources().getColor(R.color.blue));
                        button2.setChecked(true);
                        break;
                    case AQUATIC:
                        ShowStyle();
                        button3.setTextSize(19);
                        button3.setTextColor(getResources().getColor(R.color.blue));
                        button3.setChecked(true);
                        break;
                    case OTHER:
                        ShowStyle();
                        button4.setTextSize(19);
                        button4.setTextColor(getResources().getColor(R.color.blue));
                        button4.setChecked(true);

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
        switch (v.getId()) {
            case R.id.button1:
                ShowStyle();
                button1.setTextSize(19);
                button1.setTextColor(this.getResources().getColor(R.color.blue));
                mviewPager.setCurrentItem(VEGETABLE);
                break;
            case R.id.button2:
                ShowStyle();
                button2.setTextSize(19);
                button2.setTextColor(this.getResources().getColor(R.color.blue));
                mviewPager.setCurrentItem(FRESH);
                break;
            case R.id.button3:
                ShowStyle();
                button3.setTextSize(19);
                button3.setTextColor(this.getResources().getColor(R.color.blue));
                mviewPager.setCurrentItem(AQUATIC);
                break;
            case R.id.button4:
                ShowStyle();
                button4.setTextSize(19);
                button4.setTextColor(this.getResources().getColor(R.color.blue));
                mviewPager.setCurrentItem(OTHER);
                break;
            default:
                break;
        }
    }

    //初始字体的大小和颜色，实现在代码中动态改变，用来表示选中的焦点状态
    public void ShowStyle() {
        button1.setTextSize(12);
        button1.setTextColor(this.getResources().getColor(R.color.black));
        button2.setTextSize(12);
        button2.setTextColor(this.getResources().getColor(R.color.black));
        button3.setTextSize(12);
        button3.setTextColor(this.getResources().getColor(R.color.black));
        button4.setTextSize(12);
        button4.setTextColor(this.getResources().getColor(R.color.black));

    }


}
