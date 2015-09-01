package com.myzyd.freeride.logActivity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.telephony.SmsMessage;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.myzyd.freeride.MyApplication;
import com.myzyd.freeride.R;
import com.myzyd.freeride.Utils.LogUtil;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xiehehe on 15/7/23.
 */
public class LogonActivity extends Activity implements View.OnClickListener {

    protected LinearLayout logOn_layout, logOn2_layout, logOn3_layout;
    protected Button getCode_btn, reSend_btn, sure_btn, sure2_btn;
    protected EditText phone_et, code_et, setPwd_et, confirmPwd_et;
    protected ImageButton logonBackBtn;
    protected CheckBox checkBox;
    private CountTimer countTimer;
    private BroadcastReceiver smsReceiver;
    private IntentFilter filter2;
    private Handler handler;
    private String strContent;
    //六位数字匹配
    private String patternCoder = "(?<!\\d)\\d{6}(?!\\d)";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logon);
        initView();
        hideView();
        logOn_layout.setVisibility(View.VISIBLE);


        //自动填充验证码
        handler = new Handler() {
            public void handleMessage(android.os.Message msg) {
                code_et.setText(strContent);
            }
        };
        filter2 = new IntentFilter();
        filter2.addAction("android.provider.Telephony.SMS_RECEIVED");
        filter2.setPriority(Integer.MAX_VALUE);
        smsReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Object[] objs = (Object[]) intent.getExtras().get("pdus");
                for (Object obj : objs) {
                    byte[] pdu = (byte[]) obj;
                    SmsMessage sms = SmsMessage.createFromPdu(pdu);
                    // 短信的内容
                    String message = sms.getMessageBody();
                    Log.d("logo", "message     " + message);
                    // 短息的手机号。。+86开头？
                    String from = sms.getOriginatingAddress();
                    Log.d("logo", "from     " + from);
                    // Time time = new Time();
                    // time.set(sms.getTimestampMillis());
                    // String time2 = time.format3339(true);
                    // Log.d("logo", from + "   " + message + "  " + time2);
                    // strContent = from + "   " + message;
                    // handler.sendEmptyMessage(1);
                    if (!TextUtils.isEmpty(from)) {
                        String code = patternCode(message);
                        if (!TextUtils.isEmpty(code)) {
                            strContent = code;
                            handler.sendEmptyMessage(1);
                        }
                    }
                }
            }
        };
        registerReceiver(smsReceiver, filter2);
    }

    //初始化页面及其点击按钮
    public void initView() {
        logOn_layout = (LinearLayout) findViewById(R.id.logon_layout);
        logOn2_layout = (LinearLayout) findViewById(R.id.logon2_layout);
        logOn3_layout = (LinearLayout) findViewById(R.id.logon3_layout);

        //一分钟
        countTimer = new CountTimer(60000, 1000);

        getCode_btn = (Button) findViewById(R.id.getCode_btn);
        getCode_btn.setOnClickListener(this);
        reSend_btn = (Button) findViewById(R.id.reSend_btn);
        reSend_btn.setOnClickListener(this);
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

                if(phone_et.getText().length() <= 10){
                    Toast.makeText(MyApplication.getContext(), "请正确输入电话号码", Toast.LENGTH_SHORT).show();
                }
                else if (!(checkBox.isChecked())) {
                    Toast.makeText(MyApplication.getContext(), "请阅读并同意自由搭用户协议", Toast.LENGTH_SHORT).show();
                }
                else {
                    LogUtil.d("LogonActivity", "点击获取验证码");
                    hideView();
                    // 开启倒计时
                    countTimer.start();
                    //请求验证码并跳转到输入验证码页面
                    new AT().execute(phone_et.getText().toString());
                    logOn_layout.setVisibility(View.GONE);
                    logOn2_layout.setVisibility(View.VISIBLE);
                }
                break;

            case R.id.reSend_btn:
                logOn_layout.setVisibility(View.VISIBLE);
                logOn2_layout.setVisibility(View.GONE);
                break;

            case R.id.sure_btn:
                if (code_et.getText().length() <=5) {
                    Toast.makeText(MyApplication.getContext(), "请正确填写验证码", Toast.LENGTH_SHORT).show();
                } else {
                    hideView();
                    logOn2_layout.setVisibility(View.GONE);
                    logOn3_layout.setVisibility(View.VISIBLE);
                }
                break;

            case R.id.sure2_btn:
                new AT().execute(phone_et.getText().toString(), setPwd_et.getText().toString(), "flag");
                startActivity(new Intent(MyApplication.getContext(), LogInActivity.class));
                Toast.makeText(MyApplication.getContext(), "注册成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.logon_back_btn:
                finish();
            default:
                break;
        }
    }

    //网络请求
    class AT extends AsyncTask {
        @Override
        public String doInBackground(Object[] params) {
            try {
                //请求数据
                HttpClient hc = new DefaultHttpClient();

                //注册请求
                JSONObject jo = new JSONObject();
                if (params.length > 1) {
                    HttpPost hp = new HttpPost("http://192.168.1.104:8080/Ziyoudaprj/Userservlet");
                    jo.put("iphone", params[0]);
                    jo.put("userPwd", params[1]);
                    jo.put("flag", params[2]);
                    hp.setEntity(new StringEntity(jo.toString()));
                    HttpResponse hr = hc.execute(hp);
                    LogUtil.d("LogonActivity", "注册完成");
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
                } else {
                    //验证码请求
                    HttpPost hp = new HttpPost("http://192.168.1.104:8080/Ziyoudaprj/duanxinservlet");
                    jo.put("iphone", params[0]);
                    hp.setEntity(new StringEntity(jo.toString()));
                    HttpResponse hr = hc.execute(hp);
                    LogUtil.d("LogonActivity", "发送完成");

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
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(smsReceiver);
    }

    /**
     * 匹配短信中间的6个数字（验证码）
     * @param patternContent
     * @return
     */
    private String patternCode(String patternContent) {
        if (TextUtils.isEmpty(patternContent)) {
            return null;
        }
        Pattern p = Pattern.compile(patternCoder);
        Matcher matcher = p.matcher(patternContent);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    // 每隔一分钟可点击一次验证码
    public class CountTimer extends CountDownTimer {
        /**
         * @param millisInFuture
         *            时间间隔是多长的时间
         * @param countDownInterval
         *            回调onTick方法，没隔多久执行一次
         */
        public CountTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        // 间隔时间结束的时候调用的方法
        @Override
        public void onFinish() {
            // 更新页面的组件
            reSend_btn.setText("重新验证");

            reSend_btn.setClickable(true);
        }

        // 间隔时间内执行的操作
        @Override
        public void onTick(long millisUntilFinished) {
            // 更新页面的组件
            reSend_btn.setText(millisUntilFinished / 1000 + "秒后重新发送");
            reSend_btn.setClickable(false);
        }

    }

}
