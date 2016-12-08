package com.exception;

/**
 * Created by hang.qin on 2016/12/8.
 */
public class GameException extends Exception {
    public ResultCode resultCode;

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

    public enum ResultCode{

        POS_HAS_SET(10001L,"该位置已有棋子"),
        NOT_YOUR_ROUND(10002L,"不是你的回合"),
        OUT_OF_INDEX(10003L,"超出棋盘大小");

        private long code;
        private String message;

        ResultCode(long code, String message) {
            this.code = code;
            this.message = message;
        }
    }
}
