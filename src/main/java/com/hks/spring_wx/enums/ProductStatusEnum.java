package com.hks.spring_wx.enums;

import lombok.Getter;

/**
 * 商品
 * Created by xiaohe
 * 2018/8/15 21:17
 */
@Getter  //代表get/set方法
public enum ProductStatusEnum implements CodeEnum {
    UP(0,"在架"),
    DOWN(1,"下架")
    ;
    private Integer code;

    private String msg;

    ProductStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
