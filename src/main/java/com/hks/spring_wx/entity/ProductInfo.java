package com.hks.spring_wx.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hks.spring_wx.enums.ProductStatusEnum;
import com.hks.spring_wx.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品
 * Created by xiaohe
 * 2018/8/15 15:32
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo {

    @Id //不要忘了主键注解
    private String productId;

    //商品名称
    private String productName;

    //单价
    private BigDecimal productPrice;

    //库存
    private Integer productStock;

    //描述
    private String productDescription;

    //小图
    private String productIcon;

    //状态，0正常 1下架
    private Integer productStatus;

    //类目编号
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum(){
        return EnumUtil.getByCode(productStatus,ProductStatusEnum.class);
    }

}
