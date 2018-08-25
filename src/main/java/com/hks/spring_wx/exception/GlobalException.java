package com.hks.spring_wx.exception;

import com.hks.spring_wx.enums.ResultEnum;

/**
 * 全局异常
 * Created by xiaohe
 * 2018/8/16 23:00
 */
public class GlobalException extends RuntimeException {

    private Integer code;

    public GlobalException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public GlobalException(Integer code,String message) {
        super(message);
        this.code = code;
    }
}
