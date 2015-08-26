package com.myzyd.freeride.forthActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.myzyd.freeride.Adapter.ForthGetAdapter;
import com.myzyd.freeride.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiehehe on 15/7/31.
 */
public class MyOrderAct3 extends Activity {

    private ListView listView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_get);
        initView();
    }

    private void initView() {
        listView = (ListView) super.findViewById(R.id.order_get_list);
        ForthGetAdapter adapter = new ForthGetAdapter(this, getGets());
        listView.setAdapter(adapter);

        //item 的点击事件无效
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        switch (position){
                            case 0:
                                Toast.makeText(MyOrderAct3.this, "haha" + position, Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                break;
                        }

                    }
                });
            }
        });
    }

//    private void settingAdapter() {
//        initList();
//        String from[] = new String[]{"图片", "订单编号", "编号", "共", "数量", "件商品",
//                "实付款", "款", "元", "继续购买", "售后服务", "确认收货","状态"};
//        int to[] = new int[]{R.id.get_good_pic, R.id.get_order_number, R.id.get_number, R.id.textView3,
//                R.id.get_good_number, R.id.textView4, R.id.textView5, R.id.get_pay_money, R.id.money,
//                R.id.buy_continue, R.id.shouhou_service, R.id.confirm_get,R.id.get_order_state};
//
//        simpleAdapter = new SimpleAdapter(this, list, R.layout.list_get_cell, from, to);
//
//    }

    private List<Get> getGets() {
        List<Get> gets = new ArrayList<Get>();
        for (int i = 0; i < 8; i++) {
            Get g = new Get();
            g.setNum(12345+i);

            gets.add(g);
        }
        return gets;
    }

//    private void initList() {
//        int[] res = new int[]{R.drawable.ding_dan, R.drawable.buy_continue
//                , R.drawable.shouhou_service, R.drawable.confirm_get};
//        String string[] = new String[]{"订单编号:", "123456789", "共 ", "10", " 件商品", "实付款: ", "78", "元", "待收货"};
//        HashMap<String, Object> map = new HashMap<String, Object>();
//        map.put("", res[0]);
//        map.put("", res[1]);
//        map.put("", res[2]);
//        map.put("", res[3]);
//
//        map.put("订单编号", string[0]);
//        map.put("编号", string[1]);
//        map.put("共", string[2]);
//        map.put("数量", string[3]);
//        map.put("件商品", string[4]);
//        map.put("实付款", string[5]);
//        map.put("款", string[6]);
//        map.put("元", string[7]);
//
//        map.put("状态", string[8]);
//        list.add(map);
//        for (int i = 0; i < 20; i++) {
//            list.add(map);
//        }
//    }
}
