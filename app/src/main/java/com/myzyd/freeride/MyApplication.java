package com.myzyd.freeride;

import android.app.Application;
import android.content.Context;

/**
 * Created by xiehehe on 15/8/31.
 */
public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {  //编译通过？？
        context = getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }
}
