package com.hks.spring_wx.repository;

import com.hks.spring_wx.entity.OrderMaster;
import org.hibernate.criterion.Order;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by xiaohe
 * 2018/8/16 21:30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID = "2222222";

    @Test
    public void save(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("3243432");
        orderMaster.setBuyerName("bb");
        orderMaster.setBuyerPhone("13124213213");
        orderMaster.setBuyerAddress("cccccccc");
        orderMaster.setBuyerOpenid("2222222");
        orderMaster.setOrderAmount(new BigDecimal(23));
        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotEquals(null,result);
    }

    @Test
    public void findByBuyerOpenid() {
        PageRequest request = new PageRequest(0,3);
        Page<OrderMaster> orderMasterList = repository.findByBuyerOpenid(OPENID,request);
        Assert.assertNotEquals(0,orderMasterList.getTotalElements());
    }
}