package com.electronicbookkeeping.android.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.electronicbookkeeping.android.BaseActivity;
import com.electronicbookkeeping.android.R;
import com.electronicbookkeeping.android.db.Consumption;
import com.electronicbookkeeping.android.db.Income;

import org.litepal.crud.DataSupport;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BookkeppActivity extends BaseActivity {

    private Button inorout ;
    private TextView title;
    private Spinner spinner;
    private ArrayAdapter<String> adapter;
    private LinearLayout consumlayout;
    private LinearLayout incomelayout;
    private Button back;
    private EditText editconsum;
    private Button consumok;
    private TextView cmoneytext;
    private EditText editincome;
    private Button  incomeok;
    private TextView imoneytext;


    private static final String[] types = {"请选择","饮食","医疗","生活用品","游玩","交通","教育","衣服","其他"};
    static boolean isincome = false;
    private static String type = "请选择";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookkepp);

        spinner = (Spinner) findViewById(R.id.spinner_consum);
        inorout = (Button) findViewById(R.id.button_in_out);
        title = (TextView) findViewById(R.id.title_text);
        consumlayout = (LinearLayout) findViewById(R.id.user_consumption);
        incomelayout = (LinearLayout) findViewById(R.id.user_income);
        back = (Button) findViewById(R.id.back_button);
        editconsum = (EditText) findViewById(R.id.edit_consum_money);
        consumok = (Button) findViewById(R.id.button_cousum_ok);
        cmoneytext = (TextView) findViewById(R.id.text_consum_money);
        editincome = (EditText) findViewById(R.id.edit_income_money);
        incomeok = (Button) findViewById(R.id.button_income_ok);
        imoneytext = (TextView) findViewById(R.id.text_income_money);


        editconsum.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        editincome.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);


        incomeok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String incometext = editincome.getText().toString();


                if(incometext.equals("")){
                    Toast.makeText(BookkeppActivity.this,"请输入收入金额",Toast.LENGTH_SHORT).show();
                }else {
                    Double inmoney = Double.valueOf(editincome.getText().toString());
                    Log.i("shock","editincome");

                    Calendar cal = Calendar.getInstance();
                    int year = cal.get(Calendar.YEAR);
                    int month = cal.get(Calendar.MONTH)+1;
                    int day = cal.get(Calendar.DATE);
                    String inTime = cal.getTime().toString();

                    Income income = new Income();
                    income.setInMoney(inmoney);
                    income.setInYear(year);
                    income.setInMonth(month);
                    income.setInDay(day);
                    income.setInTime(inTime);
                    income.save();
                    Log.i("shock","save");
                    List<Income> inlist = DataSupport
                            .where("inYear = ? and inMonth = ? and inDay = ? "
                                    ,String.valueOf(year),String.valueOf(month),String.valueOf(day))
                            .find(Income.class);
                    Double todaymoney = 0.0;
                    for (Income i : inlist){
                        todaymoney = todaymoney + i.getInMoney();
                    }
                    Log.i("shock","incomemoney");
                    imoneytext.setText("今天总共收入了"+todaymoney+"元");
                    editincome.setText("");
                }
            }
        });

        consumok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String consum = editconsum.getText().toString();

                if(consum.equals("")){
                    Toast.makeText(BookkeppActivity.this,"请输入支出数目",Toast.LENGTH_SHORT).show();
                }else {
                    Double cmoney = Double.valueOf(editconsum.getText().toString());
                    if(type.equals("请选择")){
                        Toast.makeText(BookkeppActivity.this,"请选择支出类型",Toast.LENGTH_SHORT).show();
                    }else{
                        Calendar cal = Calendar.getInstance();
                        int year = cal.get(Calendar.YEAR);
                        int month = cal.get(Calendar.MONTH)+1;
                        int day = cal.get(Calendar.DATE);
                        String ctime = cal.getTime().toString();
                        Consumption consumption = new Consumption();
                        consumption.setcMoney(cmoney);
                        consumption.setcName(type);
                        consumption.setcTime(ctime);
                        consumption.setcYear(year);
                        consumption.setcMonth(month);
                        consumption.setcDay(day);

                        consumption.save();
                        List<Consumption> clist = DataSupport
                                .where("cYear = ? and cMonth = ? and cDay = ? "
                                        ,String.valueOf(year),String.valueOf(month),String.valueOf(day))
                                .find(Consumption.class);

                        Double todaymoney = 0.0;
                        for (Consumption c : clist){
                            todaymoney = todaymoney+c.getcMoney();
                        }

                        cmoneytext.setText("今天总共消费了"+todaymoney+"元");
                        editconsum.setText("");
                    }
                }

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BookkeppActivity.super.onBackPressed();
            }
        });

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,types);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                type = types[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        inorout();

        inorout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isincome){
                    isincome = false;
                }else {
                    isincome = true;
                }
                inorout();
            }
        });

    }


    private void inorout(){
        if(isincome){
            inorout.setText("支出");
            title.setText("记录收入");
            incomelayout.setVisibility(View.VISIBLE);
            consumlayout.setVisibility(View.GONE);
        }else {
            inorout.setText("收入");
            title.setText("记录支出");
            incomelayout.setVisibility(View.GONE);
            consumlayout.setVisibility(View.VISIBLE);
        }
    }
}
