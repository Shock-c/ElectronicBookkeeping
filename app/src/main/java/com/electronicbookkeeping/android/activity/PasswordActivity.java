package com.electronicbookkeeping.android.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.electronicbookkeeping.android.BaseActivity;
import com.electronicbookkeeping.android.R;
import com.electronicbookkeeping.android.db.Password;

import org.litepal.crud.DataSupport;

import java.util.List;

public class PasswordActivity extends BaseActivity {

    private LinearLayout colselayout ;
    private LinearLayout openlayout;
    private LinearLayout oldpwdlayout;
    private Button openorcolse;
    private EditText oldpwd;
    private EditText pwd;
    private EditText surepwd;
    private Button passwordok;

    private boolean ocflag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        colselayout = (LinearLayout) findViewById(R.id.close_layout);
        openlayout = (LinearLayout) findViewById(R.id.open_layout);
        oldpwdlayout = (LinearLayout) findViewById(R.id.oldpassword_layout);
        openorcolse = (Button) findViewById(R.id.button_in_out);
        oldpwd = (EditText) findViewById(R.id.oldpassword_edittext);
        passwordok = (Button) findViewById(R.id.button_setpwd_ok);
        pwd = (EditText) findViewById(R.id.password_edittext);
        surepwd = (EditText) findViewById(R.id.password0_edittext);


        if(DataSupport.findAll(Password.class).size() == 0){
            colselayout.setVisibility(View.VISIBLE);
            openlayout.setVisibility(View.GONE);
            openorcolse.setText("open");
            ocflag = false;
        }else{
            colselayout.setVisibility(View.GONE);
            openlayout.setVisibility(View.VISIBLE);
            oldpwdlayout.setVisibility(View.VISIBLE);
            openorcolse.setText("colse");
            ocflag = true;
        }

        openorcolse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ocflag){
                    colselayout.setVisibility(View.VISIBLE);
                    openlayout.setVisibility(View.GONE);
                    openorcolse.setText("open");
                    ocflag = false;
                    if(DataSupport.findAll(Password.class).size() > 0){
                        DataSupport.deleteAll(Password.class);
                    }

                }else{
                    colselayout.setVisibility(View.GONE);
                    openlayout.setVisibility(View.VISIBLE);
                    oldpwdlayout.setVisibility(View.VISIBLE);
                    openorcolse.setText("colse");
                    ocflag = true;
                    if(DataSupport.findAll(Password.class).size() == 0){
                        oldpwdlayout.setVisibility(View.GONE);
                    }

                }
            }
        });

        passwordok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(DataSupport.findAll(Password.class).size() == 0){
                    String password = pwd.getText().toString();
                    String password0 = surepwd.getText().toString();
                    if(password.equals(password0)){
                        Password p = new Password();
                        p.setPwd(password);
                        p.save();
                        pwd.setText("");
                        surepwd.setText("");
                        Toast.makeText(PasswordActivity.this,"密码设置成功",Toast.LENGTH_SHORT);
                    }else {
                        Toast.makeText(PasswordActivity.this,"两次密码不对",Toast.LENGTH_SHORT);
                        pwd.setText("");
                        surepwd.setText("");
                    }
                }else {
                    String old = oldpwd.getText().toString();
                    List<Password> olddata = DataSupport.select("pwd").where("id = ?","1").find(Password.class);
                    if(old.equals(olddata.get(0).getPwd())){
                        String password = pwd.getText().toString();
                        String password0 = surepwd.getText().toString();
                        if(password.equals(password0)){
                            Password p = new Password();
                            p.setPwd(password);
                            p.updateAll("id = ?","1");
                            pwd.setText("");
                            surepwd.setText("");
                            Toast.makeText(PasswordActivity.this,"密码更换成功",Toast.LENGTH_SHORT);
                        }else {
                            Toast.makeText(PasswordActivity.this,"两次密码不对",Toast.LENGTH_SHORT);
                            pwd.setText("");
                            surepwd.setText("");
                        }
                    }else{
                        Toast.makeText(PasswordActivity.this,"旧密码不对",Toast.LENGTH_SHORT);
                    }
                }

            }
        });

    }
}
