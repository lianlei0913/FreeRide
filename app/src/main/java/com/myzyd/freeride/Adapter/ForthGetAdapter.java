package com.myzyd.freeride.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.myzyd.freeride.R;
import com.myzyd.freeride.ThirdPageActivity;
import com.myzyd.freeride.forthActivity.Get;
import com.myzyd.freeride.forthActivity.SaleSupportAct;

import java.util.List;

/**
 * Created by xiehehe on 15/8/21.
 */
public class ForthGetAdapter extends BaseAdapter implements View.OnClickListener{

    private Context context;
    private List<Get> gets;

    public ForthGetAdapter(Context context, List<Get> gets){
        this.context = context;
        this.gets = gets;

    }

    @Override
    public int getCount() {
        return gets.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        HolderView hv = null;

        if (convertView == null){
            hv = new HolderView();
            convertView = inflater.inflate(R.layout.list_get_cell, null);
            hv.get_good_pic = (ImageView) convertView.findViewById(R.id.get_good_pic);
            hv.get_number = (TextView) convertView.findViewById(R.id.get_number);
            hv.get_good_number = (TextView) convertView.findViewById(R.id.get_good_number);
            hv.get_pay_money = (TextView) convertView.findViewById(R.id.get_pay_money);

            hv.buy_continue = (ImageButton) convertView.findViewById(R.id.buy_continue);
            hv.buy_service = (ImageButton) convertView.findViewById(R.id.buy_service);
            hv.buy_get = (ImageButton) convertView.findViewById(R.id.buy_get);

            convertView.setTag(hv);
        }else {
            hv = (HolderView) convertView.getTag();

        }

        Get get = gets.get(position);

        hv.buy_continue.setOnClickListener(this);
        hv.buy_service.setOnClickListener(this);
        hv.buy_get.setOnClickListener(this);


        return convertView;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.buy_continue:
//                intent = new Intent(context, ThirdPageActivity.class);
                Toast.makeText(context,"你点击了继续购买", Toast.LENGTH_SHORT).show();
                final Intent intent1 = intent.setClass(context, ThirdPageActivity.class);
                v.getContext().startActivity(intent1);
                break;
            case R.id.buy_service:
                Toast.makeText(context,"你点击了售后服务", Toast.LENGTH_SHORT).show();
                intent = new Intent(context, SaleSupportAct.class);
                v.getContext().startActivity(intent);

                break;
            case R.id.buy_get:
                Toast.makeText(context,"你点击了确认收货", Toast.LENGTH_SHORT).show();

                break;
            default:
                break;
        }

    }

    private static class HolderView{
        ImageView get_good_pic;
        TextView get_number;
        TextView get_good_number;
        TextView get_pay_money;

        ImageButton buy_continue;
        ImageButton buy_service;
        ImageButton buy_get;


    }
}
