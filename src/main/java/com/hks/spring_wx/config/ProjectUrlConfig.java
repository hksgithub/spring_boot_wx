package com.hks.spring_wx.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by xiaohe
 * 2018/8/21 11:41
 */
@Data
@ConfigurationProperties(prefix = "projectUrl")
@Component
public class ProjectUrlConfig {

    //微信公众平台授权URL
    private String wechatMpAuthorize;

    //微信开放平台授权URL
    private String wechatOpenAuthorize;

    //点餐系统
    private String sell;
}
