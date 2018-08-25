package com.hks.spring_wx.repository;

import com.hks.spring_wx.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 订单商品
 * Created by xiaohe
 * 2018/8/16 21:28
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {

    List<OrderDetail> findByOrderId(String orderId);
}
