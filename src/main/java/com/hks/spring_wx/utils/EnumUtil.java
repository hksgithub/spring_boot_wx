package com.hks.spring_wx.utils;

import com.hks.spring_wx.enums.CodeEnum;

/**
 * Created by xiaohe
 * 2018/8/22 21:54
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass){
        for(T each:enumClass.getEnumConstants()){
            if(code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
