package com.myzyd.freeride.forthActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.myzyd.freeride.MainActivity;
import com.myzyd.freeride.R;
import com.myzyd.freeride.Utils.LogUtil;

/**
 * Created by xiehehe on 15/7/30.
 */
public class MyAccountAct extends MainActivity {

    private ImageButton accountBack, addmoneyBtn;
    private RelativeLayout changePassWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forth_account);
        AccountInitView();
    }

    public void AccountInitView() {
        accountBack = (ImageButton) findViewById(R.id.account_back);
        addmoneyBtn = (ImageButton) findViewById(R.id.add_money);
        changePassWord = (RelativeLayout) findViewById(R.id.changePassword_layout);
        accountBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtil.d("MyAccountAct", "返回个人中心");
                finish();
            }
        });
        addmoneyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyAccountAct.this, MyAccountAddAct.class);
                startActivity(intent);
            }
        });
        changePassWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyAccountAct.this, MyAccountChangeAct.class);
                startActivity(intent);
            }
        });
    }

}
