package com.exception;

/**
 * Created by hang on 17/1/22.
 */
public enum ResultCode{

    SYSTEM_ERROR(-1L,"系统异常"),
    SUCCESS(10000L,null),

    POS_HAS_SET(10001L,"该位置已有棋子"),
    NOT_YOUR_ROUND(10002L,"不是你的回合"),
    OUT_OF_INDEX(10003L,"超出棋盘大小"),

    NO_SUCH_GAME(20001L,"游戏ID不存在"),
    NO_SUCH_PLAYER(20002L, "角色ID不存在"),
    ;

    private long code;
    private String message;

    ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
