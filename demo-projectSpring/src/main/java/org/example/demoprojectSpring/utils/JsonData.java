package org.example.demoprojectSpring.utils;


/**
 *  接口类工具类
* */
public class JsonData {

    private int code;
    private Object data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public JsonData() {
    }

    public JsonData(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public JsonData(int code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    //成功之后返回的状态码
    public static JsonData buildSuccess(Object data) {
        return new JsonData(0, data);
    }
    // 失败之后返回的状态码
    public static JsonData buildError (String message) {
        return new JsonData(-1, " ", message);
    }
    public static JsonData buildError(int code, String message) {
        return new JsonData(code, " ", message);
    }
}
