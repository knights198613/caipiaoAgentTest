package com.jd.matchagenttest.domains;

/**
 * Created by weijiang
 * Date: 2016/11/21
 * Desc: 代理商接口返回的结果封装类
 */
public class ResponseResult {

    private int statusCode;

    private String resultStr;


    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getResultStr() {
        return resultStr;
    }

    public void setResultStr(String resultStr) {
        this.resultStr = resultStr;
    }
}
