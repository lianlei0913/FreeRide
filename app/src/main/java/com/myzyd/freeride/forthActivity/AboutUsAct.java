package com.myzyd.freeride.forthActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.myzyd.freeride.MainActivity;
import com.myzyd.freeride.R;
import com.myzyd.freeride.Utils.LogUtil;

/**
 * Created by xiehehe on 15/7/30.
 */
public class AboutUsAct extends MainActivity {

    private ImageButton aboutUsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forth_about);

        aboutUsBtn = (ImageButton) findViewById(R.id.about_us_back);
        aboutUsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtil.d("AboutUsAct", "返回个人中心");
                finish();
            }
        });
    }
}
