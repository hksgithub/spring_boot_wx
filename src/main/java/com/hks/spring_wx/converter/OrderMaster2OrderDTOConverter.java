package com.hks.spring_wx.converter;

import com.hks.spring_wx.dto.OrderDTO;
import com.hks.spring_wx.entity.OrderMaster;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 订单数据转换
 * Created by xiaohe
 * 2018/8/17 15:18
 */
public class OrderMaster2OrderDTOConverter {

    /**
     * 主订单OrderMaster转换成OrderDTO
     * @param orderMaster
     * @return
     */
    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }

    /**
     * 主订单 List<OrderMaster> 转换成  List<OrderDTO>
     * @param orderMasterList
     * @return
     */
    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
        return orderMasterList.stream()
                .map(e -> convert(e))
                .collect(Collectors.toList());
    }
}
