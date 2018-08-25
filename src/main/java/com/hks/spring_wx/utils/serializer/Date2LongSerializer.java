package com.hks.spring_wx.utils.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

/**
 * Date类型转为Long类型
 * Created by xiaohe
 * 2018/8/18 14:53
 */
public class Date2LongSerializer extends JsonSerializer<Date> {

    //重写JsonSerializer里的serialize
    @Override
    public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers)
            throws IOException, JsonProcessingException {
        gen.writeNumber(value.getTime() / 1000);
    }
}
