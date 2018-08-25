package com.hks.spring_wx.VO;

import lombok.Data;

/**
 * http请求返回的最外层对象
 * Created by xiaohe
 * 2018/8/16 11:46
 */
@Data
public class ResultVO<T> {

    //错误码
    private Integer code;

    //提示信息
    private String msg;

    //具体内容
    private T data;
}
