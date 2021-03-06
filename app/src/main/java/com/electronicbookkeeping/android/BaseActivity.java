package com.electronicbookkeeping.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.electronicbookkeeping.android.db.Password;

import org.litepal.crud.DataSupport;

/**
 * Created by shock on 2018/1/19.
 */

public class BaseActivity extends AppCompatActivity{

    MyApplication myApplication;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myApplication.isreturn = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        myApplication = (MyApplication) getApplication();
        if(DataSupport.findAll(Password.class).size()>0){
            if(myApplication.isreturn){
               finish();
            }
            else if(myApplication.isLocked){
                Intent intent = new Intent(this,Unlock.class);
                startActivity(intent);
            }
        }
    }



}
