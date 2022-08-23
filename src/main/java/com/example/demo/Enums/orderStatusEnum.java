package com.example.demo.Enums;


/**
 * Created By Zhu Lin on 3/14/2018.
 */
public enum orderStatusEnum implements codeEnum {
    NEW(0, "New OrderMain"),
    FINISHED(1, "Finished"),
    CANCELED(2, "Canceled")
    ;

    private  int code;
    private String msg;

    orderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
