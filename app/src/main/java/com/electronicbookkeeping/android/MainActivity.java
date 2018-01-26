package com.electronicbookkeeping.android;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.electronicbookkeeping.android.db.Password;

import org.litepal.crud.DataSupport;

import java.util.List;

public class MainActivity extends BaseActivity {

    MyApplication myApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bookkeep = (Button) findViewById(R.id.button_bookkeep);
        Button statictics = (Button) findViewById(R.id.button_statistics);
        Button password = (Button) findViewById(R.id.button_password);

        bookkeep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        statictics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        myApplication.isLocked = true;
    }
}
