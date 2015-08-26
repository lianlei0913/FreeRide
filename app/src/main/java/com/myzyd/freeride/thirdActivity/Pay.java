package com.myzyd.freeride.thirdActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;

import com.myzyd.freeride.R;

/**
 * Created by xiehehe on 15/8/8.
 */
public class Pay extends Activity {

    private ImageButton payBackBtn, payChangeBtn, payChangedBtn, orderConfirmBtn;
    private EditText nameET, phoneET, adressET, noteET;
    private RadioButton receive1, receive2;
    private String name_string, phone_string, adress_string, note_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_third_pay_sure);
        InitView();
    }

    public void InitView() {

        //点击确认订单的修改按钮
        payChangeBtn = (ImageButton) findViewById(R.id.pay_xiugai);
        payChangeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                payChangeBtn.setVisibility(View.GONE);
                payChangedBtn.setVisibility(View.VISIBLE);

                nameET.setEnabled(true);
                nameET.requestFocus();
                nameET.setFocusableInTouchMode(true);
                nameET.setBackgroundResource(R.drawable.kuang_shuru);
                keyboard();

                phoneET.setEnabled(true);
                phoneET.requestFocus();
                phoneET.setFocusableInTouchMode(true);
                phoneET.setBackgroundResource(R.drawable.kuang_shuru);

                adressET.setEnabled(true);
                adressET.requestFocus();
                adressET.setFocusableInTouchMode(true);
                adressET.setBackgroundResource(R.drawable.kuang_shuru);

                noteET.setEnabled(true);
                noteET.requestFocus();
                noteET.setFocusableInTouchMode(true);
                noteET.setBackgroundResource(R.drawable.kuang_shuru);
                receive2.setVisibility(View.VISIBLE);
                receive1.setVisibility(View.VISIBLE);

            }
        });

        //点击确认订单的完成按钮
        payChangedBtn = (ImageButton) findViewById(R.id.pay_wancheng);
        payChangedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                payChangeBtn.setVisibility(View.VISIBLE);
                payChangedBtn.setVisibility(View.GONE);
//                name_string = nameET.getText().toString();
//                nameET.setText(name_string);
                nameET.setEnabled(false);
                nameET.requestFocus();
                nameET.setFocusableInTouchMode(false);
                keyboard();

                phoneET.setEnabled(false);
                phoneET.requestFocus();
                phoneET.setFocusableInTouchMode(false);

                adressET.setEnabled(false);
                adressET.requestFocus();
                adressET.setFocusableInTouchMode(false);

                noteET.setEnabled(false);
                noteET.requestFocus();
                noteET.setFocusableInTouchMode(false);

                if (receive1.isChecked()) {
                    receive1.setVisibility(View.VISIBLE);
                    receive2.setVisibility(View.GONE);
                } else {
                    receive1.setVisibility(View.GONE);
                    receive2.setVisibility(View.VISIBLE);
                }

            }
        });

        //点击确认订单的确认按钮
        orderConfirmBtn = (ImageButton) findViewById(R.id.order_confirm);
        orderConfirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Pay.this, PayConfirm.class);
                startActivity(intent);
            }
        });

        //点击确认订单的返回按钮
        payBackBtn = (ImageButton) findViewById(R.id.pay_back);
        payBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        nameET = (EditText) findViewById(R.id.receiver_name);
        phoneET = (EditText) findViewById(R.id.receiver_phone);
        adressET = (EditText) findViewById(R.id.receiver_address);
        receive1 = (RadioButton) findViewById(R.id.receiver_way_1);
        receive2 = (RadioButton) findViewById(R.id.receiver_way_2);
        noteET = (EditText) findViewById(R.id.receicer_note);
    }


    //开启键盘以及关闭键盘方法
    public void keyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive()) {
            imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
