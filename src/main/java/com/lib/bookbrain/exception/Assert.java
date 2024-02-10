package com.lib.bookbrain.exception;

import com.lib.bookbrain.constant.Error;
import org.apache.logging.log4j.util.Supplier;

/**
 * bool 检查类
 *
 * @author yunxia
 */
public class Assert {
/**
 * 对 supplier 进行断言，当断言失败时，抛出一个运行时异常
 * 这个异常的具体类型由 ee 的具体值决定
 *
 * @param supplier 断言 lambda
 * @param ee       异常枚举值
 */
public static void isCorrect(Supplier<Boolean> supplier, Error ee) {
   if (supplier.get()) {
      return;
   }
   throw ee.generateError();
}
}
