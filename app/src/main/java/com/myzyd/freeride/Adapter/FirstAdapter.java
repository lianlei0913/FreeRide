package com.myzyd.freeride.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.myzyd.freeride.R;

/**
 * Created by xiehehe on 15/8/19.
 */
public class FirstAdapter extends BaseAdapter {

    private LinearLayout mFastBuyArr[] = null;
    private int mImgIdArr[] = null;
    private LayoutInflater inflater = null;

    public FirstAdapter(Context context,  int[] imgId) {
        super();
//        this.mFastBuyArr = fastbuy;
        this.mImgIdArr = imgId;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
//        return mFastBuyArr.length;
        return mImgIdArr.length;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {

            convertView = inflater.inflate(R.layout.page_first_girdview, null);
            holder = new ViewHolder();
            holder.layout = (LinearLayout) convertView
                    .findViewById(R.id.fast_buy);
            holder.image = (ImageView) convertView
                    .findViewById(R.id.gridview_img);
            holder.image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.out.println("你点击了第" + position + "项");
                }
            });

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();

        }

        // 设置内容
//        holder.layout.set(mFastBuyArr[position]);
        holder.image.setBackgroundResource(mImgIdArr[position]);

        return convertView;
    }

    private class ViewHolder {
        LinearLayout layout = null;
        ImageView image = null;
    }
}
