package com.hks.spring_wx.service.impl;

import com.hks.spring_wx.dto.OrderDTO;
import com.hks.spring_wx.service.OrderService;
import com.hks.spring_wx.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 微信支付
 * Created by xiaohe
 * 2018/8/20 19:54
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {

    @Autowired
    private PayService payService;

    @Autowired
    private OrderService orderService;

    @Test
    public void create() {
        OrderDTO orderDTO = orderService.findOne("1534577463744236220");
        payService.create(orderDTO);
    }
}