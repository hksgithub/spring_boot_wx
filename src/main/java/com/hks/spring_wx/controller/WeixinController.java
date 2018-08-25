package com.hks.spring_wx.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 微信授权回调
 * Created by xiaohe
 * 2018/8/19 15:35
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {

    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code){
        log.info("进入auth()方法。。。。");
        log.info("code = {}",code);

        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx8ba1785b9cb8c707&secret=ccbf85ed82f4add0834546827fc708e8&code=" + code + "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();//请求URL
        String response = restTemplate.getForObject(url, String.class);
        log.info("response={}", response);
    }
}
