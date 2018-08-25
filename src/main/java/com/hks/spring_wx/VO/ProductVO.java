package com.hks.spring_wx.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.io.Serializable;
import java.util.List;

/**
 * 商品（包含类目）
 * Created by xiaohe
 * 2018/8/16 12:02
 */
@Data
public class ProductVO implements Serializable {

    @JsonProperty("name") //返回前端的就是name
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;

}
