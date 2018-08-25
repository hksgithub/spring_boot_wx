package com.hks.spring_wx.repository;

import com.hks.spring_wx.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 类目
 * Created by xiaohe
 * 2018/8/14 21:24
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

    //规定字段查询 in()
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
