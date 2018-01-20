package com.electronicbookkeeping.android;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.electronicbookkeeping.android.db.Password;

import org.litepal.LitePalApplication;
import org.litepal.crud.DataSupport;

/**
 * Created by shock on 2018/1/18.
 */

public class MyApplication extends Application {
    private static Context context;

    public static boolean isLocked = true;
    public static boolean isreturn ;

    private UnlockBroadcast unlockBroadcast;


    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        LitePalApplication.initialize(context);

        IntentFilter intentFilter =  new IntentFilter();
        //添加想要监听的广播
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
        unlockBroadcast = new UnlockBroadcast();
        //注册广播
        registerReceiver(unlockBroadcast,intentFilter);

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        unregisterReceiver(unlockBroadcast);//取消注册广播
    }

    public static Context getContext(){
        return context;
    }

    class UnlockBroadcast extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            //接收锁屏的广播，处理APP锁屏
            if (Intent.ACTION_SCREEN_OFF.equals(intent.getAction())) {
                isLocked  = true;
                isreturn  = false;
            }
        }
    }
}
