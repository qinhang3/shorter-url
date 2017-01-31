package com;

import com.exception.GameException;
import com.exception.ResultCode;

/**
 * Created by hang on 17/1/20.
 */
public class Response<T> {
    private long code = 10000;
    private String message = null;
    private T data;

    private Response(ResultCode resultCode){
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    private Response(GameException e){
        this(e.getResultCode());
    }

    public static Response asResultCode(ResultCode resultCode) {
        return new Response(resultCode);
    }
    public static Response asException(Exception e){
        if (e instanceof GameException){
            return new Response((GameException) e);
        } else {
            return new Response(ResultCode.SYSTEM_ERROR);
        }
    }

    public static <T> Response asSuccess(T data){
        Response<T> response = new Response<T>(ResultCode.SUCCESS);
        response.data = data;
        return response;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
