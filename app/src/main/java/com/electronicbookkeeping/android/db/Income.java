package com.electronicbookkeeping.android.db;

import org.litepal.crud.DataSupport;

import java.util.Date;

/**
 * Created by shock on 2018/1/19.
 */

public class Income extends DataSupport {
    private int id;

    private String inMoney;

    private Date time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInMoney() {
        return inMoney;
    }

    public void setInMoney(String inMoney) {
        this.inMoney = inMoney;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
