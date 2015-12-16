package com.ecloud.common;

import java.text.SimpleDateFormat;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JSON处理工具类
 * @author 
 */
public class JsonUtils {
    private static final Logger       log          = LoggerFactory.getLogger(JsonUtils.class);

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        objectMapper.setSerializationInclusion(Include.NON_NULL);
    }

    /**
     * 转换对象为JSON字符串
     * @param obj
     * @return
     */
    public static String toJson(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * 转换JSON字符串为对象
     * @param obj
     * @return
     */
    public static <T> T toObj(String json, Class<T> clazz) {
        try {
        	if (StringUtils.isBlank(json)) {
				return null;
			}
            Object fromValue = objectMapper.readValue(json, Object.class);
            return objectMapper.convertValue(fromValue, clazz);
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * 转换JSON字符串为对象
     * @param json
     * @param type
     * @return
     */
    public static <T> T toObj(String json,TypeReference<T> type){
        try{
            Object fromValue=objectMapper.readValue(json, Object.class);
            return objectMapper.convertValue(fromValue,type);
        }catch(Exception e){
            log.error(e.getMessage(),e);
            return null;
        }
    }
}
