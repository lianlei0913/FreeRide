package com.myzyd.freeride.service;

import android.util.Log;

import com.myzyd.freeride.Utils.HttpUtils;
import com.myzyd.freeride.logActivity.LogInActivity;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
 * Created by xiehehe on 15/7/28.
 */
public class UserServiceImpl implements UserService {

    private static final String TAG = "UserServiceImpl";

    @Override
    public void userLogin(String userName, String userPwd) throws Exception {
        Log.d(TAG,userName);
        Log.d(TAG,userPwd);

        Thread.sleep(2000);

//
//        if (userName.equals("sa") &&userPwd.equals("123")){
//
//        }else {
//            throw new ServiceRunExp(LogInActivity.MSG_LOGIN_ERROR);
//        }

        HttpClient client = new DefaultHttpClient();

        //请求登录
        HttpPost post = new HttpPost(HttpUtils.LogIn);

        JSONObject object = new JSONObject();
        object.put("userName", userName);
        object.put("userPwd", userPwd);

        post.setEntity(new StringEntity(object.toString()));

         HttpResponse response = client.execute(post);

//        HttpResponse response = client.execute(get);

        int code = response.getStatusLine().getStatusCode();

        if(code != HttpStatus.SC_OK){
            throw new ServiceRunExp(LogInActivity.MSG_SERVICE_ERROR);
        }

        String result = EntityUtils.toString(response.getEntity(), "UTF-8");

        if(result.equals("ture")){


        }else {
            throw new ServiceRunExp(LogInActivity.MSG_LOGIN_ERROR);
        }

    }
}
