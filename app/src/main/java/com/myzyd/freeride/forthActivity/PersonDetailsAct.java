package com.myzyd.freeride.forthActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.myzyd.freeride.R;

/**
 * Created by xiehehe on 15/7/29.
 */


public class PersonDetailsAct extends Activity{

    private ImageButton personBack,baocunBtn, xiugaiBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forth_person);
        PersonInitView();
    }

    private void PersonInitView() {
        personBack = (ImageButton) findViewById(R.id.person_back);
        baocunBtn = (ImageButton) findViewById(R.id.baocun);
        xiugaiBtn = (ImageButton) findViewById(R.id.xiugai);

        personBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        baocunBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xiugaiBtn.setVisibility(View.VISIBLE);
                baocunBtn.setVisibility(View.GONE);
            }
        });
        xiugaiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xiugaiBtn.setVisibility(View.GONE);
                baocunBtn.setVisibility(View.VISIBLE);
            }
        });
    }

}
