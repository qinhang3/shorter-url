package com.exception;

/**
 * Created by hang.qin on 2016/12/8.
 */
public class GameException extends Exception {
    private ResultCode resultCode = ResultCode.SYSTEM_ERROR;

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public GameException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public GameException(String message, ResultCode resultCode) {
        super(message);
        this.resultCode = resultCode;
    }

    public GameException(String message, Throwable cause, ResultCode resultCode) {
        super(message, cause);
        this.resultCode = resultCode;
    }

    public GameException(Throwable cause, ResultCode resultCode) {
        super(cause);
        this.resultCode = resultCode;
    }

    public GameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ResultCode resultCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.resultCode = resultCode;
    }


}
