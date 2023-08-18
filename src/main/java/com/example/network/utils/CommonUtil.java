package com.example.network.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.network.dto.ComboDTO;

import java.util.Map;
import java.util.Objects;

public class CommonUtil {
    public static Map<String, Object> objectToMap(Object object) {
        // 将对象转换为 JSON 字符串
        String jsonString = JSON.toJSONString(object);
        // 将 JSON 字符串转换为 JSONObject
        JSONObject jsonObject = JSON.parseObject(jsonString);
        // 将 JSONObject 转换为 Map<String, Object>
        Map<String, Object> map = jsonObject.getInnerMap();
        return map;
    }

    public static <T> T copyProperties(Object source, Class<T> clz) {
        JSONObject jsonObject = (JSONObject) JSON.toJSON(source);
        return JSON.toJavaObject(jsonObject, clz);
    }

    public static String objectToStr(Object object) {
        if (Objects.isNull(object)) {
            return null;
        }
        return JSON.toJSONString(object);
    }

    public static Map<String, Object> strToMap(String str) {
        if (Objects.isNull(str)) {
            return null;
        }
        return JSON.parseObject(str, Map.class);
    }

    public static Object strToObject(String str) {
        if (Objects.isNull(str)) {
            return null;
        }
        return JSON.parse(str);
    }
}
