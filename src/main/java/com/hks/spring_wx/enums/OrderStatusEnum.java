package com.hks.spring_wx.enums;

import lombok.Getter;

/**
 * 订单状态
 * Created by xiaohe
 * 2018/8/16 21:03
 */
@Getter
public enum OrderStatusEnum implements CodeEnum {
    NEW(0,"新下单"),
    FINISHED(1,"完结"),
    CANCEL(2,"已取消")
    ;

    private Integer code;

    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
