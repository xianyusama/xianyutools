package com.xianyusama.xutildemo.model;

import java.util.List;

/**
 * Created by xiao on 2017/3/29.
 */

public class Result {
    private String stat;

    private List<Data> data;

    public void setStat(String stat){
        this.stat = stat;
    }
    public String getStat(){
        return this.stat;
    }
    public void setData(List<Data> data){
        this.data = data;
    }
    public List<Data> getData(){
        return this.data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "stat='" + stat + '\'' +
                ", data=" + data +
                '}';
    }
}
