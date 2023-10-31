package vn.ryan.core.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Slf4j
public class ConvertUtils {

    private ConvertUtils() {}

    public static <T> String toStringJson(T t) {
        if (t == null) {
            return null;
        }
        var mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(t);
        } catch (Exception e) {
            log.error("(toStringJson) [ERROR] convert json failed: {}", e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T toObjectJson(String json, Class<T> t) {
        if (json == null||"".equals(json) || "\"\"".equals(json)) {
            return null;
        }
        var mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            return mapper.readValue(json, t);
        } catch (Exception e) {
            log.error("(toObjectJson) [ERROR] convert json failed: {}", e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T toObjectJson(Object obj, Class<T> t) {
        if (obj == null) {
            return null;
        }
        var mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {

            return mapper.readValue((JsonParser) obj, t);
        } catch (Exception e) {
            log.error("(toObjectJson) [ERROR] convert json failed: {}", e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T toObject(Object obj, Class<T> t) {
        return toObjectJson(toStringJson(obj), t);
    }

    public static <T> List<T> toListObject(String json, Class<T> elementClass) {

        var objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        CollectionType listType =
                objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, elementClass);
        try {
            return objectMapper.readValue(json, listType);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public static <T> List<T> toListObject(Map<Object, Object> data, Class<T> t) {
        if (data == null || data.isEmpty()) {
            return Collections.emptyList();
        }
        var list = new ArrayList<T>();
        for (Map.Entry<Object, Object> entry : data.entrySet()) {
            var obj = toObject(entry.getValue(), t);
            if (obj != null) {
                list.add(obj);
            }
        }
        return list;
    }

    public static <T> List<T> toListObject(Object data, Class<T> t) {
        var jsonString = toStringJson(data);
        return toListObject(jsonString, t);
    }

}
