package com.lib.bookbrain.utils;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONWriter;
import com.lib.bookbrain.exception.DataStructureException;
import com.lib.bookbrain.model.entity.User;

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
	try {
		return JSON.toJSONString(o,
				JSONWriter.Feature.NotWriteDefaultValue, // 不写字段默认值
				JSONWriter.Feature.NotWriteEmptyArray); // 不写空数组
	} catch (Exception e) {
		// todo
		throw new DataStructureException();
	}
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
	try {
		return JSON.parseObject(s, c, JSONReader.Feature.TrimString);
	} catch (Exception e) {
		// todo
		throw new DataStructureException();
	}
}

public static void main(String[] args) {
	User user = new User();
	System.out.println(stringify(user));
}
}
