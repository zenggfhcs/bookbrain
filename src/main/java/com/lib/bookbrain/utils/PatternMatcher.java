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
      Matcher _matcher = getMatcher(str, reg); // 创建模式匹配对象
      if (_matcher.find() && index <= _matcher.groupCount()) { // 匹配成功并且存在希望获取到的分组下标有效
         return _matcher.group(index); // 返回目标
      }
      return str; // 匹配失败 返回原字符串
   }

   /**
    * 获取匹配成功的所有分组
    *
    * @param str 匹配字符串
    * @param reg 模式字符串
    * @return 所有分组
    */
   public String[] getGroup(String str, String reg) {
      Matcher _matcher = getMatcher(str, reg); // 创建模式匹配对象
      String[] groups = new String[_matcher.groupCount() + 1]; // 创建分组数组 groupCount 返回的是最后一个分组的下标
      if (_matcher.find()) { // 匹配成功
         for (int i = 0; i <= _matcher.groupCount(); i++) { // 循环获取分组
            groups[i] = _matcher.group(i); // 记录分组
         }
      }
      return groups; // 返回分组
   }

   /**
    * 生成模式匹配对象
    *
    * @param str 匹配字符串
    * @param reg 模式字符串
    * @return 使用 str 、reg 生成的模式匹配对象
    */
   private Matcher getMatcher(String str, String reg) {
      Pattern _pattern = Pattern.compile(reg); // 创建 Pattern 对象
      return _pattern.matcher(str); // 创建 Matcher 对象
   }
}