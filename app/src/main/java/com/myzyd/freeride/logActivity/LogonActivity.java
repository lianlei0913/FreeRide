package com.myzyd.freeride.logActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.myzyd.freeride.R;

/**
 * Created by xiehehe on 15/7/23.
 */
public class LogonActivity extends Activity implements View.OnClickListener {

    protected LinearLayout logOn_layout, logOn2_layout, logOn3_layout;
    protected Button getCode_btn, reSend_btn, sure_btn, sure2_btn;
    protected EditText phone_et, code_et, setPwd_et, confirmPwd_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logon);
        initView();
    }

    //初始化页面及其点击按钮
    public void initView() {
        logOn_layout = (LinearLayout) findViewById(R.id.logon_layout);
        logOn2_layout = (LinearLayout) findViewById(R.id.logon2_layout);
        logOn3_layout = (LinearLayout) findViewById(R.id.logon3_layout);

        getCode_btn = (Button) findViewById(R.id.getCode_btn);
        reSend_btn = (Button) findViewById(R.id.reSend_btn);
        sure_btn = (Button) findViewById(R.id.sure_btn);
        sure2_btn = (Button) findViewById(R.id.sure2_btn);

        phone_et = (EditText) findViewById(R.id.phone_et);
        code_et = (EditText) findViewById(R.id.code_et);
        setPwd_et = (EditText) findViewById(R.id.setPwd_et);
        confirmPwd_et = (EditText) findViewById(R.id.confirmPwd_et);


    }

    //界面隐藏
    public void hideView() {
        logOn_layout.setVisibility(View.GONE);
        logOn2_layout.setVisibility(View.GONE);
        logOn3_layout.setVisibility(View.GONE);
    }


    //点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.getCode_btn:


                break;

            case R.id.reSend_btn:

                break;

            case R.id.sure_btn:

                break;

            case R.id.sure2_btn:

                break;

            default:
                break;
        }

    }
}
