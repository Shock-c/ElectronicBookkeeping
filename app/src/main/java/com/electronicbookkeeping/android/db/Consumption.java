package com.electronicbookkeeping.android.db;

import org.litepal.crud.DataSupport;

/**
 * Created by shock on 2018/1/18.
 * 消费记录属性
 */

public class Consumption extends DataSupport{

    private int id;             //数据库中的头id
    private String cName;       //消费的类目
    private String cMoney;      //消费金额
    private String cTime;       //消费时间
//    private String cDay;        //消费时间  日
//    private String cMonth;      //消费时间  月
//    private String cYear;       //消费时间  年


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

    public String getcMoney() {
        return cMoney;
    }

    public void setcMoney(String cMoney) {
        this.cMoney = cMoney;
    }

    public String getcTime() {
        return cTime;
    }

    public void setcTime(String cTime) {
        this.cTime = cTime;
    }
}
