package com.electronicbookkeeping.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.electronicbookkeeping.android.db.Password;

import org.litepal.crud.DataSupport;

import java.util.List;

public class Unlock extends AppCompatActivity {

    private TextView pwdtext;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button0;
    private Button buttondel;
    private Button buttonOk;

    private List<Password> pswlist;
    private StringBuffer psw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unlock);
        pwdtext = (TextView) findViewById(R.id.unlock_pwd_text);
        button0 = (Button) findViewById(R.id.button_pws_0);
        button1 = (Button) findViewById(R.id.button_pws_1);
        button2 = (Button) findViewById(R.id.button_pws_2);
        button3 = (Button) findViewById(R.id.button_pws_3);
        button4 = (Button) findViewById(R.id.button_pws_4);
        button5 = (Button) findViewById(R.id.button_pws_5);
        button6 = (Button) findViewById(R.id.button_pws_6);
        button7 = (Button) findViewById(R.id.button_pws_7);
        button8 = (Button) findViewById(R.id.button_pws_8);
        button9 = (Button) findViewById(R.id.button_pws_9);
        buttondel = (Button) findViewById(R.id.button_pws_del);
        buttonOk = (Button) findViewById(R.id.button_pws_ok);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psw.append(0);
                pwdtext.setText(psw.toString());
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psw.append(1);
                pwdtext.setText(psw.toString());
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psw.append(2);
                pwdtext.setText(psw.toString());
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psw.append(3);
                pwdtext.setText(psw.toString());
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psw.append(4);
                pwdtext.setText(psw.toString());
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psw.append(5);
                pwdtext.setText(psw.toString());
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psw.append(6);
                pwdtext.setText(psw.toString());
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psw.append(7);
                pwdtext.setText(psw.toString());
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psw.append(8);
                pwdtext.setText(psw.toString());
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psw.append(9);
                pwdtext.setText(psw.toString());
            }
        });
        buttondel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psw.delete(0,psw.length());
                pwdtext.setText("");
            }
        });
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = psw.toString();
                pswlist = DataSupport.findAll(Password.class);
                if(password.equals(pswlist.get(0).getPwd())){
                    Intent intent = new Intent(Unlock.this,MainActivity.class);
                    startActivity(intent);
                }else {
                    psw.delete(0,psw.length());
                    pwdtext.setText("");
                    Toast.makeText(Unlock.this,"密码错误",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
