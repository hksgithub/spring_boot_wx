package com.hks.spring_wx.service;

import com.hks.spring_wx.entity.ProductCategory;

import java.util.List;

/**
 * 类目
 * Created by xiaohe
 * 2018/8/15 15:15
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    /**
     * 根据类目编号in()查询
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
