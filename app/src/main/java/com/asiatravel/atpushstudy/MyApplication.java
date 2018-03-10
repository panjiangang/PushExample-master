package com.asiatravel.atpushstudy;

import android.app.Application;
import android.util.Log;

import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

public class MyApplication extends Application {

    private static final String TAG = "MyApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        initUPush();
    }

    private void initUPush() {
        PushAgent mPushAgent = PushAgent.getInstance(this);
        //注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {
            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
                Log.d(TAG, "onSuccess: deviceToken-->" + deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {
                Log.d(TAG, "onFailure: s-->" + s);
                Log.d(TAG, "onFailure: s1-->" + s1);
            }
        });
    }
}
