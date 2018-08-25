package com.hks.spring_wx.repository;

import com.hks.spring_wx.entity.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 订单商品
 * Created by xiaohe
 * 2018/8/16 21:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void save(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("11111");
        orderDetail.setOrderId("3243432");
        orderDetail.setProductId("123321");
        orderDetail.setProductName("鸭脖");
        orderDetail.setProductIcon("https://xxxx.jpg");
        orderDetail.setProductPrice(new BigDecimal(23));
        orderDetail.setProductQuantity(23);
        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotEquals(null,result);
    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> orderDetailList = repository.findByOrderId("3243432");
        Assert.assertNotEquals(0,orderDetailList.size());
    }
}