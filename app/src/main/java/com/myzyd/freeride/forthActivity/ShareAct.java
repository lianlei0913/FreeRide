package com.myzyd.freeride.forthActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.myzyd.freeride.R;
import com.myzyd.freeride.Utils.LogUtil;

/**
 * Created by xiehehe on 15/7/31.
 */
public class ShareAct extends Activity {

    private ImageButton shareBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forth_share);
        ShareInitView();
    }

    public void ShareInitView() {
        shareBack = (ImageButton) findViewById(R.id.share_back);
        shareBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtil.d("ShareAct", "返回个人中心");
                finish();
            }
        });

    }
}
