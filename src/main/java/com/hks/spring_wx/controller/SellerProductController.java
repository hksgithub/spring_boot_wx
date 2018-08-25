package com.hks.spring_wx.controller;

import com.hks.spring_wx.dto.OrderDTO;
import com.hks.spring_wx.entity.ProductInfo;
import com.hks.spring_wx.service.ProductService;
import com.lly835.bestpay.rest.type.Get;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 买家端商品
 * Created by xiaohe
 * 2018/8/23 12:26
 */
@RequestMapping("/seller/product")
@Controller
public class SellerProductController {

    @Autowired
    private ProductService productService;

    /**
     * 商品列表
     * @param page
     * @param size
     * @param map
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page
            ,@RequestParam(value = "size",defaultValue = "10") Integer size
            ,Map<String,Object> map){
        PageRequest pageRequest = new PageRequest(page - 1,size);
        Page<ProductInfo> productInfoPage = productService.findAll(pageRequest);

        map.put("productInfoPage", productInfoPage);
        map.put("currentPage", page);
        map.put("size", size);

        return new ModelAndView("product/list",map);
    }
}
