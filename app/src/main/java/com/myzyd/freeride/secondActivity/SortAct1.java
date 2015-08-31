package com.myzyd.freeride.secondActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SimpleAdapter;

import com.myzyd.freeride.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiehehe on 15/8/4.
 */
public class SortAct1 extends Fragment implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {
    private RadioButton vegetableBtn1, vegetableBtn2, vegetableBtn3, vegetableBtn4, vegetableBtn5, vegetableBtn6;


    //下拉刷新
    private SwipeRefreshLayout swipeRefreshLayout;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            swipeRefreshLayout.setRefreshing(false);
        }
    };
    private ListView listView = null;
    private List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    private SimpleAdapter simpleAdapter = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.sort_vegetable, container, false);

        listView = (ListView) v.findViewById(R.id.sort_content);

        vegetableBtn1 = (RadioButton) v.findViewById(R.id.vegetableBtn1);


        //实例化下拉刷新控件
        swipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorScheme(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        vegetableBtn2 = (RadioButton) v.findViewById(R.id.vegetableBtn2);
        vegetableBtn3 = (RadioButton) v.findViewById(R.id.vegetableBtn3);
        vegetableBtn4 = (RadioButton) v.findViewById(R.id.vegetableBtn4);
        vegetableBtn5 = (RadioButton) v.findViewById(R.id.vegetableBtn5);
        vegetableBtn6 = (RadioButton) v.findViewById(R.id.vegetableBtn6);
        vegetableBtn1.setOnClickListener(this);
        vegetableBtn2.setOnClickListener(this);
        vegetableBtn3.setOnClickListener(this);
        vegetableBtn4.setOnClickListener(this);
        vegetableBtn5.setOnClickListener(this);
        vegetableBtn6.setOnClickListener(this);


        showStyle();
        vegetableBtn1.setBackgroundResource(R.drawable.kuang_focus);
        vegetableBtn1.setTextColor(this.getResources().getColor(R.color.black));
        sortAdapter();
        listView.setAdapter(simpleAdapter);

        return v;
    }


    /*
    *
    * 各个item的适配器都需重写，以响应内部按钮点击事件
    *
     */
    ///适配器
    public void sortAdapter() {
        initList();
        String from[] = new String[]{"图片", "菜名", "简介", "产地", "产地名", "价格",
                "价", "单位", "库存", "库存量"};
        int to[] = new int[]{R.id.sort_pic, R.id.good_vegetable_name, R.id.sort_content, R.id.productplace,
                R.id.product_place, R.id.goodprice, R.id.good_price, R.id.yuan_jin, R.id.productsave,
                R.id.product_save};
        simpleAdapter = new SimpleAdapter(getActivity(), list, R.layout.sort_vegetable_cell, from, to);

    }

    //放入适配器
    public void initList() {
        int[] res = new int[]{R.drawable.b};

        String string[] = new String[]{"紫甘蓝", "蔬菜简介", "产地 :  ", "西安", "价格 : ", "2.5", "元/斤", "库存 : ", "999"};
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("", res[0]);

        map.put("菜名", string[0]);
        map.put("简介", string[1]);
        map.put("产地", string[2]);
        map.put("产地名", string[3]);
        map.put("价格", string[4]);
        map.put("价", string[5]);
        map.put("单位", string[6]);
        map.put("库存", string[7]);
        map.put("库存量", string[8]);
        list.add(map);
        for (int i = 0; i < 5; i++) {
            list.add(map);
        }
    }


    //点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.vegetableBtn1:
                showStyle();
                vegetableBtn1.setBackgroundResource(R.drawable.kuang_focus);
                vegetableBtn1.setTextColor(this.getResources().getColor(R.color.black));
                break;
            case R.id.vegetableBtn2:
                showStyle();
                vegetableBtn2.setBackgroundResource(R.drawable.kuang_focus);
                vegetableBtn2.setTextColor(this.getResources().getColor(R.color.black));
                break;
            case R.id.vegetableBtn3:
                showStyle();
                vegetableBtn3.setBackgroundResource(R.drawable.kuang_focus);
                vegetableBtn3.setTextColor(this.getResources().getColor(R.color.black));
                break;
            case R.id.vegetableBtn4:
                showStyle();
                vegetableBtn4.setBackgroundResource(R.drawable.kuang_focus);
                vegetableBtn4.setTextColor(this.getResources().getColor(R.color.black));
                break;
            case R.id.vegetableBtn5:
                showStyle();
                vegetableBtn5.setBackgroundResource(R.drawable.kuang_focus);
                vegetableBtn5.setTextColor(this.getResources().getColor(R.color.black));
                break;
            case R.id.vegetableBtn6:
                showStyle();
                vegetableBtn6.setBackgroundResource(R.drawable.kuang_focus);
                vegetableBtn6.setTextColor(this.getResources().getColor(R.color.black));
                break;
            default:
                break;
        }
    }


    //下拉刷新时长设定
    @Override
    public void onRefresh() {
        handler.sendEmptyMessageDelayed(1, 5000);
    }

    //初始风格
    public void showStyle() {
        vegetableBtn1.setBackgroundResource(R.drawable.kuang_normal);
        vegetableBtn2.setBackgroundResource(R.drawable.kuang_normal);
        vegetableBtn3.setBackgroundResource(R.drawable.kuang_normal);
        vegetableBtn4.setBackgroundResource(R.drawable.kuang_normal);
        vegetableBtn5.setBackgroundResource(R.drawable.kuang_normal);
        vegetableBtn6.setBackgroundResource(R.drawable.kuang_normal);
        vegetableBtn1.setTextColor(this.getResources().getColor(R.color.white));
        vegetableBtn2.setTextColor(this.getResources().getColor(R.color.white));
        vegetableBtn3.setTextColor(this.getResources().getColor(R.color.white));
        vegetableBtn4.setTextColor(this.getResources().getColor(R.color.white));
        vegetableBtn5.setTextColor(this.getResources().getColor(R.color.white));
        vegetableBtn6.setTextColor(this.getResources().getColor(R.color.white));
    }

}
