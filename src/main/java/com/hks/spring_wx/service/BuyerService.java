package com.hks.spring_wx.service;

import com.hks.spring_wx.dto.OrderDTO;

/**
 * 买家
 * Created by xiaohe
 * 2018/8/18 17:56
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid,String orderId);

}
