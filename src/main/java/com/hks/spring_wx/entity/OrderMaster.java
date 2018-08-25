package com.hks.spring_wx.entity;

import com.hks.spring_wx.enums.OrderStatusEnum;
import com.hks.spring_wx.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单
 * Created by xiaohe
 * 2018/8/16 20:54
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    @Id
    private String orderId;

    //买家名称
    private String buyerName;

    //买家电话
    private String buyerPhone;

    //买家地址
    private String buyerAddress;

    //买家微信openid
    private String buyerOpenid;

    //订单金额
    private BigDecimal orderAmount;

    //订单状态,默认为0新下单
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    //支付状态，默认为0未支付
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    //创建时间
    private Date createTime;

    //更新时间
    private Date updateTime;
}
