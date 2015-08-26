package com.myzyd.freeride.forthActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.myzyd.freeride.MainActivity;
import com.myzyd.freeride.R;

/**
 * Created by xiehehe on 15/7/30.
 */
public class UpdateAct extends MainActivity {

    private ImageButton updateBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forth_update);
        UpdateInitView();
    }

    public void UpdateInitView() {
        updateBack = (ImageButton) findViewById(R.id.update_back);
        updateBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("返回个人中心");
                finish();
            }
        });

    }
}
