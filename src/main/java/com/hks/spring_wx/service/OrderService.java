package com.hks.spring_wx.service;

import com.hks.spring_wx.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
  * 订单
 * Created by xiaohe
 * 2018/8/16 22:04
 */
public interface OrderService {

    //创建订单
    OrderDTO create(OrderDTO orderDTO);

    //查询单个订单
    OrderDTO findOne(String orderId);

    //查询订单列表
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    //取消订单
    OrderDTO cancel(OrderDTO orderDTO);

    //完结订单
    OrderDTO finish(OrderDTO orderDTO);

     //支付订单
    OrderDTO paid(OrderDTO orderDTO);

    //查询订单列表
    Page<OrderDTO> findList(Pageable pageable);

}
