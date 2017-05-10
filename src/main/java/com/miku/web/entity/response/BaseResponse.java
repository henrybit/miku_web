package com.miku.web.entity.response;

import java.util.List;

/**
 * 基本应答
 * Created by henrybit on 2017/3/16.
 * @version 1.0
 */
public class BaseResponse {
    protected int code;
    protected String message;
    protected Object data;
    protected int total;
    protected List rows;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
