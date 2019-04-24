package com.zgcwkj.utils;

import java.util.List;

/**
 * 返回数据（Layui）
 * 
 * @param <T> 实体名称
 * @author zgcwkj
 * @since 2019-01-03
 */
public class ReturnLayui<T> {

    // 空的实体类
    public static class _null {
    }

    // 代码
    private Integer code;
    // 行数
    private String count;
    // 数据
    private List<T> data;
    // 消息
    private String msg;

    /**
     * @return the code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * @return the count
     */
    public String getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(String count) {
        this.count = count;
    }

    /**
     * @return the data
     */
    public List<T> getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(List<T> data) {
        this.data = data;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

}