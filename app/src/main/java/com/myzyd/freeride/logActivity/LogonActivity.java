package com.myzyd.freeride.logActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.myzyd.freeride.MyApplication;
import com.myzyd.freeride.R;
import com.myzyd.freeride.Receiver.SMSBroadcastReceiver;
import com.myzyd.freeride.Utils.LogUtil;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
 * Created by xiehehe on 15/7/23.
 */
public class LogonActivity extends Activity implements View.OnClickListener {

    protected LinearLayout logOn_layout, logOn2_layout, logOn3_layout;
    protected Button getCode_btn, reSend_btn, sure_btn, sure2_btn;
    protected EditText phone_et, code_et, setPwd_et, confirmPwd_et;
    protected ImageButton logonBackBtn;
    protected CheckBox checkBox;

    private SMSBroadcastReceiver mSMSBroadcastReceiver;
    private static final String ACTION = "android.provider.Telephony.SMS_RECEIVED";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logon);
        initView();
        hideView();
        logOn_layout.setVisibility(View.VISIBLE);
    }

    //初始化页面及其点击按钮
    public void initView() {
        logOn_layout = (LinearLayout) findViewById(R.id.logon_layout);
        logOn2_layout = (LinearLayout) findViewById(R.id.logon2_layout);
        logOn3_layout = (LinearLayout) findViewById(R.id.logon3_layout);

        getCode_btn = (Button) findViewById(R.id.getCode_btn);
        getCode_btn.setOnClickListener(this);
        reSend_btn = (Button) findViewById(R.id.reSend_btn);
        sure_btn = (Button) findViewById(R.id.sure_btn);
        sure_btn.setOnClickListener(this);
        sure2_btn = (Button) findViewById(R.id.sure2_btn);
        sure2_btn.setOnClickListener(this);

        phone_et = (EditText) findViewById(R.id.phone_et);
        code_et = (EditText) findViewById(R.id.code_et);
        setPwd_et = (EditText) findViewById(R.id.setPwd_et);
        confirmPwd_et = (EditText) findViewById(R.id.confirmPwd_et);

        logonBackBtn = (ImageButton) findViewById(R.id.logon_back_btn);
        logonBackBtn.setOnClickListener(this);

        checkBox = (CheckBox) findViewById(R.id.logon_checkBox);

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

                if (!(checkBox.isChecked())) {
                    Toast.makeText(MyApplication.getContext(), "请阅读并同意自由搭用户协议", Toast.LENGTH_SHORT).show();
                } else {
                    LogUtil.d("LogonActivity", "点击获取验证码");
                    hideView();

                    //请求验证码并跳转到输入验证码页面
                    new AT().execute(phone_et.getText().toString());
                    logOn_layout.setVisibility(View.GONE);
                    logOn2_layout.setVisibility(View.VISIBLE);
                }
                break;

            case R.id.reSend_btn:

                break;

            case R.id.sure_btn:
                if (code_et.getText().toString() ==null){
                    Toast.makeText(MyApplication.getContext(), "请正确填写验证码", Toast.LENGTH_SHORT).show();
                }
                else {
                    hideView();
                    logOn2_layout.setVisibility(View.GONE);
                    logOn3_layout.setVisibility(View.VISIBLE);
                }
                break;

            case R.id.sure2_btn:
                new AT().execute(phone_et.getText().toString(), setPwd_et.getText().toString());
                startActivity(new Intent(MyApplication.getContext(), LogInActivity.class));
                break;

            case R.id.logon_back_btn:
                finish();
            default:
                break;
        }
    }

    class AT extends AsyncTask {
        @Override
        public String doInBackground(Object[] params) {
            try {
                //请求数据
                HttpClient hc = new DefaultHttpClient();
                HttpPost hp = new HttpPost("http://192.168.1.104:8080/Ziyoudaprj/duanxinservlet");
                //请求json
                JSONObject jo = new JSONObject();
                if (params.length > 1) {
                    jo.put("iphone", params[0]);
                    jo.put("userPwd", params[1]);
                } else {
                    jo.put("iphone", params[0]);
                }
                hp.setEntity(new StringEntity(jo.toString()));
                HttpResponse hr = hc.execute(hp);
                String result = null;
                if (hr.getStatusLine().getStatusCode() == 200) {
                    result = EntityUtils.toString(hr.getEntity());
                    //判断返回结果接收
                    if (result != null) {
                    } else {
                    }
                }
                if (hc != null) {
                    hc.getConnectionManager().shutdown();
                }
                return result;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        //生成广播处理
        mSMSBroadcastReceiver = new SMSBroadcastReceiver();

        //实例化过滤器并设置要过滤的广播
        IntentFilter intentFilter = new IntentFilter(ACTION);
        intentFilter.setPriority(Integer.MAX_VALUE);
        //注册广播
        this.registerReceiver(mSMSBroadcastReceiver, intentFilter);

        mSMSBroadcastReceiver.setOnReceivedMessageListener(new SMSBroadcastReceiver.MessageListener() {
            @Override
            public void onReceived(String message) {

                code_et.setText(message);

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //注销短信监听广播
        this.unregisterReceiver(mSMSBroadcastReceiver);
    }
}
