package com.lib.bookbrain.utils;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONWriter;


/**
 * 对 fastjson 的封装
 *
 * @author yunxia
 */
public class Json {
/**
 * 序列化，toJsonString
 *
 * @param o 需要转换成为 json 字符串的对象
 * @return 转换后的 json 字符串
 */
public static String stringify(Object o) {
   return JSON.toJSONString(o, JSONWriter.Feature.NotWriteDefaultValue, JSONWriter.Feature.NotWriteEmptyArray);
}

/**
 * 反系列化 JsonToObject
 *
 * @param s   json 字符串
 * @param c   对象对应 class 属性
 * @param <T> 任意
 * @return 反序列化对象
 */
public static <T> T parse(String s, Class<T> c) {
   return JSON.parseObject(s, c, JSONReader.Feature.TrimString);
}

/**
 * 反系列化 JsonToObject
 * 不进行类型转换
 *
 * @param s json 字符串
 * @return json 对应的 object 对象
 */
public static Object parse(String s) {
   return JSON.parseObject(s);
}
}
