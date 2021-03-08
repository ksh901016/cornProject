package com.corn.toyproject.core.common.utils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JacksonUtils {
    private final ObjectMapper objectMapper;

    private JacksonUtils(){
        objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.setSerializationInclusion(Include.NON_NULL);
    }

    public static JacksonUtils getInstance(){
        return new JacksonUtils();
    }


    public static ObjectMapper getMapper(){
        return getInstance().objectMapper;
    }

    public static <T> T toObject(Object obj, Class<T> cls){
        return getMapper().convertValue(obj, cls);
    }


}
