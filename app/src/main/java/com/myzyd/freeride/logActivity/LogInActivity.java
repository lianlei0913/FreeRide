package com.myzyd.freeride.logActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.myzyd.freeride.MainActivity;
import com.myzyd.freeride.R;
import com.myzyd.freeride.service.ServiceRunExp;
import com.myzyd.freeride.service.UserService;
import com.myzyd.freeride.service.UserServiceImpl;

import java.lang.ref.WeakReference;

/**
 * Created by xiehehe on 15/7/24.
 */
public class LogInActivity extends Activity implements View.OnClickListener {

    public EditText logInName, passWord;
    public Button login_btn, forget_btn, logon_btn;
    public TextView see_tv;
    public Intent intent;
    private UserService userService = new UserServiceImpl();
    private ProgressDialog dialog;


    private static final int Flag_login_success = 1;
    private static final String Flag_login_error = "登录失败";
    private static final String MSG_LOGIN_SUCCESS = "登录成功";
    public static final String MSG_LOGIN_ERROR = "登录名或密码错误";
    public static final String MSG_SERVICE_ERROR = "请求服务器错误";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        initView();
    }

    public void initView() {
        logInName = (EditText) findViewById(R.id.user_name);
        passWord = (EditText) findViewById(R.id.passWord);
        login_btn = (Button) findViewById(R.id.login);
        forget_btn = (Button) findViewById(R.id.forgetPassword);
        logon_btn = (Button) findViewById(R.id.logon);
        see_tv = (TextView) findViewById(R.id.see_tv);

        login_btn.setOnClickListener(this);
        forget_btn.setOnClickListener(this);
        logon_btn.setOnClickListener(this);
        see_tv.setClickable(true);
        see_tv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                final String userName = logInName.getText().toString();
                final String userPwd = passWord.getText().toString();

                if (dialog == null) {
                    dialog = new ProgressDialog(LogInActivity.this);
                }
                dialog.setTitle("请稍等哈~");
                dialog.setMessage("玩儿命联网登录中！");
                dialog.setCancelable(false);
                dialog.show();

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            userService.userLogin(userName, userPwd);
                            handler.sendEmptyMessage(1);
                        } catch (ServiceRunExp e) {
                            e.printStackTrace();
                            Message msg = new Message();
                            Bundle data = new Bundle();
                            data.putSerializable("ERROR_MSG", e.getMessage());
                            msg.setData(data);
                            handler.sendMessage(msg);
                        } catch (Exception e) {
                            e.printStackTrace();
                            Message msg = new Message();
                            Bundle data = new Bundle();
                            data.putSerializable("ERROR_MSG", Flag_login_error);
                            msg.setData(data);
                            handler.sendMessage(msg);
                        }
                    }
                });
                thread.start();

                break;

            case R.id.forgetPassword:

                break;
            case R.id.logon:
                intent = new Intent(LogInActivity.this, LogonActivity.class);
                startActivity(intent);

                break;

            case R.id.see_tv:
                intent = new Intent(LogInActivity.this, MainActivity.class);
                startActivity(intent);

                break;
        }

    }

    private void showTip(String str) {
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();

    }


    private class IHandler extends Handler {

        private final WeakReference<Activity> mActivity;

        public IHandler(LogInActivity activity) {
            mActivity = new WeakReference<Activity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {

            if (dialog != null) {
                dialog.dismiss();
            }

            int flag = msg.what;
            switch (flag) {
                case 0:
                    String errorMsg = (String) msg.getData().getSerializable("ERROR_MSG");
                    ((LogInActivity) mActivity.get()).showTip(errorMsg);
                    break;
                case Flag_login_success:
                    ((LogInActivity) mActivity.get()).showTip(MSG_LOGIN_SUCCESS);
                    intent = new Intent(LogInActivity.this, MainActivity.class);
                    startActivity(intent);
                default:
                    break;
            }
        }
    }

    private IHandler handler = new IHandler(this) {

    };



}
