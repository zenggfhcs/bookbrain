package com.lib.bookbrain.utils;

public class MyArrays {
/**
 * 封装 index < array.length ? array[index] : defaultValue;
 *
 * @param array 目标数组
 * @param index 目标下标
 * @param defaultValue 1
 * @param <T> 任何类型
 * @return 目标值或者默认值
 */
public static <T> T getOrDefault(T[] array, int index, T defaultValue) {
   if (index < array.length) {
      return array[index];
   }
   return defaultValue;
}

/**
 * 封装 index < array.length ? array[index] : null;
 *
 * @param array 目标数组
 * @param index 目标下标
 * @return 目标值或者 null
 * @param <T> 任何类型
 */
public static <T> T getOrDefault(T[] array, int index) {
   return getOrDefault(array, index, null);
}
}
