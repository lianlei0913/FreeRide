package com.myzyd.freeride.forthActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.myzyd.freeride.MainActivity;
import com.myzyd.freeride.R;

/**
 * Created by xiehehe on 15/7/30.
 */
public class SuggestAct extends MainActivity {

    private ImageButton suggestBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forth_suggest);
        SuggestInitView();
    }

    public void SuggestInitView() {
        suggestBtn = (ImageButton) findViewById(R.id.suggest_back);
        suggestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("返回个人中心");
                finish();
            }
        });
    }
}
