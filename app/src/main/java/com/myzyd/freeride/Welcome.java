package com.myzyd.freeride;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.myzyd.freeride.logActivity.LogInActivity;

/*
 *启动页
 * Created by xiehehe on 15/8/31.
 */
public class Welcome extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        new Handler(new Handler.Callback() {
			//处理接收到的消息的方法
			@Override
			public boolean handleMessage(Message msg) {
				//实现页面跳转
				startActivity(new Intent(Welcome.this, LogInActivity.class));
				return false;
			}
		}).sendEmptyMessageDelayed(0, 3000);//表示延时三秒进行任务的执行
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
