package com.myzyd.freeride.service;

import android.util.Log;

import com.myzyd.freeride.logActivity.LogInActivity;

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


        if (userName.equals("sa") &&userPwd.equals("123")){

        }else {
            throw new ServiceRunExp(LogInActivity.MSG_LOGIN_ERROR);
        }

//        HttpClient client = new DefaultHttpClient();
//
//        String uri = "http://192.168.1.108:8080/MessRoomService/isLogin";
//
//        HttpPost post = new HttpPost(uri);
//
//        JSONObject object = new JSONObject();
//        object.put("userName", userName);
//        object.put("userPwd", userPwd);
//
//        post.setEntity(new StringEntity(object.toString()));
//
//         HttpResponse response = client.execute(post);
//
////        HttpResponse response = client.execute(get);
//
//        int code = response.getStatusLine().getStatusCode();
//
//        if(code != HttpStatus.SC_OK){
//            throw new ServiceRunExp(LogInActivity.MSG_SERVICE_ERROR);
//        }
//
//        String result = EntityUtils.toString(response.getEntity(), "UTF-8");
//
//        if(result.equals("true")){
//
//
//        }else {
//            throw new ServiceRunExp(LogInActivity.MSG_LOGIN_ERROR);
//        }
//
    }
}
