package utils;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * JSON 工具类
 *
 * @author xiezm
 */
public class JSONUtils {

    private static Logger logger = LoggerFactory.getLogger(JSONUtils.class);

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * json格式字符 转 对象
     *
     * @param jsonString json格式字符
     * @return JSON 字符
     */
    public static <T> T stringToObject(String jsonString, Class<T> clazz) {
        try {
            return objectMapper.readValue(jsonString, clazz);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * json格式字符 转 集合
     *
     * @param jsonString      json格式字符
     * @param valueType       集合内对象的类型
     * @return JSON 字符
     */
    public static <T> T stringToList(String jsonString, Class<?>... valueType) {
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, valueType);
        try {
            return objectMapper.readValue(jsonString, javaType);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * json格式字符 转 集合
     *
     * @param jsonString      json格式字符
     * @param valueType       集合内对象的类型
     * @return JSON 字符
     */
    public static <T> T stringToSet(String jsonString, Class<?>... valueType) {
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(Set.class, valueType);
        try {
            return objectMapper.readValue(jsonString, javaType);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * Entity/vo/pojo 等 bean对象 转 JSON 字符
     *
     * @param object 实体/VO/POJO 等bean对象
     * @return JSON 字符
     */
    public static String objectToString(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * Entity/vo/pojo 等 bean的 数组对象 转 JSON 字符
     *
     * @param objectArray 实体/VO/POJO 等bean的数组对象
     * @return JSON 字符
     */
    public static String arrayToString(Object[] objectArray) {
        StringBuilder jsonSB = new StringBuilder();
        jsonSB.append('[');
        for (int i = 0; i < objectArray.length; i++) {
            jsonSB.append(objectToString(objectArray[i]));
            if (i < objectArray.length - 1) {
                jsonSB.append(',');
            }
        }
        jsonSB.append(']');
        return jsonSB.toString();
    }

    /**
     * Entity/vo/pojo 等bean的 集合对象 转 JSON 字符
     *
     * @param list 实体/VO/POJO 等bean的集合对象
     * @return JSON 字符
     */
    public static String listToString(List<?> list) {
        try {
            return objectMapper.writeValueAsString(list);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * Map对象 转 JSON 字符
     *
     * @param map Map对象
     * @return JSON 字符
     */
    public static String mapToString(Map<?, ?> map) {
        try {
            return objectMapper.writeValueAsString(map);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * json字符 转Java Bean
     *
     * @param jsonString  json字符
     * @param toValueType   Bean 的 Class
     * @param <T>
     * @return
     */
    public static <T> T stringToBean(String jsonString, Class<T> toValueType) {
        try {
            return objectMapper.readValue(jsonString, toValueType);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 序列化对象 转Java Bean
     *
     * @param object 序列化对象
     * @param toValueType  Bean 的 Class
     * @param <T>
     * @return
     */
    public static <T> T objectToBean(Object object, Class<T> toValueType) {
        return objectMapper.convertValue(object, toValueType);
    }

    /**
     *  集合序列化对象 转 List
     *
     * @param object  集合序列化对象
     * @param valueType  集合里 Bean 的 Class
     * @param <T>
     * @return
     */
    public static <T> T objectToList(Object object, Class<?> valueType) {
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, valueType);
        return objectMapper.convertValue(object, javaType);
    }

    /**
     *  集合序列化对象 转 Set
     *
     * @param object 集合序列化对象
     * @param valueType 集合里 Bean 的 Class
     * @param <T>
     * @return
     */
    public static <T> T objectToSet(Object object, Class<?> valueType) {
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(Set.class, valueType);
        return objectMapper.convertValue(object, javaType);
    }
}
