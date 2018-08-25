package com.hks.spring_wx.service.impl;

import com.hks.spring_wx.dto.OrderDTO;
import com.hks.spring_wx.enums.ResultEnum;
import com.hks.spring_wx.exception.GlobalException;
import com.hks.spring_wx.service.BuyerService;
import com.hks.spring_wx.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 买家
 * Created by xiaohe
 * 2018/8/18 17:58
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    /**
     * 查询买家一个订单
     * @param openid
     * @param orderId
     * @return
     */
    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        return checkOrderOwner(openid,orderId);
    }

    /**
     * 取消订单
     * @param openid
     * @param orderId
     * @return
     */
    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid,orderId);
        if(orderDTO==null){
            log.error("【取消订单】查不到该订单，orderId = {}",orderId);
            throw new GlobalException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }

    public OrderDTO checkOrderOwner(String openid, String orderId) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if(orderDTO==null){
            return null;
        }
        //判断是否是自己的订单
        if(!orderDTO.getBuyerOpenid().equals(openid)){
            log.error("【查询订单】订单的openid不一致，openid = {},orderDTO = {}",openid,orderDTO);
            throw new GlobalException(ResultEnum.ORDER_OWNER_ERROR);
        }

        return orderDTO;
    }
}
