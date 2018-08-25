package com.hks.spring_wx.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hks.spring_wx.entity.OrderDetail;
import com.hks.spring_wx.enums.OrderStatusEnum;
import com.hks.spring_wx.enums.PayStatusEnum;
import com.hks.spring_wx.utils.EnumUtil;
import com.hks.spring_wx.utils.serializer.Date2LongSerializer;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单
 * Created by xiaohe
 * 2018/8/16 22:11
 */
@Data
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

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
    private Integer orderStatus;

    //支付状态，默认为0未支付
    private Integer payStatus;

    //创建时间
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    //更新时间
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    //订单详情列表
    List<OrderDetail> orderDetailList;

    @JsonIgnore //返回对象忽略
    public OrderStatusEnum getOrderStatusEnum(){
        return EnumUtil.getByCode(orderStatus,OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum(){
        return EnumUtil.getByCode(payStatus,PayStatusEnum.class);
    }

}
