package com.hks.spring_wx.controller;

import com.hks.spring_wx.VO.ProductInfoVO;
import com.hks.spring_wx.VO.ProductVO;
import com.hks.spring_wx.VO.ResultVO;
import com.hks.spring_wx.entity.ProductCategory;
import com.hks.spring_wx.entity.ProductInfo;
import com.hks.spring_wx.service.CategoryService;
import com.hks.spring_wx.service.ProductService;
import com.hks.spring_wx.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 * Created by xiaohe
 * 2018/8/16 11:33
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 返回给买家端的类目商品
     * @return
     */
    @GetMapping("/list")
    public ResultVO list(){

        //1、查询所有上架的商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2、查询类目（一次性查询）
//        List<Integer> categoryTypeList = new ArrayList<>();
//        //传统的遍历方法
//        for(ProductInfo productInfo : productInfoList){
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        //精简方法（java8 lambda）
        //先转成String,然后从map中获取相应的字段，最后以List收集
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //3、数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory : productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo : productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    //对象拷贝
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }
}
