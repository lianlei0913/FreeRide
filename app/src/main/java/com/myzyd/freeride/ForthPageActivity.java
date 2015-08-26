package com.myzyd.freeride;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.myzyd.freeride.forthActivity.AboutUsAct;
import com.myzyd.freeride.forthActivity.MyAccountAct;
import com.myzyd.freeride.forthActivity.MyLocationAct;
import com.myzyd.freeride.forthActivity.MyOrderAct;
import com.myzyd.freeride.forthActivity.MyOrderAct2;
import com.myzyd.freeride.forthActivity.MyOrderAct3;
import com.myzyd.freeride.forthActivity.MyOrderAct4;
import com.myzyd.freeride.forthActivity.PersonDetailsAct;
import com.myzyd.freeride.forthActivity.ShareAct;
import com.myzyd.freeride.forthActivity.SuggestAct;
import com.myzyd.freeride.forthActivity.UpdateAct;
import com.myzyd.freeride.logActivity.LogInActivity;

/**
 * Created by xiehehe on 15/7/29.
 */


public class ForthPageActivity extends Fragment {

    private RelativeLayout orderLayout, informationLayout,
            locationLayout, accountLayout, suggestionLayout,
            updateLayout, aboutLayout, shareLayout;

    private ImageButton orderBtn, unfinishBtn, finishBtn, supportBtn;

    private Button exitLoginBtn;

    private Intent intent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.page_forth, container, false);
        View v = inflater.inflate(R.layout.page_forth, container, false);

        orderLayout = (RelativeLayout) v.findViewById(R.id.order_layout);
        orderLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("你点击了我的订单");
                intent = new Intent(getActivity(), MyOrderAct.class);
                startActivity(intent);
            }
        });
        //我的订单下排的四个按钮点击时间
        orderBtn = (ImageButton) v.findViewById(R.id.order_btn);
        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), MyOrderAct.class);
                startActivity(intent);
            }
        });
        unfinishBtn = (ImageButton) v.findViewById(R.id.unfinish_btn);
        unfinishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), MyOrderAct2.class);
                startActivity(intent);
            }
        });
        finishBtn = (ImageButton) v.findViewById(R.id.finish_btn);
        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), MyOrderAct3.class);
                startActivity(intent);
            }
        });
        supportBtn = (ImageButton) v.findViewById(R.id.support_btn);
        supportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), MyOrderAct4.class);
                startActivity(intent);
            }
        });

        //进入我的位置
        locationLayout = (RelativeLayout) v.findViewById(R.id.location_layout);
        locationLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("你点击了我的位置");
                intent = new Intent(getActivity(), MyLocationAct.class);
                startActivity(intent);
            }
        });

        //进入个人信息

        informationLayout = (RelativeLayout) v.findViewById(R.id.information_layout);
        informationLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("点击了个人信息");
                intent = new Intent(getActivity(), PersonDetailsAct.class);
                startActivity(intent);
            }
        });

        //进入个人账户
        accountLayout = (RelativeLayout) v.findViewById(R.id.account_layout);
        accountLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("你点击了个人账户");
                intent = new Intent(getActivity(), MyAccountAct.class);
                startActivity(intent);
            }
        });

        //进入意见反馈
        suggestionLayout = (RelativeLayout) v.findViewById(R.id.suggestion_layout);
        suggestionLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("你点击了意见反馈");
                intent = new Intent(getActivity(), SuggestAct.class);
                startActivity(intent);
            }
        });

        //进入版本更新

        updateLayout = (RelativeLayout) v.findViewById(R.id.update_layout);
        updateLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("你点击了版本更新");
                intent = new Intent(getActivity(), UpdateAct.class);
                startActivity(intent);
            }
        });

        //进入关于我们
        aboutLayout = (RelativeLayout) v.findViewById(R.id.about_layout);
        aboutLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("你点击了关于我们");
                intent = new Intent(getActivity(), AboutUsAct.class);
                startActivity(intent);
            }
        });

        //进入分享好友
        shareLayout = (RelativeLayout) v.findViewById(R.id.share_layout);
        shareLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("你点击了分享好友");
                intent = new Intent(getActivity(), ShareAct.class);
                startActivity(intent);
            }
        });

        //退出登录
        exitLoginBtn = (Button) v.findViewById(R.id.exit_login_btn);
        exitLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("退出登录");
                intent = new Intent(getActivity(), LogInActivity.class);
                startActivity(intent);
            }
        });


        return v;
    }


}
