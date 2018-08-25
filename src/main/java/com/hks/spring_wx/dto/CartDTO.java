package com.hks.spring_wx.dto;

import lombok.Data;

/**
 * 购物车
 * Created by xiaohe
 * 2018/8/17 11:18
 */
@Data
public class CartDTO {

    //商品ID
    private String productId;

    //商品数量
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
