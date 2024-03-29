package com.lib.bookbrain.utils;

public class Parse {
private static final PatternMatcher PM;

static {
	PM = PatternMatcher.generate();
}

/**
 * 提取 **.impl.<b>(XXX)</b>ServiceImpl
 * 的 <b>XXX</b>
 *
 * @param serviceClass **.impl.<b>(XXX)</b>ServiceImpl 形式字符串
 * @return <b>XXX</b> 字符串
 */
public static String serviceToDataClass(String serviceClass) {
	return PM.getGroup(serviceClass, ".*\\.(.*)ServiceImpl", 1);
}

/**
 * 将参数字符串的首字符转换成小写
 *
 * @param s 原字符串
 * @return 转换后的字符串
 */
public static String firstLower(String s) {
	return s.toLowerCase().charAt(0) + s.substring(1);
}

}
