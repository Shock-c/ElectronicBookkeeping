package com.electronicbookkeeping.android.db;

import org.litepal.crud.DataSupport;

import java.util.Date;

/**
 * Created by shock on 2018/1/19.
 */

public class Income extends DataSupport {
    private int id;
    private Double inMoney;
    private int inYear;
    private int inMonth;
    private int inDay;
    private String inTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getInMoney() {
        return inMoney;
    }

    public void setInMoney(Double inMoney) {
        this.inMoney = inMoney;
    }

    public int getInYear() {
        return inYear;
    }

    public void setInYear(int inYear) {
        this.inYear = inYear;
    }

    public int getInMonth() {
        return inMonth;
    }

    public void setInMonth(int inMonth) {
        this.inMonth = inMonth;
    }

    public int getInDay() {
        return inDay;
    }

    public void setInDay(int inDay) {
        this.inDay = inDay;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }
}
