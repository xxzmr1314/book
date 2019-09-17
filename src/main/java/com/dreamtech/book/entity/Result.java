package com.dreamtech.book.entity;

/**
 * Created by xx on 2019/1/20.
 */
public class Result<T> {

    /**
     * 错误码 0表示失败  1表示成功
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String msg;

    /**
     * 返回的具体内容
     */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }



    public static Result success(Object object,String msg){
        Result result = new Result();
        result.setCode(1);
        result.setMsg(msg);
        result.setData(object);
        return  result;
    }
    public static Result successNoData(){
        return  success(null,"成功");
    }
    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return  result;
    }

}
