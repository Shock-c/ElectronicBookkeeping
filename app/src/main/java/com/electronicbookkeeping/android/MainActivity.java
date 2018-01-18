package com.electronicbookkeeping.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.electronicbookkeeping.android.db.Password;

import org.litepal.crud.DataSupport;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<Password> pswlist = DataSupport.findAll(Password.class);
        if(pswlist != null) {
            Intent intent = new Intent(this, Unlock.class);
            startActivity(intent);
        }

        setContentView(R.layout.activity_main);

        final EditText setpswtext = (EditText) findViewById(R.id.edit_setpsw);
        Button setpsw = (Button) findViewById(R.id.button_setpsw);

        setpsw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Password password = new Password();
                password.setPwd(setpswtext.getText().toString());
                password.save();

                setpswtext.setText("");
            }
        });

    }
}
