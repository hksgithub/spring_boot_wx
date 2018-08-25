package com.hks.spring_wx.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by xiaohe
 * 2018/8/20 20:16
 */
public class JsonUtil {

    /**
     * object转json
     * @param object
     * @return
     */
    public static String objectToJson(Object object){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
