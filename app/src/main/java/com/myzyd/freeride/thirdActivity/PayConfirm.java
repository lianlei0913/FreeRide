package com.myzyd.freeride.thirdActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;

import com.myzyd.freeride.R;

/**
 * Created by xiehehe on 15/8/10.
 */
public class PayConfirm extends Activity {

    private ImageButton payConfirmBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_third_pay_confirm);
        InitView();
    }

    //初始化控件方法

    public void InitView() {

        payConfirmBack = (ImageButton) findViewById(R.id.pay_confirm_back);
        payConfirmBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog();
            }
        });
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
}
