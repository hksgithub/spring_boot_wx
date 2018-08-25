package com.hks.spring_wx.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hks.spring_wx.dto.OrderDTO;
import com.hks.spring_wx.entity.OrderDetail;
import com.hks.spring_wx.enums.ResultEnum;
import com.hks.spring_wx.exception.GlobalException;
import com.hks.spring_wx.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 订单表单数据转换
 * Created by xiaohe
 * 2018/8/17 23:08
 */
@Slf4j
public class OrderForm2OrderDTOConverter {

    /**
     * 前端订单表单转换成orderDTO
     * @param orderForm
     * @return
     */
    public static OrderDTO convert(OrderForm orderForm){
        Gson gson = new Gson();

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try{
            //字符串转成list
            orderDetailList = gson.fromJson(orderForm.getItems(),
            new TypeToken<List<OrderDetail>>(){}.getType());
        }catch(Exception e){
            log.error("【对象转换】错误，string = {}",orderForm.getItems());
            throw new GlobalException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
