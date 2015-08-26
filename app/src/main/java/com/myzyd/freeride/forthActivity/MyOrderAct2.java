package com.myzyd.freeride.forthActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.myzyd.freeride.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiehehe on 15/7/31.
 */
public class MyOrderAct2 extends Activity {
    private ListView listView = null;
    private List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    private SimpleAdapter simpleAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_money);
        initView();
    }

    private void initView() {
        listView = (ListView) super.findViewById(R.id.order_list);
        settingAdapter();
        listView.setAdapter(simpleAdapter);
    }

    private void settingAdapter() {
        initList();
        String from[] = new String[]{"图片", "订单编号", "编号", "共", "数量", "件商品",
                "实付款", "款", "元", "删除订单", "立即付款", "状态"};
        int to[] = new int[]{R.id.good_pic, R.id.order_number, R.id.number, R.id.textView3,
                R.id.good_number, R.id.textView4, R.id.textView5, R.id.pay_money, R.id.money,
                R.id.order_delete, R.id.order_pay, R.id.order_state};

        simpleAdapter = new SimpleAdapter(this, list, R.layout.list_money_cell,
                from, to);
    }

    private void initList() {
        int[] res = new int[]{R.drawable.ding_dan, R.drawable.order_delete, R.drawable.pay, R.drawable.shouhou,};
        String string[] = new String[]{"订单编号:", "1234567", "共 ", "20", " 件商品", "实付款: ", "108", "元", "待付款"};
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("", res[0]);
        map.put("", res[1]);
        map.put("", res[2]);

        map.put("订单编号", string[0]);
        map.put("编号", string[1]);
        map.put("共", string[2]);
        map.put("数量", string[3]);
        map.put("件商品", string[4]);
        map.put("实付款", string[5]);
        map.put("款", string[6]);
        map.put("元", string[7]);

        map.put("状态", string[8]);
        list.add(map);
        for (int i = 0; i < 20; i++) {
            list.add(map);
        }
    }


}
