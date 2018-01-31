package com.electronicbookkeeping.android.db;

import org.litepal.crud.DataSupport;

import java.util.Date;

/**
 * Created by shock on 2018/1/18.
 * 消费记录属性
 */

public class Consumption extends DataSupport{

    private int id;             //数据库中的头id
    private String cName;       //消费的类目
    private Double cMoney;      //消费金额
    private String cTime;       //消费时间
    private int cDay;        //消费时间  日
    private int cMonth;      //消费时间  月
    private int cYear;       //消费时间  年


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Double getcMoney() {
        return cMoney;
    }

    public void setcMoney(Double cMoney) {
        this.cMoney = cMoney;
    }

    public String getcTime() {
        return cTime;
    }

    public void setcTime(String cTime) {
        this.cTime = cTime;
    }

    public int getcDay() {
        return cDay;
    }

    public void setcDay(int cDay) {
        this.cDay = cDay;
    }

    public int getcMonth() {
        return cMonth;
    }

    public void setcMonth(int cMonth) {
        this.cMonth = cMonth;
    }

    public int getcYear() {
        return cYear;
    }

    public void setcYear(int cYear) {
        this.cYear = cYear;
    }
}
