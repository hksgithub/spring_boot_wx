package com.hks.spring_wx.utils;

import java.util.Random;

/**
 * 唯一主键
 * Created by xiaohe
 * 2018/8/17 10:47
 */
public class KeyUtil {

    /**
     * 生成唯一主键
     * 格式：当前毫秒数 + 六位随机数
     * @return
     */
    public static synchronized String getUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
