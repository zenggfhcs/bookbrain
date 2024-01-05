package com.lib.bookbrain.utils;

public class Parse {
private static final PatternMatcher PM;
static {
   PM = PatternMatcher.generate();
}

/**
 * 将 **.impl.<b>XXX</b>DefaultService
 * 转换成 com.lib.model.<b>XXX</b>
 *
 * @param serviceClass **.impl.<b>XXX</b>ServiceImpl 形式字符串
 * @return <b>XXX</b> 字符串
 */
public static String serviceToDataClass(String serviceClass) {
   return PM.getGroup(serviceClass, ".*\\.(.*)ServiceImpl", 1);
}
}