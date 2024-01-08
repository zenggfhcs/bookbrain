package com.lib.bookbrain.utils;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 模式匹配封装
 *
 * @author yunxia
 */
@Component
public class PatternMatcher {
/**
 * 静态生成器
 *
 * @return PatternMatcher 实例
 */
public static PatternMatcher generate() {
   return new PatternMatcher();
}

/**
 * 模式匹配，获取指定正则表达式匹配的指定分组
 *
 * @param str   匹配字符串
 * @param reg   模式字符串
 * @param index 分组下标
 * @return 成功则返回期望匹配结果，失败则返回原有匹配字符串
 */
public String getGroup(String str, String reg, int index) {
   Matcher _matcher = getMatcher(str, reg);
   
   // 匹配成功并且存在希望获取到的分组下标有效
   if (_matcher.find() && index <= _matcher.groupCount()) {
      return _matcher.group(index);
   }
   // 否则返回原字符串
   return str;
}

/**
 * 获取匹配成功的所有分组
 *
 * @param str 匹配字符串
 * @param reg 模式字符串
 * @return 所有分组
 */
public String[] getGroup(String str, String reg) {
   Matcher _matcher = getMatcher(str, reg);
   
   String[] groups = new String[_matcher.groupCount() + 1];
   if (_matcher.find()) {
      int i = 0;
      for (; i <= _matcher.groupCount(); i++) {
         groups[i] = _matcher.group(i);
      }
   }
   return groups;
}

/**
 * 生成模式匹配对象
 *
 * @param str 匹配字符串
 * @param reg 模式字符串
 * @return 使用 str 、reg 生成的模式匹配对象
 */
private Matcher getMatcher(String str, String reg) {
   // 创建 Pattern 对象
   Pattern _pattern = Pattern.compile(reg);
   // 创建 Matcher 对象
   return _pattern.matcher(str);
}
}