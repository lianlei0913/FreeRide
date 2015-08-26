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
public class MyOrderAct4 extends Activity {

    private ListView listView = null;
    private List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    private SimpleAdapter simpleAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_service);
        initView();
    }

    private void initView() {
        listView = (ListView) super.findViewById(R.id.order_service_list);
        settingAdapter();
        listView.setAdapter(simpleAdapter);
    }

    private void settingAdapter() {
        initList();
        String from[] = new String[]{"图片", "订单编号", "编号",
                "实付款", "款", "元", "退款金额", "钱", "钱数", "退款去向", "重新购买", "状态"};
        int to[] = new int[]{R.id.service_good_pic, R.id.service_order_number, R.id.service_number, R.id.textView5,
                R.id.pay_service_money, R.id.money, R.id.textView6, R.id.textView7, R.id.order_service_money,
                R.id.money_to, R.id.rebuy, R.id.order_service_state};

        simpleAdapter = new SimpleAdapter(this, list, R.layout.list_service_cell, from, to);
    }

    private void initList() {
        int[] res = new int[]{R.drawable.ding_dan, R.drawable.order_money_to, R.drawable.rebuy};
        String string[] = new String[]{"订单编号:", "123454321", "实付款: ", "79", " 元", " 元", "退款金额:", "79", "正在处理"};
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("", res[0]);
        map.put("", res[1]);
        map.put("", res[2]);

        map.put("订单编号", string[0]);
        map.put("编号", string[1]);
        map.put("实付款", string[2]);
        map.put("款", string[3]);
        map.put("元", string[4]);
        map.put("退款金额", string[5]);
        map.put("钱", string[6]);
        map.put("钱数", string[7]);

        map.put("状态", string[8]);
        list.add(map);
        for (int i = 0; i < 20; i++) {
            list.add(map);
        }
    }
}
