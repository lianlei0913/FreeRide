package com.myzyd.freeride.thirdActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

import com.myzyd.freeride.MyApplication;
import com.myzyd.freeride.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by xiehehe on 15/8/10.
 */
public class PayConfirm extends Activity implements View.OnClickListener {


    @InjectView(R.id.radioButton1)
    RadioButton radioButton1;
    @InjectView(R.id.radioButton2)
    RadioButton radioButton2;
    @InjectView(R.id.radioButton3)
    RadioButton radioButton3;
    @InjectView(R.id.radioButton4)
    RadioButton radioButton4;
    @InjectView(R.id.radioButton5)
    RadioButton radioButton5;
    @InjectView(R.id.pay_confirm_back)
    ImageButton payConfirmBack;
    @InjectView(R.id.PayAll)
    ImageButton Pay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_third_pay_confirm);
        ButterKnife.inject(this);
        InitView();
    }

    //初始化控件方法

    public void InitView() {
        radioButton1.setOnClickListener(this);
        radioButton2.setOnClickListener(this);
        radioButton3.setOnClickListener(this);
        radioButton4.setOnClickListener(this);
        radioButton5.setOnClickListener(this);
        payConfirmBack.setOnClickListener(this);
        Pay.setOnClickListener(this);
    }


    //dialog 弹出方法

    public void Dialog() {
        new AlertDialog.Builder(PayConfirm.this).setTitle("取消支付")
                .setMessage("确认取消支付当前订单，取消后交易将不再进行")
                .setPositiveButton("我要取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setNegativeButton("继续买咯", null).show();
    }


    //监听back键，取消支付

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            Dialog();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.radioButton1:
                showStyle();
                radioButton1.setChecked(true);
                break;
            case R.id.radioButton2:
                showStyle();
                radioButton2.setChecked(true);
                break;
            case R.id.radioButton3:
                showStyle();
                radioButton3.setChecked(true);
                break;
            case R.id.radioButton4:
                showStyle();
                radioButton4.setChecked(true);
                break;
            case R.id.radioButton5:
                showStyle();
                radioButton5.setChecked(true);
                break;
            case R.id.pay_confirm_back:
                Dialog();
                break;
            case R.id.PayAll:
                Toast.makeText(MyApplication.getContext(), "跳转支付页面", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    private void showStyle() {
        radioButton1.setChecked(false);
        radioButton2.setChecked(false);
        radioButton3.setChecked(false);
        radioButton4.setChecked(false);
        radioButton5.setChecked(false);
    }
}
