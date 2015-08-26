package com.myzyd.freeride.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.myzyd.freeride.R;
import com.myzyd.freeride.thirdActivity.Car;

import java.util.List;

/**
 * Created by xiehehe on 15/8/20.
 */
public class ThirdAdapter extends BaseAdapter implements View.OnClickListener {

    private Context context;
    private List<Car> cars;

    public ThirdAdapter(Context context, List<Car> cars) {
        this.context = context;
        this.cars = cars;

    }

    @Override
    public int getCount() {
        return cars.size();
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
        ViewHolder vh = null;
        if (convertView == null) {
            vh = new ViewHolder();
            convertView = inflater.inflate(R.layout.shop_trolley_cell, null);
            vh.good_photo = (ImageView) convertView.findViewById(R.id.good_photo);
            vh.good_name = (TextView) convertView.findViewById(R.id.good_name);
//            vh.textView = (TextView) convertView.findViewById(R.id.textView);
            vh.sell_price = (TextView) convertView.findViewById(R.id.sell_price);
//            vh.textView8 = (TextView) convertView.findViewById(R.id.textView8);
            vh.sub_button = (ImageButton) convertView.findViewById(R.id.sub_button);
            vh.add_button = (ImageButton) convertView.findViewById(R.id.add_button);
            vh.sell_num = (EditText) convertView.findViewById(R.id.sell_num);

//            vh.textView2 = (TextView) convertView.findViewById(R.id.textView2);
            vh.all_price = (TextView) convertView.findViewById(R.id.all_price);

            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        Car car = cars.get(position);
        vh.good_photo.setImageResource(car.getImgId());
        vh.good_name.setText(car.getName());
        vh.sell_price.setText("2.5");
        vh.sell_num.setText("10");


        vh.sub_button.setOnClickListener(this);
        vh.add_button.setOnClickListener(this);

        return convertView;
    }

    //加减按钮的实现
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sub_button:
                Toast.makeText(context, "你点击了减号", Toast.LENGTH_SHORT).show();
                break;
            case R.id.add_button:
                Toast.makeText(context, "你点击了加号", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }


    }

    private static class ViewHolder {
        ImageView good_photo;
        TextView good_name;
//        TextView textView;
        TextView sell_price;
//        TextView textView8;
        ImageButton sub_button;
        ImageButton add_button;
        EditText sell_num;

//        TextView textView2;
        TextView all_price;

    }

}

