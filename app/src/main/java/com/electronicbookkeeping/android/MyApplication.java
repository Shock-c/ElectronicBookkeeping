package com.electronicbookkeeping.android;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
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

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        LitePalApplication.initialize(context);


    }
    public static Context getContext(){
        return context;
    }



}
