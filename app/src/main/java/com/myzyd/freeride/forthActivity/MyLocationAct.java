package com.myzyd.freeride.forthActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.myzyd.freeride.MainActivity;
import com.myzyd.freeride.R;

/**
 * Created by xiehehe on 15/7/30.
 */
public class MyLocationAct extends MainActivity {

    private ImageButton locationBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forth_location);
        LocationInitView();
    }

    private void LocationInitView() {
        locationBack = (ImageButton) findViewById(R.id.location_back);

        locationBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("返回个人中心");
                finish();
            }
        });
    }
}
