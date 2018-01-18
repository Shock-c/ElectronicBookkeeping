package com.electronicbookkeeping.android.db;

import org.litepal.crud.DataSupport;

/**
 * Created by shock on 2018/1/18.
 */

public class Password extends DataSupport{

    private String pwd;

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }


}
