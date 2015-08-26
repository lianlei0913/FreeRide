package com.myzyd.freeride;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.myzyd.freeride.Adapter.ThirdAdapter;
import com.myzyd.freeride.thirdActivity.Car;
import com.myzyd.freeride.thirdActivity.Pay;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by xiehehe on 15/8/5.
 */
public class ThirdPageActivity extends Fragment implements View.OnClickListener {

    private ImageButton bianjiBtn, wanchengBtn, carDeleteBtn, carJiesuanBtn, subBtn, addBtn;
    private RelativeLayout layoutCarPay, layoutCarEdit;
    private LinearLayout showNumLayout, addNumLayout;
    private TextView sellPriceTv, allPriceTv;
    private EditText sellNumET;
    private int num = 0;

    private ListView listView = null;
    private List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    private SimpleAdapter simpleAdapter = null;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.page_third, container, false);


        listView = (ListView) v.findViewById(R.id.shop_list);
        bianjiBtn = (ImageButton) v.findViewById(R.id.bianji);
        bianjiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bianjiBtn.setVisibility(View.GONE);
                layoutCarEdit.setVisibility(View.GONE);
                wanchengBtn.setVisibility(View.VISIBLE);
                layoutCarPay.setVisibility(View.VISIBLE);
//                showNumLayout.setVisibility(View.GONE);
//                addNumLayout.setVisibility(View.VISIBLE);
            }
        });
        wanchengBtn = (ImageButton) v.findViewById(R.id.wancheng);
        wanchengBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bianjiBtn.setVisibility(View.VISIBLE);
                layoutCarEdit.setVisibility(View.VISIBLE);
                wanchengBtn.setVisibility(View.GONE);
                layoutCarPay.setVisibility(View.GONE);
//                showNumLayout.setVisibility(View.VISIBLE);
//                addNumLayout.setVisibility(View.GONE);
            }
        });

        carDeleteBtn = (ImageButton) v.findViewById(R.id.car_delete);
        carDeleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        carJiesuanBtn = (ImageButton) v.findViewById(R.id.car_jiesuan);
        carJiesuanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Pay.class);
                startActivity(intent);
            }
        });

        layoutCarPay = (RelativeLayout) v.findViewById(R.id.car_pay);
        layoutCarEdit = (RelativeLayout) v.findViewById(R.id.car_edit);
        showNumLayout = (LinearLayout) v.findViewById(R.id.show_number);
        addNumLayout = (LinearLayout) v.findViewById(R.id.add_number);

        ThirdAdapter adapter = new ThirdAdapter(getActivity(),getCars());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "点击了整个 list", Toast.LENGTH_LONG).show();
            }
        });

//
//        subBtn = (ImageButton) v.findViewById(R.id.sub_button);
////        subBtn.setOnClickListener(this);
//        addBtn = (ImageButton) v.findViewById(R.id.add_button);
////        addBtn.setOnClickListener(this);
//        sellPriceTv = (TextView) v.findViewById(R.id.sell_price);
//        allPriceTv = (TextView) v.findViewById(R.id.all_price);
////        sellNumET = (EditText) v.findViewById(R.id.sell_num);
////        sellNumET.addTextChangedListener(new OnTextChangeListener());

        return v;
    }

    @Override
    public void onClick(View v) {

    }

    private List<Car> getCars() {
        List<Car> cars = new ArrayList<Car>();
        for (int i = 0; i < 8; i++) {
            Car c = new Car();
            c.setName("西红柿" + i);

            cars.add(c);
        }
        return cars;
    }



//
//    //加减按钮的实现
//    @Override
//    public void onClick(View v) {
//        String numString = sellNumET.getText().toString();
//        if (numString == null || numString.equals("")) {
//            num = 0;
//            sellNumET.setText("30");
//        } else {
//            switch (v.getId()) {
//                case R.id.sub_button:
//                    if (++num < 0)  //先加，再判断
//                    {
//                        num--;
//                        Toast.makeText(getActivity(), "请输入一个大于0的数字",
//                                Toast.LENGTH_SHORT).show();
//                    } else {
//                        sellNumET.setText(String.valueOf(num));
//                        allPriceTv.setText(sellNumET.getText());
//                    }
//                    break;
//                case R.id.add_button:
//                    if (--num < 0)  //先减，再判断
//                    {
//                        num++;
//                        Toast.makeText(getActivity(), "请输入一个大于0的数字",
//                                Toast.LENGTH_SHORT).show();
//                    } else {
//                        sellNumET.setText(String.valueOf(num));
//                        allPriceTv.setText(sellNumET.getText());
//
//                    }
//                    break;
//                default:
//                    break;
//            }
//        }
//    }
//
//
//    /**
//     * EditText输入变化事件监听器
//     */
//    class OnTextChangeListener implements TextWatcher {
//
//        @Override
//        public void afterTextChanged(Editable s) {
//            String numString = s.toString();
//            if (numString == null || numString.equals("")) {
//                num = 0;
//                allPriceTv.setText(sellNumET.getText());
//            } else {
//                int numInt = Integer.parseInt(numString);
//                if (numInt < 0) {
//                    Toast.makeText(getActivity(), "请输入一个大于0的数字",
//                            Toast.LENGTH_SHORT).show();
//                } else {
//                    //设置EditText光标位置 为文本末端
//                    sellNumET.setSelection(sellNumET.getText().toString().length());
//                    num = numInt;
//                    allPriceTv.setText(sellNumET.getText());
//
//                }
//            }
//        }
//
//        @Override
//        public void beforeTextChanged(CharSequence s, int start, int count,
//                                      int after) {
//
//        }
//
//        @Override
//        public void onTextChanged(CharSequence s, int start, int before,
//                                  int count) {
//
//        }
//
//    }
}
