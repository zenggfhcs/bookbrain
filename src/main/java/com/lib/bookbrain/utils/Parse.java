package com.lib.bookbrain.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parse {
/**
 * 将 com.lib.service.impl.<b>XXX</b>DefaultService
 * 转换成 com.lib.model.<b>XXX</b>
 *
 * @param serviceClass com.lib.service.impl.<b>XXX</b>DefaultService 形式字符串
 * @return com.lib.model.<b>XXX</b> 字符串
 */
public static String serviceToDataClass(String serviceClass) {
   String _regex = ".*\\.(.*)DefaultService";
   // 创建 Pattern 对象
   Pattern _pattern = Pattern.compile(_regex);
   // 创建 Matcher 对象
   Matcher _matcher = _pattern.matcher(serviceClass);
   if (_matcher.find()) {
      return "com.lib.model." + _matcher.group(1);
   }
   return serviceClass;
}
}
