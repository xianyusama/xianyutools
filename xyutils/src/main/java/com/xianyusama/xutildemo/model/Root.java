package com.xianyusama.xutildemo.model;

/**
 * Created by xiao on 2017/3/29.
 */

public class Root {
    private String reason;

    private Result result;

    private int error_code;

    public void setReason(String reason){
        this.reason = reason;
    }
    public String getReason(){
        return this.reason;
    }
    public void setResult(Result result){
        this.result = result;
    }
    public Result getResult(){
        return this.result;
    }
    public void setError_code(int error_code){
        this.error_code = error_code;
    }
    public int getError_code(){
        return this.error_code;
    }

    @Override
    public String toString() {
        return "Root{" +
                "reason='" + reason + '\'' +
                ", result=" + result +
                ", error_code=" + error_code +
                '}';
    }
}
